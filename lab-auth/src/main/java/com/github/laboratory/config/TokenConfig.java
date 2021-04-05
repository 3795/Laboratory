package com.github.laboratory.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.code.AuthorizationCodeServices;
import org.springframework.security.oauth2.provider.code.JdbcAuthorizationCodeServices;
import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

import javax.sql.DataSource;
import java.util.Collections;

/**
 * @author qihao
 * @description Token配置
 * @date 2021/3/29 11:57
 */
@Configuration
public class TokenConfig {

    private final static String SIGNING_KEY = "laboratory_auth";

    @Bean
    public TokenStore tokenStore() {
        // jwt令牌存储
        return new JwtTokenStore(accessTokenConverter());
    }

    @Bean
    public JwtAccessTokenConverter accessTokenConverter() {
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        converter.setSigningKey(SIGNING_KEY);       // 对称秘钥
        return converter;
    }

    /**
     * 配置令牌管理
     *
     * @param clientDetailsService
     * @param tokenStore
     * @param accessTokenConverter
     * @return
     */
    @Bean
    public AuthorizationServerTokenServices tokenServices(ClientDetailsService clientDetailsService,
                                                          TokenStore tokenStore,
                                                          JwtAccessTokenConverter accessTokenConverter) {
        DefaultTokenServices services = new DefaultTokenServices();
        services.setClientDetailsService(clientDetailsService);
        services.setSupportRefreshToken(true);
        services.setTokenStore(tokenStore);
        TokenEnhancerChain tokenEnhancerChain = new TokenEnhancerChain();
        tokenEnhancerChain.setTokenEnhancers(Collections.singletonList(accessTokenConverter));
        services.setTokenEnhancer(tokenEnhancerChain);
        return services;
    }

    @Bean
    public AuthorizationCodeServices authorizationCodeServices(DataSource dataSource) {
        return new JdbcAuthorizationCodeServices(dataSource);
    }

}

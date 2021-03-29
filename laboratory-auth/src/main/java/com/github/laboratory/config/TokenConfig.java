package com.github.laboratory.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

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

}

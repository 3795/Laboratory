package com.github.laboratory.config;

import com.github.laboratory.handler.FailureHandler;
import com.github.laboratory.handler.LogoutHandler;
import com.github.laboratory.handler.SuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author qihao
 * @description 安全管理器
 * @date 2021/3/29 16:21
 */
@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private SuccessHandler successHandler;

    @Autowired
    private FailureHandler failureHandler;

    @Autowired
    private LogoutHandler logoutHandler;

    /**
     * 认证管理器
     *
     * @return
     * @throws Exception
     */
    @Bean
    @Override
    public AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManagerBean();
    }

    /**
     * 安全拦截机制
     *
     * @param httpSecurity
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf().disable().formLogin()
                .loginProcessingUrl("/login").permitAll()
                .successHandler(successHandler).permitAll()
                .failureHandler(failureHandler).permitAll()
                .and()
                .logout().logoutSuccessHandler(logoutHandler)
                .and()
                .authorizeRequests()
                .antMatchers("/**").permitAll();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}

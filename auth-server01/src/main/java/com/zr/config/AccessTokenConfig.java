package com.zr.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;


/**
 * 指定token存储位置
 */
@Configuration
public class AccessTokenConfig {
//    @Autowired
//    RedisConnectionFactory redisConnectionFactory;
//
//    @Bean
//  TokenStore tokenStore(){
//      return  new RedisTokenStore(redisConnectionFactory);

//  }
//
//    @Bean
//    TokenStore tokenStore(){
//        return new InMemoryTokenStore();
//    }
private String SIGNING_KEY = "javaboy";

    @Bean
    TokenStore tokenStore() {
        return new JwtTokenStore(jwtAccessTokenConverter());
    }

    @Bean
    JwtAccessTokenConverter jwtAccessTokenConverter() {
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        converter.setSigningKey(SIGNING_KEY);
        return converter;
    }
}

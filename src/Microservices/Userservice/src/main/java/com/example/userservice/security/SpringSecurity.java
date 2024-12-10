package com.example.userservice.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurity {

//    @Bean
//    public SecurityFilterChain filteringCriteria(HttpSecurity httpSecurity) throws Exception {
//       httpSecurity.csrf(AbstractHttpConfigurer::disable);
//       httpSecurity.cors(AbstractHttpConfigurer::disable);
//         httpSecurity.authorizeHttpRequests(auth->auth.requestMatchers(HttpMethod.POST, "/signup").permitAll());
//        httpSecurity.authorizeHttpRequests(auth->auth.anyRequest().permitAll());
//        return httpSecurity.build();
//    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}

// security filter chain is a chain of filters that are applied to the incoming requests
// the filters are applied in the order they are defined in the chain
// the filters are applied to the incoming requests before they reach the controller after the dispatcher servlet

package com.example.bookTracker.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/*
Create the custom Java bean so that Spring can keep track of it and we can use it for
Dependency injection
 */
@Configuration
public class Config {

    @Bean
    //Custom bean that keep tracks of new bean called passwordEncoder
    public PasswordEncoder passwordEncoder()
    {
        return new BCryptPasswordEncoder();
    };
}

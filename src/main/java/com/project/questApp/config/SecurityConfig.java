package com.project.questApp.config;


import com.project.questApp.security.JwtAuthenticationEntryPoint;
import com.project.questApp.services.UserDetailsServiceImpl;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private UserDetailsServiceImpl userDetailsService;

    private JwtAuthenticationEntryPoint handler;

}

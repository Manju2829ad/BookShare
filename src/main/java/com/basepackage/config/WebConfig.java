package com.basepackage.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Allow all API paths
                .allowedOrigins("https://bookshare-c0b33.web.app") // Allow frontend domain
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Allow specific methods
                .allowedHeaders("*") // Allow all headers
                .allowCredentials(true); // Enable credentials (important for JWT authentication)
    }
}

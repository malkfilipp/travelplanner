package com.malkfilipp.travelplanner.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
@EnableConfigurationProperties(ClientProperties.class)
public class WebConfig implements WebMvcConfigurer {
    private final ClientProperties properties;

    @Autowired
    public WebConfig(ClientProperties properties) {
        this.properties = properties;
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/tickets")
                .allowedOrigins(properties.getOrigin())
                .maxAge(properties.getMaxAge());
        registry.addMapping("/cities")
                .allowedOrigins(properties.getOrigin())
                .maxAge(properties.getMaxAge());
    }
}

package com.jr.fakestoreapis.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplicationConfiguration {
    @Bean
    public RestTemplate CreateRestTemplate() {
        return new RestTemplate();
    }
}

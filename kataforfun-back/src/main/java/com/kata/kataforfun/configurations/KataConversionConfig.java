package com.kata.kataforfun.configurations;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
@ConfigurationPropertiesScan
public class KataConversionConfig {


    @Bean
    @ConfigurationProperties(prefix = "conversion.rules")
    public Map<Character, String> conversionRules(){
        return new HashMap<>();
    }

}

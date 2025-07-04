package com.platzi.platzi_pizzeria.web.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@Configuration
public class CorsConfig {
        @Bean
    CorsConfigurationSource corsConfigurationSource(){
            CorsConfiguration corsConfiguration = new CorsConfiguration();

            corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:3000"));
            corsConfiguration.setAllowedMethods(Arrays.asList("GET","PUT","PATCH","POST","DELETE"));
            corsConfiguration.setAllowedHeaders(Arrays.asList("*"));

            UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
            source.registerCorsConfiguration("**",corsConfiguration);

            return  source;
        }

}

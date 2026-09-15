package com.kmlch.email_service.config;



import com.kmlch.email_service.interceptors.RequestLoggingInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class RestTemplateConfig {


    @Bean
     public RestClient.Builder restClient(){

        return RestClient.builder()
                .defaultHeader("Accept", "application/json")
                .defaultHeader("X-App-Id", "MiAplicacionGlobal")
                .requestInterceptor(new RequestLoggingInterceptor())
                .defaultStatusHandler(status -> status.isError(), (request, response) -> {
                    throw new RuntimeException("Error global de API: " + response.getStatusCode());
                });
    }
}

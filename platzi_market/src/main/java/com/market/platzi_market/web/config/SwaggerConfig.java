package com.market.platzi_market.web.config;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class SwaggerConfig {

//http://localhost:8081/platzi-market/api/swagger-ui/index.html
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API de Platzi Market")
                        .version("1.0")
                        .description("Documentación de la API de Platzi Market con Swagger OpenAPI"));
    }

}

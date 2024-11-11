package com.mercadinho.config;

import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("mercadinho")
                .pathsToMatch("/**")
                .packagesToScan("com.mercadinho.resources")
                .build();
    }

    @Bean
    public io.swagger.v3.oas.models.OpenAPI customOpenAPI() {
        return new io.swagger.v3.oas.models.OpenAPI()
                .info(new Info().title("Mercadinho")
                        .description("Mercadinho APIs")
                        .version("1.0")
                        .contact(new Contact()
                                .name("Avaliacoes")
                                .url("http://www.avaliacaomercadinho.com.br")
                                .email("mercadinho@gmail.com")));
    }
}

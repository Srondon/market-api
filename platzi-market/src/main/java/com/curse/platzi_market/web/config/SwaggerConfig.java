package com.curse.platzi_market.web.config;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public GroupedOpenApi api() {
        return GroupedOpenApi.builder()
                .group("market-api")
                .packagesToScan("com.curse.platzi_market.web.controller") //Esto para especificar que queremos que únicamente lea nuestro Controller
                .build();
    }
}
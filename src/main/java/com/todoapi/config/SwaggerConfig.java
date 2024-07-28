// src/main/java/com/todoapi/config/SwaggerConfig.java
package com.todoapi.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("To-Do List API")
                        .version("1.0")
                        .description("API documentation for the To-Do List application"));
    }

    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("todos")
                .pathsToMatch("/api/todos/**")
                .build();
    }
}

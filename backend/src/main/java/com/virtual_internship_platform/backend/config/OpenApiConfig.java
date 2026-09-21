package com.virtual_internship_platform.backend.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI virtualInternshipOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Virtual Internship Platform API")
                        .description(
                                "REST API for the Virtual Internship Platform for Students"
                        )
                        .version("1.0"));
    }
}
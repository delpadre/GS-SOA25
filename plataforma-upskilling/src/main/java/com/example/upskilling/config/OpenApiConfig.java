package com.example.upskilling.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(info = @Info(title = "Plataforma Upskilling API", version = "1.0", description = "API para gerenciamento de trilhas e matrículas"))
@Configuration
public class OpenApiConfig { }

package com.br.produtos.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {

    return new OpenAPI()
            .info(new Info()
                    .title("API de Gerenciamento de Produtos ")
                    .version("1.0")
                    .description("API RESTful desenvolvida para controle, cadastro e manutenção do catálogo de produtos")
                    .contact(new Contact()
                            .name("Eric Gabrieal Hafemann")
                            .email("eric_hafemann@estudante.sesisenai.org.br"))
                );
    }
}

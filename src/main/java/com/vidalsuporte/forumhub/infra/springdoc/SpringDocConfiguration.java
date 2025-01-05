package com.vidalsuporte.forumhub.infra.springdoc;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.tags.Tag;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Array;
import java.util.Arrays;


@Configuration
public class SpringDocConfiguration {

    @Bean
    public OpenAPI custonOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Forum Hub ")
                        .description("API Rest da aplicação Forum Hub do Desafio e codificação ONE Oracle Next Education")
                        .contact(new Contact()
                                .name("André Gonçalves Vidal")
                                .email("vidalsuporte@gmail.com"))
                        .license(new License()
                                .name("Licença MIT")
                                .url("https://pt.wikipedia.org/wiki/Licen%C3%A7a_MIT"))
                ).tags( // lista de títulos e decrições dos endpoints
                        Arrays.asList(
                                new Tag().name("Perfil").description("EndPoint para gerênciamento dos perfis do Forum Hub"),
                                new Tag().name("Curso").description("EndPoint para gerênciamento dos cursos do Forum Hub"),
                                new Tag().name("Resposta").description("EndPoint para gerênciamento das Respostas dos Tópicos do Forum Hub"),
                                new Tag().name("Tópico").description("EndPoint para gerênciamento dos Tópicos do Forum Hub"),
                                new Tag().name("Usuário").description("EndPoint para gerênciamento dos Usuários do Forum Hub")
                                )
                );


    }
}

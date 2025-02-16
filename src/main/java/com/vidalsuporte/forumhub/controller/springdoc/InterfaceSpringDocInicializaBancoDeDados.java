package com.vidalsuporte.forumhub.controller.springdoc;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

@Tag(name = "Inicialização do Banco de Dados")
public interface InterfaceSpringDocInicializaBancoDeDados {

@Operation(summary = "Efetua a inicialização do banco de dados criando usuario: admin@admin.com e senha: admin e retorna JWT Válido.")
@ApiResponse(responseCode = "200", description = "Banco inicializado com sucesso." )
@ApiResponse(responseCode = "400", description = "Banco Já inicializado entre com a credenciais cadastradas." )
public ResponseEntity inicializaBanco ();


}

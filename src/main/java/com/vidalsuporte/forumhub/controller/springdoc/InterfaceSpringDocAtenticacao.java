package com.vidalsuporte.forumhub.controller.springdoc;

import com.vidalsuporte.forumhub.domain.usuario.DadosAtualizarUsuario;
import com.vidalsuporte.forumhub.domain.usuario.DadosAutenticacao;
import com.vidalsuporte.forumhub.domain.usuario.DadosCadastroUsuario;
import com.vidalsuporte.forumhub.domain.usuario.DadosDetalheUsuario;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.util.UriComponentsBuilder;

@Tag(name = "Atenticação")
public interface InterfaceSpringDocAtenticacao {

@Operation(summary = "Efetua a autenticação do Usuário no FormHub.")
@ApiResponse(responseCode = "200", description = "Login realizado com sucesso.")
public ResponseEntity efetuarLogin (@RequestBody @Valid DadosAutenticacao usuario);



    }

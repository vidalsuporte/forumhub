package com.vidalsuporte.forumhub.controller.springdoc;

import com.vidalsuporte.forumhub.domain.usuario.DadosAtualizarUsuario;
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

@Tag(name = "Usuário")
public interface InterfaceSpringDocUsuario {

@Operation(summary = "Lista todos os Perfis cadastrados no FormHub.")
@ApiResponse(responseCode = "200", description = "Retorna lista com todos os Perfis.")
public ResponseEntity<DadosDetalheUsuario> cadastrar(@RequestBody @Valid DadosCadastroUsuario usuario, UriComponentsBuilder uriBuilder);

    @Operation(summary = "Lista todos os Usuários cadastrados no FormHub.")
    @ApiResponse(responseCode = "200", description = "Retorna lista com todos os Usuários.")
    public ResponseEntity<Page<DadosDetalheUsuario>> listarTodos(@PageableDefault(size = 3, sort = {"nome"}) Pageable pageable);

    @Operation(summary = "Busca e detalha Usuario por id.")
    @ApiResponse(responseCode = "200", description = "Retorna Usuário cadastrado.")
    public ResponseEntity<DadosDetalheUsuario> BuscaPorId(@PathVariable Long id);


    @Operation(summary = "Atualiza Usuário cadastrado no FormHub.")
    @ApiResponse(responseCode = "200", description = "Retorna Dados atualizados do Usuário.")
    public ResponseEntity<DadosDetalheUsuario> atualiza(@RequestBody @Valid DadosAtualizarUsuario dadosAtualizarUsuario);


    }

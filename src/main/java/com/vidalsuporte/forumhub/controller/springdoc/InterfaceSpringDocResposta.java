package com.vidalsuporte.forumhub.controller.springdoc;

import com.vidalsuporte.forumhub.domain.perfil.DadosDetalhePerfil;
import com.vidalsuporte.forumhub.domain.resposta.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.util.UriComponentsBuilder;

@Tag(name = "Resposta")
public interface InterfaceSpringDocResposta {
    @SecurityRequirement(name = "bearer-key")
    @Operation(summary = "Cadatrada Respostas no FormHub.")
    @ApiResponse(responseCode = "200", description = "Resposta cadastrada com sucesso.")
    public ResponseEntity<DadosDetalheResposta> cadastrar(@RequestBody @Valid DadosCadastroResposta dadosCadastroResposta, UriComponentsBuilder uriBilder);


    @Operation(summary = "Busca e detalha Resposta por id.")
    @ApiResponse(responseCode = "200", description = "Retorna Reposta cadastrada.")
    public ResponseEntity<DadosDetalheUriResposta> detalhar(@PathVariable Long id);

    @SecurityRequirement(name = "bearer-key")
    @Operation(summary = "Atualiza Resposta cadastrada no FormHub.")
    @ApiResponse(responseCode = "200", description = "Retorna Dados atualizados da resposta.")
    public ResponseEntity<DadosDetalheResposta> atualizar(@RequestBody @Valid DadosAtualizarResposta dadosAtualizarResposta);


    @Operation(summary = "Lista todas as Respostas cadastradas no FormHub.")
    @ApiResponse(responseCode = "200", description = "Retorna lista com todas as Respostas.")
    public ResponseEntity<Page<DadosListaResposta>> listarTodos(@PageableDefault(size = 10, sort = "dataCriacao") Pageable pageable);

    @SecurityRequirement(name = "bearer-key")
    @Operation(summary = "Exclui Respota cadastrada no FormHub.")
    @ApiResponse(responseCode = "204", description = "Operação realizada com sucesso e sem retorno de conteúdo")
    public ResponseEntity Deletar(@PathVariable Long id);


}

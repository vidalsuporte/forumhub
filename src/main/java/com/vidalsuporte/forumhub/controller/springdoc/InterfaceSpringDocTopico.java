package com.vidalsuporte.forumhub.controller.springdoc;

import com.vidalsuporte.forumhub.domain.topico.DadosAtualizacaoTopico;
import com.vidalsuporte.forumhub.domain.topico.DadosCadastroTopico;
import com.vidalsuporte.forumhub.domain.topico.DadosDetalheTopico;
import com.vidalsuporte.forumhub.domain.topico.DadosUriDetalheTopico;
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

@Tag(name = "Tópico")
public interface InterfaceSpringDocTopico {

    @SecurityRequirement(name = "bearer-key")
    @Operation(summary = "Cadatrada Tópicos no FormHub.")
    @ApiResponse(responseCode = "200", description = "Tópico cadastrado com sucesso.")
    public ResponseEntity<DadosDetalheTopico> cadastrar(@RequestBody @Valid DadosCadastroTopico dadosCadastroTopico, UriComponentsBuilder uriBilder);

    @Operation(summary = "Busca e detalha Tópico por id.")
    @ApiResponse(responseCode = "200", description = "Retorna Tópico cadastrado.")
    public ResponseEntity<DadosUriDetalheTopico> detalhar(@PathVariable Long id);

    @Operation(summary = "Lista todos os tópicos cadastrados no FormHub.")
    @ApiResponse(responseCode = "200", description = "Retorna lista com todos os Tópicos.")
    public ResponseEntity<Page<DadosDetalheTopico>> listarTodos(@PageableDefault(size = 10, sort = "dataCriacao") Pageable pageable);

    @SecurityRequirement(name = "bearer-key")
    @Operation(summary = "Atualiza Tópico cadastrado no FormHub.")
    @ApiResponse(responseCode = "200", description = "Retorna Dados atualizados do Tópico.")
    public ResponseEntity<DadosDetalheTopico> atualizar(@RequestBody @Valid DadosAtualizacaoTopico dadosAtualizacaoTopico);

    @SecurityRequirement(name = "bearer-key")
    @Operation(summary = "Exclui Tópico cadastrado no FormHub.")
    @ApiResponse(responseCode = "204", description = "Operação realizada com sucesso e sem retorno de conteúdo")
    public ResponseEntity Deletar (@PathVariable Long id);


    }

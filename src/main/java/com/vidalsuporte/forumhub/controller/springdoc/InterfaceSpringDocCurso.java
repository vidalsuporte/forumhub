package com.vidalsuporte.forumhub.controller.springdoc;

import com.vidalsuporte.forumhub.domain.curso.DadosCadastroCurso;
import com.vidalsuporte.forumhub.domain.curso.DadosDetalhamentoCurso;
import com.vidalsuporte.forumhub.domain.perfil.DadosDetalhePerfil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.util.UriComponentsBuilder;

@Tag(name = "Curso")
public interface InterfaceSpringDocCurso {

    @Operation(summary = "Cadastra Curso no FormHub.")
    @ApiResponse(responseCode = "200", description = "Curso cadastrado com sucesso.")
    public ResponseEntity<DadosDetalhamentoCurso> cadastar(@RequestBody @Valid DadosCadastroCurso dadoscadastroCurso, UriComponentsBuilder uriBilder);

    @Operation(summary = "Lista todos os Curso cadastrados no FormHub.")
    @ApiResponse(responseCode = "200", description = "Retorna lista com todos os Cursos.")
    public ResponseEntity<Page<DadosDetalhamentoCurso>> Listar(@PageableDefault(size = 3, sort = {"nome"}) Pageable pageable);







    }

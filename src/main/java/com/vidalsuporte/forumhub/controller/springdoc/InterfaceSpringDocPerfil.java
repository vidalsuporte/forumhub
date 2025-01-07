package com.vidalsuporte.forumhub.controller.springdoc;

import com.vidalsuporte.forumhub.domain.perfil.DadosDetalhePerfil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
@SecurityRequirement(name = "bearer-key")
@Tag(name = "Perfil")
public interface InterfaceSpringDocPerfil {

@Operation(summary = "Lista todos os Perfis cadastrados no FormHub.")
@ApiResponse(responseCode = "200", description = "Retorna lista com todos os Perfis.")
 ResponseEntity<Page<DadosDetalhePerfil>> listarTodos(@PageableDefault(size = 3) Pageable pageable);



    }

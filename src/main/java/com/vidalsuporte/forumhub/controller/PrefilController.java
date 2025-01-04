package com.vidalsuporte.forumhub.controller;

import com.vidalsuporte.forumhub.domain.perfil.DadosDetalhePerfil;
import com.vidalsuporte.forumhub.domain.perfil.DadosPerfil;
import com.vidalsuporte.forumhub.domain.perfil.PerilSevice;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("perfis")
public class PrefilController {

    @Autowired
    PerilSevice perfilSevice;

    @GetMapping
    public ResponseEntity<Page<DadosDetalhePerfil>> listarTodos(@PageableDefault(size = 3)Pageable pageable){

        var page = perfilSevice.listar(pageable);

        return ResponseEntity.ok(page);

    }

}

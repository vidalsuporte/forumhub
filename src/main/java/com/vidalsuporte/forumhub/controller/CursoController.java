package com.vidalsuporte.forumhub.controller;

import com.vidalsuporte.forumhub.controller.springdoc.InterfaceSpringDocCurso;
import com.vidalsuporte.forumhub.domain.curso.CursoService;
import com.vidalsuporte.forumhub.domain.curso.DadosCadastroCurso;
import com.vidalsuporte.forumhub.domain.curso.DadosDetalhamentoCurso;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("cursos")
public class CursoController implements InterfaceSpringDocCurso {

    @Autowired
    CursoService cursoService;


    @PostMapping
    public ResponseEntity<DadosDetalhamentoCurso> cadastar(@RequestBody @Valid DadosCadastroCurso dadoscadastroCurso, UriComponentsBuilder uriBilder){

       var dadosDetalhamentoCurso = cursoService.salvar(dadoscadastroCurso);
       var uri = uriBilder.path("/cursos/{id}").buildAndExpand(dadosDetalhamentoCurso.id()).toUri();
       return ResponseEntity.created(uri).body(dadosDetalhamentoCurso);
    }

    @GetMapping
    public ResponseEntity<Page<DadosDetalhamentoCurso>> Listar(@PageableDefault(size = 3, sort = {"nome"}) Pageable pageable){

      var page = cursoService.listartodos(pageable);
      return ResponseEntity.ok(page);
    }

}

package com.vidalsuporte.forumhub.controller;

import com.vidalsuporte.forumhub.domain.topico.DadosCadastroTopico;
import com.vidalsuporte.forumhub.domain.topico.DadosDetalheTopico;
import com.vidalsuporte.forumhub.domain.topico.DadosUriDetalheTopico;
import com.vidalsuporte.forumhub.domain.topico.TopicoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("topicos")
public class TopicoController {

    @Autowired
    TopicoService topicoService;

    @PostMapping
    public ResponseEntity<DadosDetalheTopico> cadastrar(@RequestBody @Valid DadosCadastroTopico dadosCadastroTopico, UriComponentsBuilder uriBilder) {
        var topico = topicoService.cadastrar(dadosCadastroTopico);

        var uri = uriBilder.path("/topicos/{id}").buildAndExpand(topico.id()).toUri();

        return ResponseEntity.created(uri).body(topico);

    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosUriDetalheTopico> detalhar(@PathVariable Long id){

        var topico = topicoService.detalhar(id);

        return ResponseEntity.ok(topico);

    }


    @GetMapping
    public ResponseEntity<Page<DadosDetalheTopico>> listarTodos(@PageableDefault(size = 10, sort = "dataCriacao")Pageable pageable){
    var page =  topicoService.listarTodos(pageable);

     return ResponseEntity.ok(page);
    }



}
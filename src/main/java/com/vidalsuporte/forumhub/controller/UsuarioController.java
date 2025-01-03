package com.vidalsuporte.forumhub.controller;

import com.vidalsuporte.forumhub.domain.usuario.DadosAtualizarUsuario;
import com.vidalsuporte.forumhub.domain.usuario.DadosCadastroUsuario;
import com.vidalsuporte.forumhub.domain.usuario.DadosDetalheUsuario;
import com.vidalsuporte.forumhub.domain.usuario.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("usuarios")
public class UsuarioController {
    @Autowired
    UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<DadosDetalheUsuario> cadastrar(@RequestBody @Valid DadosCadastroUsuario usuario, UriComponentsBuilder uriBuilder){

     var dadosDetalhamentoUsuario = usuarioService.salvar(usuario);

     var uri = uriBuilder.path("/usuarios/{id}").buildAndExpand(dadosDetalhamentoUsuario.id()).toUri();

        return ResponseEntity.created(uri).body(dadosDetalhamentoUsuario);
    }


    @GetMapping("/todos")
    public ResponseEntity<Page<DadosDetalheUsuario>> listarTodos(@PageableDefault(size = 3, sort = {"nome"})Pageable pageable){

    var page = usuarioService.listarTodos(pageable);

    return ResponseEntity.ok(page);
    }



    @GetMapping("/{id}")
    public ResponseEntity<DadosDetalheUsuario> BuscaPorId(@PathVariable Long id){
        return ResponseEntity.ok(usuarioService.bucaPorId(id));

    }


    @PutMapping
    public ResponseEntity<DadosDetalheUsuario> atualiza(@RequestBody @Valid DadosAtualizarUsuario dadosAtualizarUsuario){

        var usuario = usuarioService.atualizar(dadosAtualizarUsuario);

        return ResponseEntity.ok(usuario);
    }



}

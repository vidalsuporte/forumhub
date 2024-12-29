package com.vidalsuporte.forumhub.controller;

import com.vidalsuporte.forumhub.domain.usuario.DadosCadastroUsuario;
import com.vidalsuporte.forumhub.domain.usuario.DadosDetalheUsuario;
import com.vidalsuporte.forumhub.domain.usuario.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("usuarios")
public class UsuarioController {
    @Autowired
    UsuarioService usuarioService;

    @PutMapping
    public ResponseEntity<DadosDetalheUsuario> cadastrar(@RequestBody @Valid DadosCadastroUsuario usuario, UriComponentsBuilder uriBuilder){

     var dadosDetalhamentoUsuario = usuarioService.salvar(usuario);

     var uri = uriBuilder.path("/usuarios/{id}").buildAndExpand(dadosDetalhamentoUsuario.id()).toUri();

        return ResponseEntity.created(uri).body(dadosDetalhamentoUsuario);
    }






}

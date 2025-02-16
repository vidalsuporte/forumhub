package com.vidalsuporte.forumhub.controller;

import com.vidalsuporte.forumhub.controller.springdoc.InterfaceSpringDocInicializaBancoDeDados;
import com.vidalsuporte.forumhub.domain.usuario.UsuarioService;
import com.vidalsuporte.forumhub.infra.security.TokenJWT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/inicializarBancoDeDados")
public class InicializaBancoDeDadosController implements InterfaceSpringDocInicializaBancoDeDados {


        @Autowired
        UsuarioService usuarioService;

        @GetMapping
        public ResponseEntity inicializaBanco(){


            var vazio = usuarioService.bancoInicilizado();

            if (vazio) {
                return ResponseEntity.ok(new TokenJWT(usuarioService.inicializaBanco()));
            }else {
                return ResponseEntity.badRequest().body("Banco de dados inicializado entre com a credenciais cadastradas!");
            }


        }





}

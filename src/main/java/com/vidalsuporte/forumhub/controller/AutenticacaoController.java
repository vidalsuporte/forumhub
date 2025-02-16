package com.vidalsuporte.forumhub.controller;

import com.vidalsuporte.forumhub.controller.springdoc.InterfaceSpringDocAtenticacao;
import com.vidalsuporte.forumhub.domain.usuario.DadosAutenticacao;
import com.vidalsuporte.forumhub.domain.usuario.Usuario;
import com.vidalsuporte.forumhub.domain.usuario.UsuarioService;
import com.vidalsuporte.forumhub.infra.security.TokenJWT;
import com.vidalsuporte.forumhub.infra.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class AutenticacaoController implements InterfaceSpringDocAtenticacao {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity efetuarLogin(@RequestBody @Valid DadosAutenticacao usuario) {

        var vazio = usuarioService.bancoInicilizado();

        if (!vazio) {

            var token = new UsernamePasswordAuthenticationToken(usuario.login(), usuario.senha());
            var autentication = authenticationManager.authenticate(token);
            var tokenJWT = tokenService.gerarToken((Usuario) autentication.getPrincipal());

            return ResponseEntity.ok(new TokenJWT(tokenJWT));
        }else {

            return ResponseEntity.badRequest().body("Banco de dados Não inicializado!");

        }
    }







}

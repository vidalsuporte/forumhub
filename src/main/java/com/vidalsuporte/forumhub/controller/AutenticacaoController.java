package com.vidalsuporte.forumhub.controller;

import com.vidalsuporte.forumhub.controller.springdoc.InterfaceSpringDocAtenticacao;
import com.vidalsuporte.forumhub.domain.usuario.DadosAutenticacao;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacaoController implements InterfaceSpringDocAtenticacao {

@Autowired
    AuthenticationManager authenticationManager;

    @PostMapping
    public ResponseEntity efetuarLogin (@RequestBody @Valid DadosAutenticacao usuario){
var token = new UsernamePasswordAuthenticationToken(usuario.login(), usuario.senha());
    var autentication = authenticationManager.authenticate(token);

return ResponseEntity.ok().build();

    }
}

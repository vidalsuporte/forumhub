package com.vidalsuporte.forumhub.domain.usuario;

import com.vidalsuporte.forumhub.domain.perfil.DadosDetalhePerfil;
import com.vidalsuporte.forumhub.domain.perfil.Perfil;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;
import java.util.stream.Collectors;

public record DadosDetalheUsuario(

        Long id,

        String nome,


        String email,


        List<DadosDetalhePerfil> perfis,

        Boolean ativo

) {
    public DadosDetalheUsuario(Usuario usuario) {

        this(usuario.getId(), usuario.getNome(), usuario.getEmail(), usuario.getPerfis().stream().map(DadosDetalhePerfil::new).collect(Collectors.toList()),usuario.getAtivo());

    }


}

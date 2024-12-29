package com.vidalsuporte.forumhub.domain.perfil;

import java.util.List;

public record DadosDetalhePerfil(Long id, PerfilEnum perfilEnum) {

    public DadosDetalhePerfil(Perfil perfil) {
   this(perfil.getId(), perfil.getPerfil());


    }
}

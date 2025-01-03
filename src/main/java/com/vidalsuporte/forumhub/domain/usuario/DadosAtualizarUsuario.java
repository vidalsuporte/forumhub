package com.vidalsuporte.forumhub.domain.usuario;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizarUsuario(

        @NotNull
        Long id,

        String nome,

        @Email
        String email,

        String senha
) {
}

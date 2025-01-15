package com.vidalsuporte.forumhub.domain.usuario;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


public record DadosAutenticacao(
        @NotNull
        String login,
        @NotNull
        String senha) {
}

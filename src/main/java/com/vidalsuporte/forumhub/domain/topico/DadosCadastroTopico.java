package com.vidalsuporte.forumhub.domain.topico;

import jakarta.validation.constraints.NotNull;

public record DadosCadastroTopico(

        @NotNull
        String titulo,

        @NotNull
        String mensagem,

        @NotNull
        Long cursoId,

        @NotNull
        Long autorId ) {
}

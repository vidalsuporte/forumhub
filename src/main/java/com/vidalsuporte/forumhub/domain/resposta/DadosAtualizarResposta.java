package com.vidalsuporte.forumhub.domain.resposta;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizarResposta(

        @NotNull
        Long id,

        String mensagem,


        Boolean solucao
) {


}

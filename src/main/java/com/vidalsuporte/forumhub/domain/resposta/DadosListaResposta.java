package com.vidalsuporte.forumhub.domain.resposta;

import com.vidalsuporte.forumhub.domain.topico.DadosUriDetalheTopico;

import java.time.LocalDateTime;

public record DadosListaResposta(

        Long id,

        String mensagem,

        LocalDateTime dataCriacao,

        DadosUriDetalheTopico topico,

        String autor,

        Boolean solucao


) {
    public DadosListaResposta(Resposta lr) {

        this(lr.getId(), lr.getMensagem(), lr.getDataCriacao(), new DadosUriDetalheTopico(lr.getTopico()),lr.getAutor().getNome(),lr.getSolucao());


    }
}

package com.vidalsuporte.forumhub.domain.topico;

import com.vidalsuporte.forumhub.domain.curso.DadosDetalhamentoCurso;
import com.vidalsuporte.forumhub.domain.usuario.DadosDetalheUsuario;

import java.time.LocalDateTime;

public record DadosDetalheTopico(
        long id,

        String titulo,

        String mensagem,

        LocalDateTime dataCriacao,

        DadosDetalheUsuario autor,

        String status,

       DadosDetalhamentoCurso curso


) {
    public DadosDetalheTopico(Topico topico)
    {
        this(topico.getId(), topico.getTitulo(), topico.getMensagem(),
                topico.getDataCriacao(), new DadosDetalheUsuario(topico.getAutor()),
                topico.getStatus().toString(), new DadosDetalhamentoCurso(topico.getCurso()));
    }
}
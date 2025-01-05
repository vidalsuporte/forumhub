package com.vidalsuporte.forumhub.domain.topico;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.vidalsuporte.forumhub.domain.curso.DadosDetalhamentoCurso;
import com.vidalsuporte.forumhub.domain.usuario.DadosDetalheUsuario;

import java.time.LocalDateTime;

public record DadosDetalheTopico(
        long id,

        String titulo,

        String mensagem,

        @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
        LocalDateTime dataCriacao,

        DadosDetalheUsuario autor,

        String status,

        DadosDetalhamentoCurso curso


) {
    public DadosDetalheTopico(Topico topico) {
        this(topico.getId(), topico.getTitulo(), topico.getMensagem(),
                topico.getDataCriacao(), new DadosDetalheUsuario(topico.getAutor()),
                topico.getStatus().toString(), new DadosDetalhamentoCurso(topico.getCurso()));
    }
}

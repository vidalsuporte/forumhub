package com.vidalsuporte.forumhub.domain.topico;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.vidalsuporte.forumhub.domain.curso.DadosDetalhamentoCurso;
import com.vidalsuporte.forumhub.domain.usuario.DadosDetalheUsuario;

import java.time.LocalDateTime;

public record DadosUriDetalheTopico (

    String titulo,

    String mensagem,

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    LocalDateTime dataCriacao,

    String autor,

    String status,

    String curso


) {

    public DadosUriDetalheTopico(Topico topico) {

        this(topico.getTitulo(), topico.getMensagem(),
                topico.getDataCriacao(), topico.getAutor().getNome(),
                topico.getStatus().toString(),topico.getCurso().getNome());


    }
}



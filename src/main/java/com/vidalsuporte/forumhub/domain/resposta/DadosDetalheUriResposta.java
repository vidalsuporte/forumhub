package com.vidalsuporte.forumhub.domain.resposta;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.vidalsuporte.forumhub.domain.topico.DadosDetalheTopico;
import com.vidalsuporte.forumhub.domain.usuario.DadosDetalheUsuario;

import java.time.LocalDateTime;
import java.util.Optional;

public record DadosDetalheUriResposta(
        String mensagem,

        String topico,

        @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
        LocalDateTime dataCriacao,

        String autor,

        Boolean solucao
        ) {
    public DadosDetalheUriResposta(Resposta resposta) {

     this(resposta.getMensagem(), new DadosDetalheTopico(resposta.getTopico()).titulo(), resposta.getDataCriacao(),
             new DadosDetalheUsuario(resposta.getAutor()).nome(),resposta.getSolucao());


    }



}

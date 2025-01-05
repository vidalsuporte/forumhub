package com.vidalsuporte.forumhub.domain.resposta;

import com.vidalsuporte.forumhub.domain.topico.Topico;
import com.vidalsuporte.forumhub.domain.usuario.Usuario;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Optional;

@Entity(name = "Resposta")
@Table(name = "repostas")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@EqualsAndHashCode(of = "id")
public class Resposta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

   private String mensagem;

   @ManyToOne
   @JoinColumn(name = "topico_id")
   private Topico topico;

    private LocalDateTime dataCriacao;

    @ManyToOne
    @JoinColumn(name = "autor_id")
    private Usuario autor;

    private Boolean solucao;

    public Resposta(@NotBlank String mensagem, Optional<Topico> topico, Optional<Usuario> autor, LocalDateTime hoje, boolean solucao) {

    this.mensagem = mensagem;
    this.dataCriacao = hoje;
    this.solucao = solucao;
    if (autor.isPresent()) {
        this.autor = autor.get();
    }else{
        throw new RuntimeException("autor não encontrado");
    }

        if (topico.isPresent()) {
            this.topico = topico.get();
        }else{
            throw new RuntimeException("Topico não encontrado");
        }



    }

    public void atualiza(@Valid DadosAtualizarResposta dadosAtualizarResposta) {

    if(dadosAtualizarResposta.solucao() != null){
        this.solucao = dadosAtualizarResposta.solucao();
    }

    if(dadosAtualizarResposta.mensagem() != null){
        this.mensagem = dadosAtualizarResposta.mensagem();
    }


    }
}

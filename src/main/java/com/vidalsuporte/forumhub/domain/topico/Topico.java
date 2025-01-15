package com.vidalsuporte.forumhub.domain.topico;

import com.vidalsuporte.forumhub.domain.curso.Curso;
import com.vidalsuporte.forumhub.domain.resposta.Resposta;
import com.vidalsuporte.forumhub.domain.usuario.Usuario;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Entity(name = "Topico")
@Table(name = "topicos")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@EqualsAndHashCode(of = "id")
@ToString
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

   private String titulo;

    private String mensagem;

    private LocalDateTime dataCriacao;

    @Enumerated(EnumType.STRING)
    private StatusEnum status;

    @ManyToOne
    @JoinColumn(name = "autor_id")
    private Usuario autor;

    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Curso curso;

    @OneToMany
    @JoinColumn(name = "reposta_id")
    private List<Resposta> Repostas;


    public Topico(Optional<Usuario> autor, Optional<Curso> curso, LocalDateTime dataCriacao, String status, @NotNull String titulo, @NotNull String mensagem) {

            if(autor.isEmpty()){
                throw (new RuntimeException("Autor obrigatório!"));
            }
            this.autor = autor.get();

            if (curso.isEmpty()){
                throw (new RuntimeException("Curso obrigatório!"));
            }
            this.curso = curso.get();

            this.dataCriacao = dataCriacao;

            this.titulo = titulo;

            this.mensagem = mensagem;

            this.status = StatusEnum.valueOf(status);


    }

    public void atuaizaDados(@Valid DadosAtualizacaoTopico dadosAtualizacaoTopico, Optional<Usuario> autor, Optional<Curso> curso) {

        if (dadosAtualizacaoTopico.titulo()!= null){
            this.titulo = dadosAtualizacaoTopico.titulo();
        }

        if (dadosAtualizacaoTopico.mensagem()!= null){
            this.mensagem = dadosAtualizacaoTopico.mensagem();
        }

        autor.ifPresent(usuario -> this.autor = usuario);

        curso.ifPresent(valor -> this.curso = valor);


    }

    public void atualizaStatus(String inativo) {
        this.status = StatusEnum.valueOf(inativo);
    }
}

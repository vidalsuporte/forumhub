package com.vidalsuporte.forumhub.domain.curso;

import com.vidalsuporte.forumhub.domain.topico.Topico;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;

import java.util.List;

@Entity(name = "Curso")
@Table(name = "cursos")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@ToString
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Column(name = "categoria")
    @Enumerated(value = EnumType.STRING)
    CategoriaEnum categoriaEnum;




    public Curso(@Valid DadosCadastroCurso dadoscadastroCurso) {
        this.nome = dadoscadastroCurso.nome();
        this.categoriaEnum = dadoscadastroCurso.categoria();
    }
}

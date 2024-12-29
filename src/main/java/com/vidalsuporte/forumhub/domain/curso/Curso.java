package com.vidalsuporte.forumhub.domain.curso;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "Curso")
@Table(name = "cursos")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Column(name = "categoria")
    @Enumerated(value = EnumType.STRING)
    Categoria categoria;


    public Curso(@Valid DadosCadastroCurso dadoscadastroCurso) {
        this.nome = dadoscadastroCurso.nome();
        this.categoria = dadoscadastroCurso.categoria();
    }
}

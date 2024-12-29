package com.vidalsuporte.forumhub.domain.curso;

import jakarta.validation.constraints.NotBlank;

public record DadosDetalhamentoCurso(

        Long id,
        String nome,
        Categoria categoria

) {
    public DadosDetalhamentoCurso(Curso curso) {
        this(curso.getId(), curso.getNome(), curso.getCategoria());
    }
}

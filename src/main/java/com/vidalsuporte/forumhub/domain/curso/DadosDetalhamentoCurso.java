package com.vidalsuporte.forumhub.domain.curso;

public record DadosDetalhamentoCurso(

        Long id,
        String nome,
        CategoriaEnum categoriaEnum

) {
    public DadosDetalhamentoCurso(Curso curso) {
        this(curso.getId(), curso.getNome(), curso.getCategoriaEnum());
    }
}

package com.vidalsuporte.forumhub.curso;

import com.vidalsuporte.forumhub.domain.curso.CategoriaEnum;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizaCurso (
        @NotNull
        Long id,

        String nome,

        CategoriaEnum categoriaEnum

){
}

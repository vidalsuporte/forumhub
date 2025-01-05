package com.vidalsuporte.forumhub.domain.curso;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoService {

    @Autowired
    CursoRepository cursoRepository;


    public DadosDetalhamentoCurso salvar(@Valid DadosCadastroCurso dadoscadastroCurso) {

        var curso = cursoRepository.save(new Curso(dadoscadastroCurso));

    return new DadosDetalhamentoCurso(curso);
    }

    public Page<DadosDetalhamentoCurso> listartodos(Pageable pageable) {
        return cursoRepository.findAll(pageable).map(DadosDetalhamentoCurso::new);
    }






}

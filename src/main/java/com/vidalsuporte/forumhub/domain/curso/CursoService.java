package com.vidalsuporte.forumhub.domain.curso;

import com.vidalsuporte.forumhub.curso.DadosAtualizaCurso;
import com.vidalsuporte.forumhub.domain.resposta.DadosDetalheUriResposta;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Collections;
import java.util.List;

@Service
public class CursoService {

    @Autowired
    CursoRepository cursoRepository;


    public DadosDetalhamentoCurso salvar(@Valid DadosCadastroCurso dadoscadastroCurso) {

        var curso = cursoRepository.save(new Curso(dadoscadastroCurso));
        ;
    return new DadosDetalhamentoCurso(curso);
    }

    public Page<DadosDetalhamentoCurso> listartodos(Pageable pageable) {
        return cursoRepository.findAll(pageable).map(DadosDetalhamentoCurso::new);
    }


    public DadosDetalhamentoCurso atualizar(@Valid DadosAtualizaCurso dadosAtualizaCurso) {

        var cursoEncontrado = cursoRepository.getReferenceById(dadosAtualizaCurso.id());

        cursoEncontrado.atualizaDados(dadosAtualizaCurso);

        return new DadosDetalhamentoCurso(cursoEncontrado);
    }

    public DadosDetalhamentoCurso detalhar(Long id) {

        var cursoEncontrado = cursoRepository.findById(id);
        if(cursoEncontrado.isEmpty()) {
            throw new RuntimeException("Curso não encontrado");
        }
        return new DadosDetalhamentoCurso(cursoEncontrado.get());
    }
}

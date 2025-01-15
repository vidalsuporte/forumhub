package com.vidalsuporte.forumhub.domain.topico;

import com.vidalsuporte.forumhub.domain.curso.CursoRepository;
import com.vidalsuporte.forumhub.domain.usuario.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class TopicoService {

    @Autowired
    UsuarioRepository  usuarioRepository;

    @Autowired
    CursoRepository cursoRepository;

   @Autowired
   TopicoRepository topicoRepository;

    @Transactional
    public DadosDetalheTopico cadastrar(DadosCadastroTopico dadosCadastroTopico) {
        var autor = usuarioRepository.findById(dadosCadastroTopico.autorId());
        var curso = cursoRepository.findById(dadosCadastroTopico.cursoId());
        var dataCriacao = LocalDateTime.now();
        var status = "ATIVO";

        var topico = topicoRepository.save(new Topico(autor, curso, dataCriacao, status, dadosCadastroTopico.titulo(), dadosCadastroTopico.mensagem()));

        System.out.println(topico);
        return new DadosDetalheTopico(topico);

    }

    public DadosUriDetalheTopico detalhar(Long id) {

        System.out.println(id);

        var topico = topicoRepository.findById(id).get();

        return new DadosUriDetalheTopico(topico);
    }

    public Page<DadosDetalheTopico> listarTodos(Pageable pageable) {

        return topicoRepository.findAllByStatusAtivo(pageable).map(DadosDetalheTopico::new);

    }


    public DadosDetalheTopico atualizar(@Valid DadosAtualizacaoTopico dadosAtualizacaoTopico) {

    var topico = topicoRepository.getReferenceById(dadosAtualizacaoTopico.id());
    var autor = dadosAtualizacaoTopico.autorId()==null ? topico.getAutor().getId(): dadosAtualizacaoTopico.autorId();
    var curso = dadosAtualizacaoTopico.cursoId()==null ? topico.getCurso().getId(): dadosAtualizacaoTopico.cursoId();

    topico.atuaizaDados(dadosAtualizacaoTopico, usuarioRepository.findById(autor), cursoRepository.findById(curso));

    return new DadosDetalheTopico(topico);
    }

    public void deletar(Long id) {
        var topico = topicoRepository.findById(id).get();
        topico.atualizaStatus("INATIVO");
        topicoRepository.save(topico);

    }
}

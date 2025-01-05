package com.vidalsuporte.forumhub.domain.resposta;

import com.vidalsuporte.forumhub.domain.topico.TopicoRepository;
import com.vidalsuporte.forumhub.domain.usuario.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class RespostaService {

    @Autowired
    UsuarioRepository  usuarioRepository;

    @Autowired
    TopicoRepository topicoRepository;

    @Autowired
    RespostaRepository respostaRepository;

    public DadosDetalheResposta cadastrar(@Valid DadosCadastroResposta dadosCadastroResposta) {

        var autor = usuarioRepository.findById(dadosCadastroResposta.autor_id());
        var topico =  topicoRepository.findById(dadosCadastroResposta.topico_id());
        var hoje = LocalDateTime.now();
        var solucao = false;
        var resposta = respostaRepository.save(new Resposta(dadosCadastroResposta.mensagem(),topico, autor, hoje, solucao));

        return new DadosDetalheResposta(resposta);

    }

    public DadosDetalheUriResposta detalhar(Long id) {
        var resposta =  respostaRepository.findById(id);

        if(!resposta.isPresent()) {
            throw new RuntimeException("Resposta não encontrada");
        }
        return new DadosDetalheUriResposta(resposta.get());
    }

    public DadosDetalheResposta atualizar(@Valid DadosAtualizarResposta dadosAtualizarResposta) {
   var respostaEncontrada = respostaRepository.getReferenceById(dadosAtualizarResposta.id());

    respostaEncontrada.atualiza(dadosAtualizarResposta);

    return new DadosDetalheResposta(respostaEncontrada);
    }

    public Page<DadosListaResposta> listarTodos(Pageable pageable) {

        return respostaRepository.findAll(pageable).map(DadosListaResposta:: new);


    }

    public void deletar(Long id) {

        respostaRepository.deleteById(id);

    }
}

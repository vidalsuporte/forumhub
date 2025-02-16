package com.vidalsuporte.forumhub.domain.resposta;

import com.vidalsuporte.forumhub.domain.topico.TopicoRepository;
import com.vidalsuporte.forumhub.domain.usuario.Usuario;
import com.vidalsuporte.forumhub.domain.usuario.UsuarioRepository;
import com.vidalsuporte.forumhub.domain.usuario.ValidaAutor;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class RespostaService {

    @Autowired
    UsuarioRepository  usuarioRepository;

    @Autowired
    TopicoRepository topicoRepository;

    @Autowired
    RespostaRepository respostaRepository;

    public DadosDetalheResposta cadastrar(@Valid DadosCadastroResposta dadosCadastroResposta) {
        Usuario usuarioLogado = (Usuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        var autor = usuarioRepository.findById(usuarioLogado.getId());
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

   if(ValidaAutor.validaAutor(respostaEncontrada.getAutor().getId())){
       throw new RuntimeException( "Somente o Autor ou os Gestores podem editar a resposta!");
   }

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

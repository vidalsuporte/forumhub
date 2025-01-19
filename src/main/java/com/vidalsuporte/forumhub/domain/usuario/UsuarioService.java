package com.vidalsuporte.forumhub.domain.usuario;

import com.vidalsuporte.forumhub.domain.perfil.Perfil;
import com.vidalsuporte.forumhub.domain.perfil.PerfilEnum;
import com.vidalsuporte.forumhub.domain.perfil.PerfilRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioService {

   @Autowired
   UsuarioRepository usuarioRepository;

   @Autowired
    PerfilRepository perfilRepository;

   @Autowired
    BCryptPasswordEncoder  bCryptPasswordEncoder;


    public DadosDetalheUsuario salvar(@Valid DadosCadastroUsuario dadosCadastroUsuario) {

        var perfis = dadosCadastroUsuario.perfis();
        List<Perfil> perfilList = new ArrayList<>();
        for (int i = 0; i < perfis.size(); i++) {

            perfilList.add(perfilRepository.findByPerfil(PerfilEnum.valueOf(perfis.get(i).perfil())).get());

        }


        System.out.println(perfilList);

        var usuario = usuarioRepository.save(new Usuario(dadosCadastroUsuario, perfilList, bCryptPasswordEncoder.encode(dadosCadastroUsuario.senha())));


        System.out.println(usuario);
        System.out.println("antes de salvar");
        return new DadosDetalheUsuario(usuario);
    }

    public DadosDetalheUsuario bucaPorId(Long id) {
        return new DadosDetalheUsuario(usuarioRepository.findById(id).get());
    }

    public Page<DadosDetalheUsuario> listarTodos(Pageable pageable) {

        return usuarioRepository.findAll(pageable).map(DadosDetalheUsuario::new);
    }

    public DadosDetalheUsuario atualizar(@Valid DadosAtualizarUsuario dadosAtualizarUsuario) {

    var usuarioAtualizado = usuarioRepository.getReferenceById(dadosAtualizarUsuario.id());

    usuarioAtualizado.atualizaDados(dadosAtualizarUsuario);

    return new DadosDetalheUsuario(usuarioRepository.save(usuarioAtualizado));


    }

    public boolean bancoInicilizado() {

        return usuarioRepository.findAll().isEmpty();
    }
}

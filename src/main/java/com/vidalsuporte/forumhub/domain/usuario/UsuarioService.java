package com.vidalsuporte.forumhub.domain.usuario;

import com.vidalsuporte.forumhub.domain.perfil.Perfil;
import com.vidalsuporte.forumhub.domain.perfil.PerfilEnum;
import com.vidalsuporte.forumhub.domain.perfil.PerfilRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioService {

   @Autowired
   UsuarioRepository usuarioRepository;

   @Autowired
    PerfilRepository perfilRepository;

    public DadosDetalheUsuario salvar(@Valid DadosCadastroUsuario dadosCadastroUsuario) {
        System.out.println(dadosCadastroUsuario);
        var perfis = dadosCadastroUsuario.perfis();
        List<Perfil> perfilList = new ArrayList<>();
        for (int i = 0; i < perfis.size(); i++) {

            perfilList.add(perfilRepository.findByPerfil(PerfilEnum.valueOf(perfis.get(i).perfil())).get());

        }


        System.out.println(perfilList);

        var usuario = usuarioRepository.save(new Usuario(dadosCadastroUsuario, perfilList));


        System.out.println(usuario);
        System.out.println("antes de salvar");
        return new DadosDetalheUsuario(usuario);
    }
}

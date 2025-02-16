package com.vidalsuporte.forumhub.domain.usuario;

import com.vidalsuporte.forumhub.domain.perfil.DadosPerfil;
import com.vidalsuporte.forumhub.domain.perfil.Perfil;
import com.vidalsuporte.forumhub.domain.perfil.PerfilEnum;
import com.vidalsuporte.forumhub.domain.perfil.PerfilRepository;
import com.vidalsuporte.forumhub.infra.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
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

   @Autowired
   private AuthenticationManager authenticationManager;;

   @Autowired
    TokenService tokenService;

    public DadosDetalheUsuario salvar(@Valid DadosCadastroUsuario dadosCadastroUsuario) {

        var perfis = dadosCadastroUsuario.perfis();
        List<Perfil> perfilList = new ArrayList<>();
        boolean admin = false;
        for (DadosPerfil perfi : perfis) {

            perfilList.add(perfilRepository.findByPerfil(PerfilEnum.valueOf(perfi.perfil())).get());

            admin = perfi.perfil().equals("ADMINISTRADOR");
        }
        if (admin && !usuarioRepository.findByEmail("admin@admin.com").equals("null")) {
            var user = usuarioRepository.findByNome("admin");
            usuarioRepository.removeUsuarioperfil(user.getId());
            usuarioRepository.deleteById(user.getId());
        }

        var usuario = usuarioRepository.save(new Usuario(dadosCadastroUsuario, perfilList, bCryptPasswordEncoder.encode(dadosCadastroUsuario.senha())));
        return new DadosDetalheUsuario(usuario);
    }

    public DadosDetalheUsuario buscaPorId(Long id) {
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


    public String inicializaBanco(){

         var perfis = new ArrayList<DadosPerfil>();
        perfis.add(new DadosPerfil("ADMINISTRADOR"));

        var admin = salvar(new DadosCadastroUsuario("admin","admin@admin.com", "admin", perfis));
        var token = new UsernamePasswordAuthenticationToken(admin.email(), "admin");

        var autentication = authenticationManager.authenticate(token);

        return tokenService.gerarToken((Usuario) autentication.getPrincipal());
    }



}




package com.vidalsuporte.forumhub.domain.usuario;

import com.vidalsuporte.forumhub.domain.perfil.Perfil;
import org.springframework.security.core.context.SecurityContextHolder;

public class ValidacaoAutor {

    public static  boolean validaAutor(long id){

        Usuario usuarioLogado = (Usuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        boolean b = true;

        for(Perfil perfil: usuarioLogado.getPerfis()){
            if(perfil.getPerfil().toString().equals("ADMINISTRADOR")||perfil.getPerfil().toString().equals("MODERADOR")){
                b = false;
            }
        }

        return usuarioLogado.getId() != id && b;
    }


}

package com.vidalsuporte.forumhub.domain.perfil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PerilSevice {

    @Autowired
    PerfilRepository perfilRepository;

    public Page<DadosDetalhePerfil> listar(Pageable pageable){
        return perfilRepository.findAll(pageable).map(DadosDetalhePerfil::new );
    }




}

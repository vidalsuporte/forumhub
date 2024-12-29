package com.vidalsuporte.forumhub.domain.perfil;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PerfilRepository extends JpaRepository<Perfil,Long> {

    public Optional<Perfil> findByPerfil(PerfilEnum perfil);

}

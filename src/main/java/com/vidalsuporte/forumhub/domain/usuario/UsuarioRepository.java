package com.vidalsuporte.forumhub.domain.usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;


public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<UserDetails> findByEmail(String email);

    Usuario findByNome(String nome);


    @Query(value = "DELETE FROM usuario_perfil WHERE usuario_id = :id", nativeQuery = true)
    void removeUsuarioperfil(@Param("id") Long id);


}

package com.vidalsuporte.forumhub.domain.topico;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Range;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TopicoRepository extends JpaRepository<Topico, Long> {

    @Query("""
            SELECT top
            FROM Topico as top
            where status != "INATIVO"
            """)
    Page<Topico> findAllByStatusAtivo(Pageable pageable);
}

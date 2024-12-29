package com.vidalsuporte.forumhub.domain.usuario;

import com.vidalsuporte.forumhub.domain.perfil.Perfil;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Fetch;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity(name = "Usuario")
@Table(name = "usuarios")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

    private String nome;

    private String email;

    private String senha;

    private boolean ativo;

    @ManyToMany
    @JoinTable(name = "usuario_perfil",
    joinColumns = @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "perfil_id"))
    private List<Perfil> perfis = new ArrayList<>();


    public Usuario(@Valid DadosCadastroUsuario dadosCadastroUsuario) {
        this.nome = dadosCadastroUsuario.nome();
        this.email = dadosCadastroUsuario.email();
        this.senha = dadosCadastroUsuario.senha();
        this.perfis = dadosCadastroUsuario.perfis().stream().map(p -> new Perfil(p.perfil())).collect(Collectors.toList());
        this.ativo = true;
    }

    public Usuario(@Valid DadosCadastroUsuario dadosCadastroUsuario, List<Perfil> perfilList) {
        this.nome = dadosCadastroUsuario.nome();
        this.email = dadosCadastroUsuario.email();
        this.senha = dadosCadastroUsuario.senha();
        this.perfis = perfilList;
        this.ativo = true;
    }
}

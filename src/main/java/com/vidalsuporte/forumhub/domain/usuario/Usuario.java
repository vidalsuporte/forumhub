package com.vidalsuporte.forumhub.domain.usuario;

import com.vidalsuporte.forumhub.domain.perfil.Perfil;
import com.vidalsuporte.forumhub.domain.topico.Topico;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Fetch;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Entity(name = "Usuario")
@Table(name = "usuarios")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Usuario implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

    private String nome;

    private String email;

    private String senha;

    @Setter
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

    public Usuario(@Valid DadosCadastroUsuario dadosCadastroUsuario, List<Perfil> perfilList, String senhaEncode) {
        this.nome = dadosCadastroUsuario.nome();
        this.email = dadosCadastroUsuario.email();
        this.senha = senhaEncode;
        this.perfis = perfilList;
        this.ativo = true;
    }




    public void adicionarPerfil(Perfil perfil){
        perfis.add(perfil);

    }

    public void removerPerfil(Perfil perfil){
        perfis.remove(perfil);

    }

    public void atualizaDados(@Valid DadosAtualizarUsuario dadosAtualizarUsuario) {

        if(dadosAtualizarUsuario.nome() != null){
            this.nome = dadosAtualizarUsuario.nome();
        }

        if(dadosAtualizarUsuario.email() != null){
            this.email = dadosAtualizarUsuario.email();
        }

        if(dadosAtualizarUsuario.senha() != null){
            this.senha = dadosAtualizarUsuario.senha();
        }

    }


    public Boolean getAtivo() {
    return ativo;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return  List.of();

    }

    @Override
    public String getPassword() {
        return this.senha;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

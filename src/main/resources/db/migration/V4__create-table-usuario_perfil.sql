CREATE TABLE usuario_perfil (

    perfil_id BIGINT NOT NULL,
    usuario_id BIGINT NOT NULL,

    PRIMARY KEY (perfil_id, usuario_id),

    CONSTRAINT fk_usuarios_perfis_id FOREIGN KEY (perfil_id) REFERENCES perfis(id),
    CONSTRAINT fk_perfis_usuarios_id FOREIGN KEY (usuario_id) REFERENCES usuarios(id)
);
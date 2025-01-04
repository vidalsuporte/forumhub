create table topicos(

    id bigint not null auto_increment,
    titulo varchar(256) not null unique,
    mensagem varchar(256) not null unique,
    data_criacao dateTime not null ,
    status varchar(10) not null,
    autor_id bigint not null,
    curso_id bigint not null,


    primary key(id),
    constraint fk_topico_autor_id foreign key (autor_id) references usuarios(id),
    constraint fk_topico_curso_id foreign key (curso_id) references cursos(id)
);
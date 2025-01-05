create table repostas(

    id bigint not null auto_increment,
    mensagem varchar(256) not null unique,
    data_criacao dateTime not null ,
    solucao boolean not null,
    autor_id bigint not null,
    topico_id bigint not null,


    primary key(id),
    constraint fk_resposta_autor_id foreign key (autor_id) references usuarios(id),
    constraint fk_resposta_topico_id foreign key (topico_id) references topicos(id)
);
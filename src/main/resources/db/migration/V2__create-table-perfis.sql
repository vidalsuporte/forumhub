create table perfis(

    id bigint not null auto_increment,
    perfil varchar(100) not null unique,
    primary key(id)
);

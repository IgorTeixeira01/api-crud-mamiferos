create table tipos_mamiferos(

    id_tipo bigint not null auto_increment,
    nome_tipo varchar(50) not null unique,
    mamilos boolean not null,
    marsupio boolean not null,
    placenta boolean not null,


    primary key(id_tipo)

);
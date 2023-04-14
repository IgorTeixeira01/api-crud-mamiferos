create table alimentacao(

    id_alimentacao bigint not null auto_increment,
    nome_alimentacao varchar(50) not null unique,
    fonte_animal boolean not null,
    fonte_vegetal boolean not null,


    primary key(id_alimentacao)

);
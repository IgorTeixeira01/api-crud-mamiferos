create table mamiferos(

    id bigint not null auto_increment,
    nome varchar(50) not null,
    cor varchar(50) not null,
    peso double not null,
    vertebrado_invertebrado varchar(15) not null,
    tipo_sangue varchar(10) not null,
    pelos boolean not null,
    glandulas_mamarias boolean not null,
    patas int not null,
    id_tipo bigint not null,
    id_alimentacao bigint not null,

    primary key(id)
);
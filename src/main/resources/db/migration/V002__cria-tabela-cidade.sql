create table cidade (
id bigint not null AUTO_INCREMENT,
nome_cidade varchar(80) not null,
nome_estado varchar(80) not null,

primary key (id)
) engine=InnoDB default charset=utf8mb4;
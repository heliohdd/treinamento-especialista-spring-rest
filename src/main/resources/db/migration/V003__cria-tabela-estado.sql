create table estado (
id bigint not null AUTO_INCREMENT,
nome varchar(80) not null,

primary key (id)
) engine=InnoDB default charset=utf8mb4;

INSERT INTO estado (nome) select DISTINCT nome_estado from cidade;

alter table cidade add column estado_id BIGINT NOT NULL;

USE algafood;
update cidade c set c.estado_id = (select e.id FROM estado e WHERE e.nome = c.nome_estado);

ALTER TABLE cidade ADD CONSTRAINT fk_cidade_estado
FOREIGN KEY (estado_id) REFERENCES estado (id);

alter table cidade drop column nome_estado;

alter table cidade change nome_cidade nome varchar(80) not null;
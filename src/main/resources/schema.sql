CREATE TABLE carro (
   placa VARCHAR(8) PRIMARY KEY,
   marca VARCHAR(20) NOT NULL,
   modelo VARCHAR(20) NOT NULL,
   cor VARCHAR(20) NOT NULL,
   ano INT NOT NULL,
   quilometragem INT NOT NULL,
   diaria FLOAT NOT NULL
);

CREATE TABLE cliente (
                         cliente_key INT PRIMARY KEY AUTO_INCREMENT,
                         nome VARCHAR(100) NOT NULL,
                         cpf BIGINT NOT NULL,
                         email VARCHAR(50) NOT NULL,
                         celular BIGINT NOT NULL
);

CREATE TABLE endereco (
                          endereco_key INT PRIMARY KEY AUTO_INCREMENT,
                          rua VARCHAR(50) NOT NULL,
                          numero INT NOT NULL,
                          complemento VARCHAR(50),
                          bairro VARCHAR(50) NOT NULL,
                          cidade VARCHAR(50) NOT NULL,
                          estado VARCHAR(2) NOT NULL,
                          cliente_key INT NOT NULL,
                          foreign key (cliente_key) references cliente(cliente_key)
);

CREATE TABLE vendedor (
  vendedor_key INT PRIMARY KEY AUTO_INCREMENT,
  nome VARCHAR(100) NOT NULL,
  cpf BIGINT NOT NULL,
  data_admissao DATE NOT NULL
);

CREATE TABLE conta_corrente (
  conta_corrente_key INT PRIMARY KEY AUTO_INCREMENT,
  banco VARCHAR(50) not null,
  agencia INT NOT NULL,
  conta_corrente INT NOT NULL,
  vendedor_key INT NOT NULL,
  foreign key (vendedor_key) references vendedor(vendedor_key)
);

-- Construção do Aluguel
create table aluguel (
    aluguel_key INT PRIMARY KEY AUTO_INCREMENT,
    data_criacao date not null,
    dias_alugado int not null,
    cliente_key int not null,
        foreign key (cliente_key) references cliente(cliente_key),
    vendedor_key int not null,
        foreign key (vendedor_key) references vendedor(vendedor_key),
    carro_placa varchar(8) not null,
        foreign key (carro_placa) references carro(placa)
);
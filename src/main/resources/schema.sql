CREATE TABLE carro (
   placa VARCHAR(8) PRIMARY KEY,
   marca VARCHAR(20) NOT NULL,
   modelo VARCHAR(20) NOT NULL,
   cor VARCHAR(20) NOT NULL,
   ano INT NOT NULL,
   quilometragem INT NOT NULL,
   diaria FLOAT NOT NULL
);
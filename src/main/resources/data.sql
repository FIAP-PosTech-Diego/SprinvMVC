CREATE TABLE veiculos(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    marca VARCHAR(255),
    modelo VARCHAR(255),
    placa VARCHAR(255),
    ano INT,
    cor VARCHAR(255),
    valor_diaria DECIMAL(10, 2)
);

CREATE TABLE pessoas(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255),
    cpf VARCHAR(255),
    telefone VARCHAR(255),
    email VARCHAR(255)
);

INSERT INTO veiculos (marca, modelo, placa, ano, cor, valor_diaria)
VALUES ('Chevrolet', 'Celta', 'ABC-124', 2010, 'Preto', 100.00);

INSERT INTO pessoas (nome, cpf, telefone, email)
VALUES ('Gustavo', '19942038722', '1199999999', 'gustavo@fiap.com.br');
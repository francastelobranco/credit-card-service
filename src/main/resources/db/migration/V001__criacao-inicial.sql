CREATE TABLE tb_cliente (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome_cliente VARCHAR(100) NOT NULL,
    cpf VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    telefone VARCHAR(100) NOT NULL,
    data_cadastro DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    data_alteracao DATETIME NULL,
    cliente_cep VARCHAR(50),
    cliente_logradouro VARCHAR(255),
    cliente_numero VARCHAR(50),
    cliente_complemento VARCHAR(255),
    cliente_bairro VARCHAR(255)
);

CREATE TABLE tb_conta (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    agencia VARCHAR(4) NOT NULL,
    conta VARCHAR(6) NOT NULL,
    data_cadastro DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    data_alteracao DATETIME NULL ON UPDATE CURRENT_TIMESTAMP,
    status ENUM('ATIVA', 'INATIVA') NOT NULL,
    cliente_id BIGINT NOT NULL,
    FOREIGN KEY (cliente_id) REFERENCES tb_cliente(id) ON DELETE CASCADE
);

CREATE TABLE tb_cartao (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    numero VARCHAR(16) NOT NULL,
    nome_titular VARCHAR(100) NOT NULL,
    data_validade DATE NOT NULL,
    data_cadastro DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    data_alteracao DATETIME NULL ON UPDATE CURRENT_TIMESTAMP,
    status_cartao ENUM('ATIVO', 'INATIVO') NOT NULL,
    status_envio ENUM('PENDENTE', 'ENVIADO', 'RECEBIDO') NOT NULL,
    bandeira ENUM('VISA', 'MASTERCARD') NOT NULL,
    tipo_cartao ENUM('FISICO', 'VIRTUAL') NOT NULL,
    conta_id BIGINT NOT NULL,
    FOREIGN KEY (conta_id) REFERENCES tb_conta(id) ON DELETE CASCADE
);

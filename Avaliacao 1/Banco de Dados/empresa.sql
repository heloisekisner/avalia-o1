DROP DATABASE IF EXISTS empresa;
CREATE DATABASE empresa;
USE empresa;

-- Criação de usuário 
CREATE USER IF NOT EXISTS 'devuser'@'localhost' IDENTIFIED BY '1234';
GRANT ALL PRIVILEGES ON empresa.* TO 'devuser'@'localhost';
FLUSH PRIVILEGES;

-- Tabela pessoa
CREATE TABLE pessoa (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL
);

-- Tabela funcionario (herda id da pessoa)
CREATE TABLE funcionario (
    id INT PRIMARY KEY,
    matricula VARCHAR(4) NOT NULL UNIQUE,
    departamento VARCHAR(50) NOT NULL,
    FOREIGN KEY (id) REFERENCES pessoa(id)
);

-- Tabela projeto
CREATE TABLE projeto (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    descricao TEXT NOT NULL,
    id_funcionario INT NOT NULL,
    FOREIGN KEY (id_funcionario) REFERENCES funcionario(id)
);

-- Inserção nas tabelas passo a passo
-- Primeiro: insere pessoas normalmente, deixando o MySQL gerar o ID
INSERT INTO pessoa (nome, email) VALUES
('Carlos Silva', 'carlos@email.com'),
('Ana Souza', 'ana@email.com'),
('Mariana Lima', 'mariana@email.com'),
('Paulo Mendes', 'paulo@email.com'),
('Beatriz Oliveira', 'beatriz@email.com'),
('Rafael Costa', 'rafael@email.com'),
('Laura Martins', 'laura@email.com'),
('João Pereira', 'joao@email.com'),
('Fernanda Rocha', 'fernanda@email.com'),
('Guilherme Lopes', 'guilherme@email.com');

-- Agora: pega os IDs gerados para pessoa
-- (você pode rodar isso para confirmar)
SELECT * FROM pessoa;

-- Agora insere os funcionários usando os mesmos IDs
-- 🚨 Esses IDs DEVEM ser iguais aos gerados acima (de 1 a 10)
INSERT INTO funcionario (id, matricula, departamento) VALUES
(1, 'F001', 'TI'),
(2, 'F002', 'RH'),
(3, 'F003', 'Financeiro'),
(4, 'F004', 'Marketing'),
(5, 'F005', 'TI'),
(6, 'F006', 'Financeiro'),
(7, 'F007', 'RH'),
(8, 'F008', 'Marketing'),
(9, 'F009', 'TI'),
(10, 'F010', 'Comercial');

-- Inserir projetos
INSERT INTO projeto (nome, descricao, id_funcionario) VALUES
('Sistema ERP', 'Implantação de ERP para gestão da empresa.', 1),
('Campanha RH', 'Campanha de endomarketing para colaboradores.', 2),
('Controle Financeiro', 'Sistema de controle de fluxo de caixa.', 3),
('Novo Site', 'Desenvolvimento do novo site institucional.', 4),
('App Mobile', 'Aplicativo para clientes acessarem serviços.', 5),
('Auditoria 2024', 'Auditoria interna de processos.', 6),
('Recrutamento 2024', 'Processo seletivo para novos talentos.', 7),
('Campanha Publicitária', 'Campanha de divulgação para rede social.', 8),
('Sistema BI', 'Implementação de Business Intelligence.', 9),
('Expansão Comercial', 'Plano de expansão para novas regiões.', 10);

-- Consulta para verificar tudo
SELECT * FROM pessoa;
SELECT * FROM funcionario;
SELECT * FROM projeto;

drop table pessoa;
drop table funcionario;
drop table projeto;


-- Inserindo dados de teste na tabela trilhas
INSERT INTO trilhas (nome) VALUES ('Java Básico');
INSERT INTO trilhas (nome) VALUES ('Python Avançado');
INSERT INTO trilhas (nome) VALUES ('Data Science');

-- Inserindo dados de teste na tabela usuarios
INSERT INTO usuarios (nome, email) VALUES ('Rafael', 'rafael@email.com');
INSERT INTO usuarios (nome, email) VALUES ('Ana', 'ana@email.com');

-- Inserindo dados de teste na tabela matriculas
INSERT INTO matriculas (usuario_id, trilha_id) VALUES (1, 1);
INSERT INTO matriculas (usuario_id, trilha_id) VALUES (2, 2);
ALTER TABLE matriculas ADD COLUMN data_inscricao DATE;

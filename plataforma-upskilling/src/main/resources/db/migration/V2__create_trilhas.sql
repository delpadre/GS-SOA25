CREATE TABLE IF NOT EXISTS trilhas (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    descricao TEXT,
    foco_principal VARCHAR(255),
    nivel VARCHAR(50),
    carga_horaria INT
);

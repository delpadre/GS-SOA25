CREATE TABLE IF NOT EXISTS matriculas (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    usuario_id BIGINT NOT NULL,
    trilha_id BIGINT NOT NULL,
    data_matricula TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    status VARCHAR(50) NOT NULL DEFAULT 'ATIVA',
    FOREIGN KEY (usuario_id) REFERENCES usuarios(id),
    FOREIGN KEY (trilha_id) REFERENCES trilhas(id)
);

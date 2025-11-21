-- V2__add_status_to_matriculas.sql
ALTER TABLE matriculas
ADD COLUMN status VARCHAR(50) NOT NULL DEFAULT 'ATIVA';

UPDATE matriculas
SET status = 'ATIVA'
WHERE status IS NULL;

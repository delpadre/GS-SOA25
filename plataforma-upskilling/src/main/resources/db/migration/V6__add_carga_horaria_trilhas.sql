ALTER TABLE trilhas
ADD COLUMN IF NOT EXISTS carga_horaria INT NOT NULL DEFAULT 0;

-- Atualiza registros existentes para evitar NULL
UPDATE trilhas
SET carga_horaria = 0
WHERE carga_horaria IS NULL;

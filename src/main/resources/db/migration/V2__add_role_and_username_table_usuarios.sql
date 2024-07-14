-- Parte 1: Agregar la columna 'username' sin la restricción 'UNIQUE'
ALTER TABLE USUARIOS
    ADD COLUMN username VARCHAR(50);

-- Parte 2: Asegurar que todos los valores nulos se actualicen con valores únicos basados en el id
UPDATE USUARIOS SET username = CONCAT('user_', id) WHERE username IS NULL OR username = '';

-- Parte 3: Aplicar la restricción 'NOT NULL' a la columna 'username'
ALTER TABLE USUARIOS
    MODIFY COLUMN username VARCHAR(50) NOT NULL;

-- Parte 4: Agregar la restricción 'UNIQUE' a la columna 'username'
ALTER TABLE USUARIOS
    ADD CONSTRAINT unique_username UNIQUE (username);

-- Parte 5: Agregar la columna 'role'
ALTER TABLE USUARIOS
    ADD COLUMN role ENUM('ADMIN', 'USER') NOT NULL DEFAULT 'USER';

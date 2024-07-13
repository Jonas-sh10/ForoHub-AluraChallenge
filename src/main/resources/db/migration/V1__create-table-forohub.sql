
-- Crear la tabla Usuario
CREATE TABLE Usuarios (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    correo_electronico VARCHAR(100) NOT NULL UNIQUE,
    contrasena VARCHAR(100) NOT NULL,
    activo BOOLEAN NOT NULL
);

-- Crear la tabla Curso
CREATE TABLE Cursos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    categoria VARCHAR(100) NOT NULL,
    activo BOOLEAN NOT NULL
);

-- Crear la tabla Topico
CREATE TABLE Topicos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(200) NOT NULL,
    mensaje VARCHAR(500) NOT NULL,
    fecha_creacion DATETIME NOT NULL,
    status ENUM('ABIERTO', 'CERRADO') DEFAULT 'ABIERTO',
    usuario_id INT NOT NULL,
    curso_id INT NOT NULL,
    activo BOOLEAN NOT NULL,
    FOREIGN KEY (usuario_id) REFERENCES Usuarios(id),
    FOREIGN KEY (curso_id) REFERENCES Cursos(id)
);

-- Crear la tabla Respuesta
CREATE TABLE Respuestas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    mensaje VARCHAR(500) NOT NULL,
    topico_id INT NOT NULL,
    fecha_creacion DATETIME NOT NULL,
    usuario_id INT NOT NULL,
    solucion BOOLEAN NOT NULL,
    activo BOOLEAN NOT NULL,
    FOREIGN KEY (topico_id) REFERENCES Topicos(id),
    FOREIGN KEY (usuario_id) REFERENCES Usuarios(id)
);

CREATE TABLE Topico (
    id INT AUTO_INCREMENT PRIMARY KEY,
    autor_id INT NOT NULL,
    curso_id INT NOT NULL,
    fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    mensaje TEXT NOT NULL,
    status VARCHAR(20) NOT NULL DEFAULT 'ABIERTO',
    titulo VARCHAR(255) NOT NULL,
    FOREIGN KEY (autor_id) REFERENCES Usuario(id),
    FOREIGN KEY (curso_id) REFERENCES Curso(id),
    INDEX (status) -- Índice para mejorar las consultas por 'status'
);

CREATE TABLE Respuesta (
    id INT AUTO_INCREMENT PRIMARY KEY,
    mensaje TEXT NOT NULL,
    topico_id INT, -- Agregar la columna topico_id
    fechaCreacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    autor_id INT, -- Agregar la columna autor_id
    solucion BOOLEAN DEFAULT FALSE,
    FOREIGN KEY (topico_id) REFERENCES Topico(id), -- Ajustar la clave foránea
    FOREIGN KEY (autor_id) REFERENCES Usuario(id) -- Ajustar la clave foránea
);
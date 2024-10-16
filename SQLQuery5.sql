-- Crear la tabla
CREATE TABLE PastelDescripciones (
    id INT PRIMARY KEY,
    descripcion VARCHAR(255) NOT NULL
);

-- Insertar las descripciones
INSERT INTO PastelDescripciones (id, descripcion) VALUES (1, 'Chocolatoso y muy potente');
INSERT INTO PastelDescripciones (id, descripcion) VALUES (2, 'Esponjoso y con sabor a zanahoria');
INSERT INTO PastelDescripciones (id, descripcion) VALUES (3, 'Tan acido que tu cara quedará graciosa');
INSERT INTO PastelDescripciones (id, descripcion) VALUES (4, 'Un sabor popular y sabroso');

-- Consultar los datos insertados
SELECT * FROM PastelDescripciones;
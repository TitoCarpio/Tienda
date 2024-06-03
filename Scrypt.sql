-- Crear la tabla de usuarios
CREATE TABLE usuarios (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    contrasena VARCHAR(100) NOT NULL,
    rol VARCHAR(10) NOT NULL,
    saldo NUMERIC(10, 2) NOT NULL DEFAULT 100.00 -- Añadir el atributo saldo con un valor por defecto de 100
);

-- Crear la tabla de artículos de ropa
CREATE TABLE articulos (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    descripcion TEXT,
    precio NUMERIC(10, 2) NOT NULL,
    imagen VARCHAR(255) -- El campo imagen almacenará la URL de la imagen del artículo
);

-- Crear la tabla de compras de los usuarios
CREATE TABLE compras (
    id SERIAL PRIMARY KEY,
    usuario_id INT REFERENCES usuarios(id),
    articulo_id INT REFERENCES articulos(id),
    cantidad INT NOT NULL,
    fecha TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Insertar algunos datos de ejemplo en la tabla de usuarios
INSERT INTO usuarios (nombre, email, contrasena, rol, saldo) 
VALUES 
    ('Andrea', 'andrea@gmail.com', '123456789', 'USER', 100.00),
    ('Eduardo', 'eduardo@gmail.com', '123456789', 'USER', 200.00),
    ('Administrador', 'admin@gmail.com', 'admin123', 'ADMIN', 300.00);

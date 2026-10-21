CREATE TABLE clientes (
	id SERIAL PRIMARY KEY,            
	nombre VARCHAR(100) NOT NULL,       
	plan VARCHAR(20) NOT NULL   
);

CREATE TABLE productos (
  	id SERIAL PRIMARY KEY,
  	nombre VARCHAR(100) NOT NULL,
  	precio_base NUMERIC(10,2),
 	tipo VARCHAR(20) NOT NULL
);

CREATE TABLE combo_productos (
  combo_id INT REFERENCES productos(id),
  producto_id INT REFERENCES productos(id),
 PRIMARY KEY (combo_id, producto_id)
);
CREATE TABLE pedidos (
  id SERIAL PRIMARY KEY,
  cliente_id INT REFERENCES clientes(id),
  modo_pago VARCHAR(20) NOT NULL
);
CREATE TABLE pedido_productos (
  pedido_id INT REFERENCES pedidos(id),
  producto_id INT REFERENCES productos(id),
  cantidad INT NOT NULL, 
  PRIMARY KEY (pedido_id, producto_id)
);

SELECT current_user;
SELECT * FROM productos;
INSERT INTO productos (nombre, precio_base, tipo)
VALUES ('coca-cola', 2000.0, 'bebidas');

INSERT INTO clientes (nombre, plan)
VALUES ('Juan', 'Estandar');

ALTER TABLE pedido_productos ADD COLUMN cantidad INT NOT NULL; 

INSERT INTO pedidos (cliente_id, modo_pago)
VALUES (2, 'Efectivo');

INSERT INTO pedido_productos (pedido_id, producto_id, cantidad)
VALUES (9, 1, 2);

SELECT * FROM clientes;
SELECT * FROM pedidos;

SELECT pedidos.id, clientes.nombre, pedido_productos.producto_id, pedido_productos.cantidad
FROM pedidos
JOIN pedido_productos ON pedidos.id = pedido_productos.pedido_id
JOIN clientes ON pedidos.cliente_id = clientes.id;

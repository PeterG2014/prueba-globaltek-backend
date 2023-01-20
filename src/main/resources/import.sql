--INSERT TABLE FACTURAS
INSERT INTO factura (numero_factura, fecha, tipo_de_pago, documento_cliente, nombre_cliente, subtotal, descuento, iva, total_descuento, total_impuesto, total) VALUES (1001, '2018-09-12', 'Contado', 80225444, 'Juan Perez', 100000, 0, 19, 0.00, 19000.00, 119000.00);
INSERT INTO factura (numero_factura, fecha, tipo_de_pago, documento_cliente, nombre_cliente, subtotal, descuento, iva, total_descuento, total_impuesto, total) VALUES (1002, '2018-10-12', 'Credito', 80225777, 'Pedro Hernandez', 200000, 10, 19, 20000.00, 34200.00, 214200.00);
INSERT INTO factura (numero_factura, fecha, tipo_de_pago, documento_cliente, nombre_cliente, subtotal, descuento, iva, total_descuento, total_impuesto, total) VALUES (1003, '2018-11-12', 'Contado', 80225666, 'Mario Duarte', 300000, 5, 19, 15000.00, 54150.00, 339150.00);

--
--INSERT TABLE PRODUCTOS
INSERT INTO producto (producto) VALUES ('camisa');
INSERT INTO producto (producto) VALUES ('Pantalon');
INSERT INTO producto (producto) VALUES ('Zapatos');
INSERT INTO producto (producto) VALUES ('Tenis');
INSERT INTO producto (producto) VALUES ('Falda');
INSERT INTO producto (producto) VALUES ('Blusa');


--INSERT TABLE DETALLE
INSERT INTO detalle (id_factura, id_producto, cantidad, precio_unitario) VALUES (1, 1, 1, 50000);
INSERT INTO detalle (id_factura, id_producto, cantidad, precio_unitario) VALUES (1, 2, 2, 25000);
INSERT INTO detalle (id_factura, id_producto, cantidad, precio_unitario) VALUES (2, 3, 5, 20000);
INSERT INTO detalle (id_factura, id_producto, cantidad, precio_unitario) VALUES (2, 4, 4, 25000);
INSERT INTO detalle (id_factura, id_producto, cantidad, precio_unitario) VALUES (3, 5, 1, 100000);
INSERT INTO detalle (id_factura, id_producto, cantidad, precio_unitario) VALUES (3, 6, 1, 200000);


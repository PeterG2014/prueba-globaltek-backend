--INSERT TABLE FACTURAS
INSERT INTO facturas (numero_factura, fecha, tipo_de_pago, documento_cliente, nombre_cliente, subtotal, descuento, iva, total_descuento, total_impuesto, total) VALUES (1001, '09/12/2018', 'Contado', 80225444, 'Juan Perez', 100000, 0, 19, 0, 19000, 119000);
INSERT INTO facturas (numero_factura, fecha, tipo_de_pago, documento_cliente, nombre_cliente, subtotal, descuento, iva, total_descuento, total_impuesto, total) VALUES (1002, '10/12/2018', 'Credito', 80225777, 'Pedro Hernandez', 200000, 10, 19, 20000, 34200, 214200);
INSERT INTO facturas (numero_factura, fecha, tipo_de_pago, documento_cliente, nombre_cliente, subtotal, descuento, iva, total_descuento, total_impuesto, total) VALUES (1003, '11/12/2018', 'Contado', 80225666, 'Mario Duarte', 300000, 5, 19, 15000, 54150, 339150);


--INSERT TABLE DETALLE
INSERT INTO detalles (id_factura, id_producto, cantidad, precio_unitario) VALUES (1, 1, 1, 50000);
INSERT INTO detalles (id_factura, id_producto, cantidad, precio_unitario) VALUES (1, 2, 2, 25000);
INSERT INTO detalles (id_factura, id_producto, cantidad, precio_unitario) VALUES (2, 3, 5, 20000);
INSERT INTO detalles (id_factura, id_producto, cantidad, precio_unitario) VALUES (2, 4, 4, 25000);
INSERT INTO detalles (id_factura, id_producto, cantidad, precio_unitario) VALUES (3, 5, 1, 100000);
INSERT INTO detalles (id_factura, id_producto, cantidad, precio_unitario) VALUES (4, 6, 1, 200000);

--
--INSERT TABLE PRODUCTOS
INSERT INTO productos (producto) VALUES ('camisa');
INSERT INTO productos (producto) VALUES ('Pantalon');
INSERT INTO productos (producto) VALUES ('Zapatos');
INSERT INTO productos (producto) VALUES ('Tenis');
INSERT INTO productos (producto) VALUES ('Falda');
INSERT INTO productos (producto) VALUES ('Blusa');
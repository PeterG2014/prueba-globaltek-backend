PASO A PASO

Para probar este proyecto es necesario 
1. Crear una base de datos con el nombre: db_globaltek_backend el cual se encuentra en la carpeta application.properties del proyecto
2. Importar el proyecto en un ambiente Maven y correrlo con Spring Boot
3. Probar el proyecto en Postman ejecutando los siguientes endpoint:

DELETE http://localhost:9000/api/factura/{ID}

UPDATE http://localhost:9000/api/factura/{ID}

CREATE http://localhost:9000/api/create-factura

SHOW BY ID http://localhost:9000/api/factura/{ID}

SHOW ALL http://localhost:9000/api/facturas

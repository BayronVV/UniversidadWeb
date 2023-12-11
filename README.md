# Proyecto Tercera Nota

Este repositorio cuenta con los puntos:

1. Deben implementar los servicios REST de dos elementos de una base de datos. El servicio debe incluir Listar los objetos, Obtener un objeto, Crear un objeto, Actualizar un objeto y Eliminar un objeto. ~Completo~

2. Se debe utilizar una implementación de JPA, preferiblemente Spring Data para poder conectar a la base de datos y obtener la información de las tablas. ~Completo~

3. Se debe implementar documentación en Open API, utilizando Swagger, como se explicó en la clase. ~Completo~

4. Se debe implementar medidas de seguridad, inicialmente el bloqueo por CORS. ~Completo~

5. Se debe implementar Spring Security para poder realizar la protección de rutas en el servidor, tal como se mostró en la clase virtual del miércoles, o en el documento anexo en el enlace de Spring Security. ~Se implemento, se puede ver en los commits, sin embargo, debido a unos problemas para consumir el API y manejar la autorizacion en swagger se quito del proyecto~

CAPA FRONTEND

La carpeta con el nombre universidadWeb, donde consume los metodos CRUD del API por medio de Fetch y peticiones asincronas.

Recomendaciones: Retirar la carpeta del front-end del API y ejecutar con live server

6. Debe implementar una página en HTML que realice el consumo de los servicios desarrollados.

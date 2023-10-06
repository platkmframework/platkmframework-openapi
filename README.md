# platkmframework-openapi

```
Configuraciones necesarias.

-Controllers.
En los controladores que van a mostrarse en el OpenAPI, se debe incluir la anotación @OpenApi


- pom.xml
<dependency>
	<groupId>org.platkmframework</groupId>
	<artifactId>platkmframework-openapi</artifactId>
	<version>1.0.0-beta</version>
</dependency>
 
- url
Para mostrar el openAPI incluir "platkmframework-openapi/index.html", después del contexto del proyecto.
http <server>:<port>/platkmframework-openapi/index.html


- Usar el ProjectContent para incluir:
addServlet(new OpenApiServlet());


- properties
Si se desea incluir el openapi para el DBAPI, se debe incluir la siguiente propiedad
Se debe incluir al propiedad "open-api-persistence-unit"
El valor de esta propiedad debe ser el persistence unit de donde se accederá a la base de datos.
```

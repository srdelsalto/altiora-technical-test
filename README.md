# altiora-technical-test
Java Backend for a Technical Test by Altiora

# Proyecto Full Stack con Backend en Java (Spring Boot) y Frontend en React

Este proyecto es una aplicación web full stack que combina un **backend en Java (Spring Boot)** y un **frontend en React**. El backend maneja la lógica del negocio, las APIs REST, y la interacción con la base de datos, mientras que el frontend se encarga de la interfaz de usuario.

## Requisitos Previos

### Herramientas necesarias

Antes de ejecutar este proyecto, asegúrate de tener instaladas las siguientes herramientas en tu máquina:

- **Java 17** o superior
- **Maven** (para gestionar dependencias en el backend)
- **Node.js** (v18.x.x o superior) y **npm** o **yarn** (para gestionar dependencias del frontend)
- **Git** (para clonar el repositorio)

### Requisitos del Backend

- **Java 17** o superior
- **Maven 3.6.x** o superior
- **Base de datos PostgreSQL** (o ajusta la base de datos en la configuración de Spring)

### Requisitos del Frontend

- **Node.js** y **npm** o **yarn**

## Antes de Empezar
Para el Backend se ha utilizado el IDE de desarrollo **IntelliJ IDEA** y para el Frontend se ha utilizado **Visual Studio Code**.

Por favor crear en la Instancia Postgres una base de datos con el nombre `altioracorp`

Se debe tomar en cuenta que en nuestro backend es necesario configurar nuestra base de datos, para ello se debe modificar el archivo `application.properties` que se encuentra en la carpeta `src/main/resources` y modificar las siguientes líneas:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/altioracorp # Cambiar por la url de la base de datos
spring.datasource.username=postgres # Cambiar por el usuario de la base de datos
spring.datasource.password=Santyr5442# # Cambiar por la contraseña de la base de datos
```	

## Valor Extra en Backend
Se ha creado documentación de la API con Swagger, para acceder a ella se debe ingresar a la siguiente URL: `http://localhost:8080` (Que sería el puerto por defecto en nuestra app) o ingresar directamente a `http://localhost:8080/v2/api-docs` para ver la documentación en formato JSON.

## Ejecutar el Backend
cd altiora-backend

# Limpiar y construir el proyecto
mvn clean install

# Ejecutar la aplicación
mvn spring-boot:run

## Ejecutar el Frontend
cd altiora-frontend

# Instalar dependencias con npm
npm install

# O con yarn
yarn install

# Iniciar la aplicación en modo de desarrollo
npm start

# O con yarn
yarn start

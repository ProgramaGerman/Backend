# Prueba Render - Spring Boot Application

Esta es una aplicación Spring Boot simple con un endpoint REST que devuelve un saludo.

## Funcionalidades

- Endpoint REST: `GET /saludo`
- Base de datos H2 en memoria
- Configuración lista para producción

## Ejecución Local

### Con Maven
```bash
./mvnw spring-boot:run
```

### Con JAR compilado
```bash
./mvnw clean package
java -jar target/Prueba-0.0.1-SNAPSHOT.jar
```

## Ejecución con Docker

### Construir la imagen
```bash
# Primero compilar el proyecto
./mvnw clean package -DskipTests

# Opción 1: Dockerfile principal (amazoncorretto)
docker build -t prueba-render .

# Opción 2: Dockerfile alternativo (amazoncorretto + extras)
docker build -f Dockerfile.alternative -t prueba-render .

# Opción 3: Dockerfile Ubuntu (más confiable)
docker build -f Dockerfile.ubuntu -t prueba-render .
```

### Ejecutar el contenedor
```bash
docker run -p 8080:8080 prueba-render
```

### Ejecutar con variables de entorno
```bash
docker run -p 8080:8080 -e SPRING_PROFILES_ACTIVE=prod prueba-render
```

## Despliegue en Render

### Pasos para el despliegue:

1. **Crear un repositorio en GitHub** con todos los archivos del proyecto
2. **Conectar a Render**: 
   - Ve a [render.com](https://render.com)
   - Conecta tu repositorio de GitHub
3. **Configurar el servicio**:
   - Tipo: Web Service
   - Build Command: `./mvnw clean package -DskipTests`
   - Start Command: `java -jar target/Prueba-0.0.1-SNAPSHOT.jar`
   - O usa Docker: Build Command vacío y Start Command vacío (usa Dockerfile)

### Variables de entorno en Render:
- `SPRING_PROFILES_ACTIVE=prod`
- `PORT=8080` (automático en Render)

## Endpoints

- `GET /saludo` - Devuelve un mensaje de saludo

## Estructura del proyecto

```
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/example/Prueba/
│   │   │       ├── PruebaRenderApplication.java
│   │   │       └── controlador/
│   │   │           └── controlador.java
│   │   └── resources/
│   │       ├── application.properties
│   │       └── application-prod.properties
│   └── test/
├── target/
├── Dockerfile
├── .dockerignore
├── pom.xml
└── README.md
```

## Configuración

### Perfiles de Spring:
- **default**: Para desarrollo local
- **prod**: Para producción (Render)

### Base de datos:
- H2 en memoria para ambos perfiles
- Configuración automática sin necesidad de configuración adicional

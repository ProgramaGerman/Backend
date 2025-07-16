# Solución de problemas con Docker

## Error: `openjdk:17-jre-slim: not found`

Este error ocurre porque Oracle descontinuó las imágenes oficiales de OpenJDK en Docker Hub.

### ✅ Solución 1: Usar amazoncorretto (Recomendado)

El `Dockerfile` principal ya está actualizado para usar `amazoncorretto:17-alpine` que es:
- Mantenido por Amazon
- Basado en OpenJDK
- Más estable y confiable
- Imagen más pequeña (Alpine Linux)

### ✅ Solución 2: Usar Eclipse Temurin

Si prefieres Eclipse Temurin, cambia la primera línea del Dockerfile:

```dockerfile
FROM eclipse-temurin:17-jre-alpine
```

### ✅ Solución 3: Usar Ubuntu (Más confiable)

Usa el archivo `Dockerfile.ubuntu`:

```bash
docker build -f Dockerfile.ubuntu -t prueba-render .
```

## Comando de construcción actualizado

```bash
# Compilar el proyecto
./mvnw clean package -DskipTests

# Construir la imagen Docker (opción principal)
docker build -t prueba-render .

# Construir con Dockerfile alternativo
docker build -f Dockerfile.alternative -t prueba-render .

# Construir con Ubuntu
docker build -f Dockerfile.ubuntu -t prueba-render .
```

## Ejecutar el contenedor

```bash
# Ejecutar en primer plano
docker run -p 8080:8080 prueba-render

# Ejecutar en segundo plano
docker run -d -p 8080:8080 --name prueba-app prueba-render

# Ejecutar con variables de entorno
docker run -p 8080:8080 -e SPRING_PROFILES_ACTIVE=prod prueba-render
```

## Verificar que funciona

```bash
# Probar el endpoint
curl http://localhost:8080/saludo

# Ver logs del contenedor
docker logs prueba-app

# Entrar al contenedor (debug)
docker exec -it prueba-app sh
```

## Imágenes alternativas recomendadas

1. **amazoncorretto** (Amazon Corretto) - Recomendado ✅
2. **eclipse-temurin** (Eclipse Temurin) - Muy buena opción ✅
3. **ubuntu + openjdk** - Más pesada pero muy confiable ✅
4. **alpine + openjdk** - Muy liviana ✅

## Para Render

Render detectará automáticamente el `Dockerfile` y construirá la imagen. No necesitas comandos especiales.

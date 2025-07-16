# Usar OpenJDK 17 como imagen base (runtime)
FROM openjdk:17-jre-slim

# Establecer el directorio de trabajo
WORKDIR /app

# Copiar el JAR compilado
COPY target/Prueba-0.0.1-SNAPSHOT.jar app.jar

# Crear usuario no-root por seguridad
RUN addgroup --system spring && adduser --system spring --ingroup spring
USER spring:spring

# Exponer el puerto 8080
EXPOSE 8080

# Configurar variables de entorno
ENV JAVA_OPTS="-Xmx512m -Xms256m"
ENV SPRING_PROFILES_ACTIVE=prod

# Comando para ejecutar la aplicación
CMD ["sh", "-c", "java $JAVA_OPTS -jar app.jar"]

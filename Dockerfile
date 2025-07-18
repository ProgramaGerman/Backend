# Usar amazoncorretto (OpenJDK de Amazon) - imagen más estable
FROM amazoncorretto:17-alpine

# Establecer el directorio de trabajo
WORKDIR /app

# Copiar el JAR compilado
COPY target/Prueba-0.0.1-SNAPSHOT.jar app.jar

# Exponer el puerto 8080
EXPOSE 8080

# Configurar variables de entorno
ENV JAVA_OPTS="-Xmx512m -Xms256m"
ENV SPRING_PROFILES_ACTIVE=prod

# Comando para ejecutar la aplicación
CMD ["sh", "-c", "java $JAVA_OPTS -jar app.jar"]

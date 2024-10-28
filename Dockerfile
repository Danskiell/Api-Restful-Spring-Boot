# Etapa de construção com uma imagem Gradle
FROM gradle:7.5.0-jdk17 AS builder
WORKDIR /app
COPY . .
RUN gradle build --no-daemon

# Etapa final: usa uma imagem mais leve
FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=builder /app/build/libs/snackAPI-0.0.1-SNAPSHOT.jar /app/app.jar

# Exponha a porta padrão
EXPOSE 8080

# Comando para iniciar a aplicação
ENTRYPOINT ["java", "-jar", "/app/app.jar"]

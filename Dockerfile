# Etapa de construção: usa uma imagem do Gradle para compilar o projeto
FROM gradle:7.5.0-jdk17 AS builder
WORKDIR /app
COPY . .
RUN gradle build --no-daemon

# Etapa final: usa uma imagem mais leve apenas com o JDK
FROM openjdk:17-jdk-slim
WORKDIR /app
# Copia o JAR gerado na etapa de construção
COPY --from=builder /app/build/libs/*.jar /app/app.jar

# Expõe a porta padrão do Spring Boot
EXPOSE 8080

# Comando para rodar a aplicação
ENTRYPOINT ["java", "-jar", "/app/app.jar"]

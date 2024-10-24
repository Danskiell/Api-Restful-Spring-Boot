# Usar uma imagem base do Java
FROM openjdk:17-jdk-slim

# Definir o diretório de trabalho dentro do contêiner
WORKDIR /app

# Copiar o arquivo JAR gerado pelo Gradle para o contêiner
COPY build/libs/snackAPI-0.0.1-SNAPSHOT.jar /app/app.jar

# Expõe a porta 8080 (a porta padrão do Spring Boot)
EXPOSE 8080

# Comando para rodar a aplicação
ENTRYPOINT ["java", "-jar", "/app/app.jar"]

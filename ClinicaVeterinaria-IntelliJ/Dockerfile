FROM openjdk:24-jdk-slim
ARG JAR_FILE=target/ClinicaVeterinaria-IntelliJ-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app_veterinaria.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app_veterinaria.jar"]
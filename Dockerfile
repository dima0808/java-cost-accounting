FROM openjdk:17-jdk-slim

WORKDIR /app

COPY . /app

RUN chmod +x mvnw

EXPOSE 8080

ENTRYPOINT ["./mvnw", "spring-boot:run"]

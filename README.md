# Java Spring Healthcheck App

Цей проєкт є базовою Java Spring REST API для обліку витрат.

## Запуск програми "вручну"

```bash
./mvnw spring-boot:run
```

## Запуск через Docker

1. Створення Docker-образу
    ```bash
    docker build . -t java-cost-counting:latest
    ```

2. Запуск контейнера
    ```bash
    docker run -it --rm -p 8080:8080 java-cost-counting:latest
    ```

## Запуск через Docker Compose

```bash
docker-compose build
docker-compose up
```

## Перевірка

Перейдіть за [посиланням](http://localhost:8080/users) для перевірки роботи сервера.
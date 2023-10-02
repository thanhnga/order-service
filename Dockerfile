# syntax=docker/dockerfile:1

FROM eclipse-temurin:17-jdk-jammy

WORKDIR /app

COPY build/libs/order-service-0.0.1.jar /app/order-service-0.0.1.jar

CMD ["java", "-jar", "order-service-0.0.1.jar"]

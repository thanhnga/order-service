# syntax=docker/dockerfile:1

FROM eclipse-temurin:17-jre-jammy

# Sao chép tệp JAR của ứng dụng vào container
COPY build/libs/order-service-0.0.1.jar /order-service-0.0.1.jar

# Chạy ứng dụng khi container khởi động
CMD ["java", "-jar", "/order-service-0.0.1.jar"]

FROM openjdk:18-jdk-alpine
WORKDIR /app

COPY . .

RUN ./mvnw install --also-make -DskipTests --batch-mode --no-transfer-progress

EXPOSE 8081
CMD ./mvnw  -am spring-boot:run
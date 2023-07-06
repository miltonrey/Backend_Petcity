FROM openjdk:18-jdk-alpine
WORKDIR /app

COPY . .

RUN sh -c './mvnw install --also-make -DskipTests --batch-mode --no-transfer-progress'

EXPOSE 5000
CMD sh -c './mvnw -am spring-boot:run'

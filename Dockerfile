# Dockerfile
FROM openjdk:24
WORKDIR /app
COPY target/demo-0.0.1-SNAPSHOT.jar app.jar
COPY Wallet_S8 /app/Wallet_S8
EXPOSE 8080
CMD ["java", "-jar", "app.jar"]

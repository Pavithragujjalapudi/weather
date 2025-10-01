# -----------------------------
# Stage 1: Build with Maven
# -----------------------------
FROM maven:3.8.7-eclipse-temurin-17 AS builder

WORKDIR /app

COPY pom.xml .
COPY src ./src

RUN mvn clean package -DskipTests

# -----------------------------
# Stage 2: Distroless runtime (Debian 12 / bookworm)
# -----------------------------
FROM gcr.io/distroless/java17-debian12

WORKDIR /app
COPY --from=builder /app/target/weather-fetcher-1.0-SNAPSHOT-shaded.jar /app/weather-fetcher.jar

# Make JAR the entrypoint
ENTRYPOINT ["java", "-jar", "/app/weather-fetcher.jar"]



# WeatherFetcher CLI App

A simple Java CLI application to fetch weather data from OpenWeatherMap API and display it in JSON format.

## Features
- Written in plain Java (no Spring)
- Fetches current weather for any city
- Runs as a Docker container
- Multi-stage Docker build with distroless Debian 12 runtime
- Minimal image size and secure runtime

## Requirements
- Java 17
- Maven
- OpenWeatherMap API key

## Usage

### Local

```bash
export OPENWEATHER_API_KEY="YOUR_KEY"
java -jar target/weather-fetcher-1.0-SNAPSHOT-shaded.jar CountryName
```
# Docker
```bash
docker build -t weather-fetcher .
docker run --rm -e OPENWEATHER_API_KEY="YOUR_KEY" weather-fetcher CountryName
```
# Project Structure
WeatherApplication/
├── Dockerfile
├── pom.xml
├── README.md
└── src/
    └── main/java/com/example/weather/WeatherFetcher.java


---




---

### **2️⃣ Stage, commit, and push**

```bash
git add README.md
git commit -m "Add README.md describing WeatherFetcher project"
git push origin main
```




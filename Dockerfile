# Build stage: JDK 21 e suficiente porque o projeto usa release 21 (roda tambem em JDK 22+).
FROM maven:3.9-eclipse-temurin-21 AS build
WORKDIR /workspace
COPY pom.xml .
COPY src ./src
RUN mvn -B -DskipTests clean package -Pserver

# Runtime image: MCP messages travel over STDIO, so no network port is exposed.
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app
COPY --from=build /workspace/target/dist-server/ /app/server/
ENV APP_DATA_DIR=/data
ENV SOLR_ENABLED=false
VOLUME ["/data"]
ENTRYPOINT ["java", "-jar", "/app/server/mcp_server01_server.jar"]

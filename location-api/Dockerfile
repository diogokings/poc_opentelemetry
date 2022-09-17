### Build Stage ###
FROM maven:3.8.6-openjdk-11-slim AS build
COPY src /src
COPY pom.xml ./
RUN mvn -f pom.xml clean package

### Package Stage ###
FROM openjdk:11
COPY --from=build /target/location-api-0.0.1-SNAPSHOT.jar /usr/local/lib/
EXPOSE 8081
ENTRYPOINT ["java","-jar","/usr/local/lib/location-api-0.0.1-SNAPSHOT.jar"]

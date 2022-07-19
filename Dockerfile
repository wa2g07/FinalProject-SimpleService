FROM gradle:jdk17-alpine AS build-stage

COPY ./ ./
RUN  ./gradlew build

FROM openjdk:17-alpine

ENV SERVICE_PORT=8080
ENV MSG="HELLO WORLD"
COPY --from=build-stage /home/gradle/build/libs/SimpleService-0.0.1-SNAPSHOT.jar /app.jar

ENTRYPOINT ["java","-jar","app.jar"]


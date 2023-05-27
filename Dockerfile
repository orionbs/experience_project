FROM openjdk:17-alpine
MAINTAINER Orion Beauny-Sugot
LABEL org.opencontainers.image.source="https://github.com/orionbs/experience_service"
COPY target/*.jar *.jar
ENTRYPOINT ["java","-jar","*.jar"]
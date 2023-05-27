FROM openjdk:17-alpine
MAINTAINER Orion Beauny-Sugot
COPY target/*.jar *.jar
ENTRYPOINT ["java","-jar","*.jar"]
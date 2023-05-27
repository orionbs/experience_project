FROM openjdk:17-alpine as builder
WORKDIR /opt/service
COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN ./mvnw dependency:go-offline
COPY ./src ./src
RUN ./mvnw clean install

FROM openjdk:17-alpine
WORKDIR /opt/service
MAINTAINER Orion Beauny-Sugot
COPY --from=builder /opt/service/target/*.jar /opt/service/*.jar
ENTRYPOINT ["java","-jar","/opt/service/*.jar"]
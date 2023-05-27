FROM openjdk:17-alpine as builder
MAINTAINER Orion Beauny-Sugot
COPY --from=builder /target/*.jar *.jar
ENTRYPOINT ["java","-jar","*.jar"]
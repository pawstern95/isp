FROM maven:3.5-jdk-8 AS build

RUN mkdir /app
WORKDIR /app
COPY ./ /app

RUN mvn clean install

FROM openjdk:8u181-jre
RUN mkdir /app
WORKDIR /app
COPY --from=build /app/target/*.jar /app/app.jar

CMD ["java", "-jar", "app.jar"]
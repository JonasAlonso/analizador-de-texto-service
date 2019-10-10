FROM maven as builder
COPY . /code/
WORKDIR /code
RUN mvn package

FROM openjdk:8-jre
COPY --from=builder /code/target/*.jar /usr/app/app.jar
WORKDIR /usr/app
EXPOSE 8081
CMD [ "java", "-jar", "app.jar" ]
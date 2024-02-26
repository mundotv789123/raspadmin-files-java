FROM openjdk:19

WORKDIR /app
COPY ./target/raspadmin-*.jar /app/raspadmin.jar
COPY ./src/main/resources/application.properties /app/application.properties

CMD [ "java", "-jar", "raspadmin.jar" ]
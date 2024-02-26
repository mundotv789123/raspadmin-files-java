FROM openjdk:19

WORKDIR /app
COPY ./target/raspadmin-*.jar /app/raspadmin.jar

CMD [ "java", "-jar", "raspadmin.jar" ]
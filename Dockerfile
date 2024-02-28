FROM openjdk:19

WORKDIR /app
COPY ./target/raspadmin-*.jar /app/raspadmin.jar
RUN mkdir /app/config
COPY ./src/main/resources/application.properties /app/config

CMD [ "java", "-jar", "raspadmin.jar", "--spring.config.location=file:/app/config/application.properties" ]
FROM openjdk:17-bullseye

WORKDIR /app
COPY ./target/raspadmin-*.jar /app/raspadmin.jar
RUN mkdir /app/config
COPY ./src/main/resources/application.properties /app/config

RUN apt-get update && apt-get install -y ffmpeg

CMD [ "java", "-jar", "raspadmin.jar", "--spring.config.location=file:/app/config/application.properties" ]
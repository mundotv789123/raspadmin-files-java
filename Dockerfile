FROM openjdk:17-bullseye
WORKDIR /app

COPY ./target/raspadmin-*.jar /app/raspadmin.jar

RUN apt-get update && apt-get install -y --no-install-recommends ffmpeg ffmpegthumbnailer && apt-get clean

CMD [ "java", "-jar", "raspadmin.jar" ]

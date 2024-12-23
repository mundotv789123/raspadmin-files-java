FROM ubuntu

WORKDIR /app/data

COPY ./target/raspadmin-*.jar /app/raspadmin.jar

RUN apt-get update && apt-get install -y --no-install-recommends openjdk-17-jre-headless ffmpeg ffmpegthumbnailer && apt-get clean

CMD [ "java", "-jar", "../raspadmin.jar" ]

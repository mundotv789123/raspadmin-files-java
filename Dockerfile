#build
FROM maven:3.8.5-openjdk-17-slim AS build
WORKDIR /app

COPY . .
RUN mvn package

#image
FROM openjdk:17-bullseye
WORKDIR /app/data

COPY --from=build /app/target/raspadmin-*.jar /app/raspadmin.jar

RUN apt-get update && apt-get install -y --no-install-recommends ffmpeg ffmpegthumbnailer && apt-get clean

CMD [ "java", "-jar", "../raspadmin.jar" ]

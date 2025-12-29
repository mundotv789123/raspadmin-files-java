FROM alpine:3.23 AS build

RUN apk update
RUN apk add maven openjdk21-jdk

WORKDIR /app

COPY ./src ./src
COPY ./pom.xml ./pom.xml
COPY ./files ./files

RUN mvn package

FROM alpine:3.23 AS app

RUN apk update

RUN apk add openjdk21-jre-headless ffmpeg ffmpegthumbnailer

WORKDIR /home/app/data

COPY --from=build /app/target/raspadmin-*.jar /home/app/raspadmin.jar

CMD [ "java", "-jar", "../raspadmin.jar" ]

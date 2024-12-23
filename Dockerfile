FROM ubuntu

WORKDIR /app/data

COPY ./target/raspadmin-*.jar /app/raspadmin.jar

RUN apt-get update
RUN apt-get -y install locales
RUN sed -i '/en_US.UTF-8/s/^# //g' /etc/locale.gen && locale-gen

RUN apt-get install -y --no-install-recommends openjdk-17-jre-headless ffmpeg ffmpegthumbnailer
RUN apt-get clean

ENV LANG=en_US.UTF-8 
ENV LANGUAGE=en_US:en 
ENV LC_ALL=en_US.UTF-8

CMD [ "java", "-jar", "../raspadmin.jar" ]

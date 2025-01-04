FROM mundotv789123/raspadmin:base

WORKDIR /app/data

COPY ./target/raspadmin-*.jar /app/raspadmin.jar

CMD [ "java", "-jar", "../raspadmin.jar" ]

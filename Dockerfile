FROM mundotv789123/raspadmin:java

WORKDIR /home/app/data

COPY ./target/raspadmin-*.jar /home/app/raspadmin.jar

CMD [ "java", "-jar", "../raspadmin.jar" ]

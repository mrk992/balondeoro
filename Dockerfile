FROM adoptopenjdk/openjdk8:latest
RUN mkdir /usr/src/bootdocker
COPY target/balonOro-0.0.1-SNAPSHOT.jar /usr/src/bootdocker
WORKDIR /usr/src/bootdocker
EXPOSE 8080
CMD ["java", "-Dspring.data.mongodb.uri=mongodb://mongo:27017/default", "-jar", "/usr/src/bootdocker/balonOro-0.0.1-SNAPSHOT.jar"]
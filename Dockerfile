FROM adoptopenjdk/openjdk16:jre-16.0.1_9-debianslim
WORKDIR pensioner-details
COPY target/pensioner-*.jar pensioner-detail.jar
COPY /pensioner-details-database.csv pensioner-details-database.csv
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "pensioner-detail.jar" ]

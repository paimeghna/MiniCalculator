FROM openjdk:8
MAINTAINER Meghna Pai meghnapai0312@gmail.com
COPY ./target/MiniCalculator-1.0-SNAPSHOT-jar-with-dependencies.jar ./
WORKDIR ./
CMD ["java", "-jar", "MiniCalculator-1.0-SNAPSHOT-jar-with-dependencies.jar"]
FROM maven:3-openjdk-15
MAINTAINER Guilherme Augusto Moreira Baldissera
VOLUME /tmp
RUN mkdir /cv
WORKDIR /cv
COPY . /cv/
RUN mvn install -DskipTests

ENTRYPOINT ["mvn","spring-boot:run"]

EXPOSE 8080
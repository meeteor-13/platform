FROM openjdk:11-jre-slim

LABEL name="meeteor13-core" \
      maintainer="aliaksandr.babai@gmail.com"

ARG WORK_DIR=/meeteor13

ENV SERVER_PORT=80 \
    JAVA_OPTS=""

WORKDIR $WORK_DIR
COPY target/*.jar .

HEALTHCHECK --interval=30s --timeout=3s --retries=3 CMD curl -f http://localhost:${SERVER_PORT}/actuator/health || exit 1

EXPOSE $SERVER_PORT
CMD java $JAVA_OPTS -Djava.security.egd=file:/dev/urandom -jar *.jar

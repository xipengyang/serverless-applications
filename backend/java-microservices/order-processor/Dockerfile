FROM openjdk:8-jdk-alpine
COPY target/order-service-0.0.1.jar service.jar
ENV JAVA_OPTS=
ENTRYPOINT ["sh", "-c", "java$JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /service.jar"]

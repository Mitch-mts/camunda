FROM openjdk:16-alpine3.13
RUN echo "Africa/Harare" > /etc/timezone
ADD target/lafayette.jar app.jar
# Run the jar
ENTRYPOINT ["java", "-jar", "app.jar"]

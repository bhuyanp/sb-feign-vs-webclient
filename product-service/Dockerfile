FROM amazoncorretto:21

ARG JARFILE=target/*.jar

COPY ${JARFILE} app.jar

ENTRYPOINT ["java","-jar","app.jar","--spring.profiles.active=docker"]
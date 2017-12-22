FROM java:8
MAINTAINER dinuka.malalanayake@gmail.com
ARG JAR_FILE
ADD ${JAR_FILE} config-receiver.jar
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom","-jar","/config-receiver.jar"]
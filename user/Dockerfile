FROM openjdk:8
EXPOSE 7070
EXPOSE 27018
EXPOSE 27017
EXPOSE 8180
ADD target/users-0.0.1-SNAPSHOT.jar users.jar
ENTRYPOINT ["java","-jar","users.jar"]
FROM openjdk:8
EXPOSE 8090
ADD target/posts-0.0.1-SNAPSHOT.jar post.jar
ENTRYPOINT ["java","-jar","post.jar"]
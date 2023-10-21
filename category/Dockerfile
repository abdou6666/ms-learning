FROM openjdk:8
#default port
EXPOSE 8090


ADD target/category-0.0.1-SNAPSHOT.jar category.jar

ENTRYPOINT  ["java", "-jar", "category.jar"]
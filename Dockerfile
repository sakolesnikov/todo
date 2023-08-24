FROM openjdk:20-jdk-slim
COPY todo-service/target/todo-service.jar /todo-service.jar
CMD java $JAVA_OPTS $SPRING_OPTS -jar /todo-service.jar
EXPOSE 8080

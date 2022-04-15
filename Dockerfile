# Created Dockerfile using multi-stage setup
FROM maven:3.6.3-jdk-11-slim AS build
WORKDIR /app
RUN mkdir src
COPY src ./src
COPY pom.xml .
# Build Code
RUN ls /app
RUN mvn clean package
# Test code
RUN mvn test
# ENTRYPOINT ["java","-cp","./target/devops_scientific_calc-0.0.1-SNAPSHOT.jar", "devops_scientific_calc.Application"]

# Run Code
FROM openjdk:11-jre-slim
WORKDIR /home
RUN ls /home
COPY --from=build /app/target/devops_scientific_calc-0.0.1-SNAPSHOT.jar devops_scientific_calc-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-cp","/home/devops_scientific_calc-0.0.1-SNAPSHOT.jar", "devops_scientific_calc.Application"]
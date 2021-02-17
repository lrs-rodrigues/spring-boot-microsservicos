FROM maven:3.6.3-openjdk-11-slim AS MAVEN_BUILD

WORKDIR /build/

COPY pom.xml /build/
RUN mvn -T 4C dependency:go-offline


COPY src /build/src/
RUN mvn -T 4C package -Dmaven.test.skip=true


FROM openjdk:11-jdk-slim

WORKDIR /app

COPY --from=MAVEN_BUILD /build/target/user-0.0.1-SNAPSHOT.jar /app/

ENTRYPOINT [ "java", "-jar", "user-0.0.1-SNAPSHOT.jar" ]

EXPOSE 7001
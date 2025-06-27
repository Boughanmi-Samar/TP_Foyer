#FROM eclipse-temurin:17-jdk
#EXPOSE 8089
#ADD target/tp-foyer-5.0.0.jar /tp-foyer-5.0.0.jar
#ENTRYPOINT ["java", "-jar", "/tp-foyer-5.0.0.jar"]

FROM eclipse-temurin:17-jdk

COPY target/tp-foyer-5.0.0.jar /tp-foyer.jar

ENTRYPOINT ["java", "-jar", "/tp-foyer.jar"]

EXPOSE 8089
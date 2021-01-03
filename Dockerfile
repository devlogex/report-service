FROM maven AS build
COPY settings.xml /usr/share/maven/ref/settings.xml
COPY common /home/root/report/common
COPY runner /home/root/report/runner
COPY sdk /home/root/report/sdk
COPY dbservice /home/root/report/dbservice
COPY history /home/root/report/history
COPY pom.xml /home/root/report/pom.xml
RUN mvn -B -f /home/root/report/pom.xml -s /usr/share/maven/ref/settings.xml clean package

FROM openjdk:8
COPY --from=build /home/root/report/runner/target/report-runner-jar-with-dependencies.jar /var/lib/report-runner-jar-with-dependencies.jar
EXPOSE 9006
EXPOSE 8006
CMD ["java","-jar","/var/lib/report-runner-jar-with-dependencies.jar"]
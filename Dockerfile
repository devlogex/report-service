FROM pw_env
WORKDIR /data/reportservice
COPY runner/target/report-runner-jar-with-dependencies.jar .
# RUN mvn -B -f /data/reportservice/pom.xml -s /usr/share/maven/ref/settings.xml clean package
CMD ["java", "-jar", "report-runner-jar-with-dependencies.jar"]
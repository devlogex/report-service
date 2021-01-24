FROM pw_env
WORKDIR /data/reportservice
COPY . .
RUN mvn -B -f /data/reportservice/pom.xml -s /usr/share/maven/ref/settings.xml clean package
CMD ["java", "-jar", "runner/target/report-runner-jar-with-dependencies.jar"]
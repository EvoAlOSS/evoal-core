FROM library/maven:3.8.7-eclipse-temurin-17
COPY pom-eclipse.xml /tmp
COPY pom-orbit.xml /tmp
RUN mvn -f /tmp/pom-eclipse.xml package
RUN mvn -f /tmp/pom-orbit.xml package
RUN rm /tmp/pom-eclipse.xml
RUN rm /tmp/pom-orbit.xml
RUN rm -rf /tmp/target
RUN rm -rf /root/.m2/repository

ENTRYPOINT ["/usr/local/bin/mvn-entrypoint.sh"]
CMD ["mvn"]
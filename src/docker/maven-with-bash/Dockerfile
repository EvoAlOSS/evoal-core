FROM library/maven:3.9.12-eclipse-temurin-25-alpine
RUN apk add zsh
RUN sed -e "s;/bin/ash;/bin/zsh;g" /etc/passwd > passwd
RUN mv passwd /etc/passwd

ENTRYPOINT ["/usr/local/bin/mvn-entrypoint.sh"]
CMD ["mvn"]
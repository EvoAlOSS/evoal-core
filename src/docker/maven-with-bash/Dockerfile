FROM library/maven:3.9.12-eclipse-temurin-25-alpine
RUN apk add zsh
RUN sed -e "s;/bin/.*sh$;/bin/bash;g" /etc/passwd > passwd
RUN mv passwd /etc/passwd
RUN apk add openblas
RUN ln -sf /usr/lib/libopenblas.so.3 /usr/lib/libopenblas.so

ENTRYPOINT ["/usr/local/bin/mvn-entrypoint.sh"]
CMD ["mvn"]
# Image of the EvoAl Maven jobs: Maven 3.9 with JDK 25, bash, zsh, OpenBLAS (for
#   smile) and the third-party dependencies of the EvoAl build in /opt/m2-tail.
#   The pipeline uses /opt/m2-tail as read-only tail repository
#   (-Dmaven.repo.local.tail), so the jobs do not download these dependencies;
#   missing ones still come from the remote repositories.
#
# Build context: the root of the repository. The pipeline builds the image on
#   develop when this folder or a pom of src/evoal changes (job
#   image:maven-with-bash).

FROM docker.io/library/maven:3.9.12-eclipse-temurin-25-alpine AS base
RUN apk add --no-cache zsh openblas \
 && ln -sf /usr/lib/libopenblas.so.3 /usr/lib/libopenblas.so \
 && sed -i -e "s;/bin/.*sh$;/bin/bash;g" /etc/passwd

# Fills the tail repository by running the build of the merge request pipeline
#   (unit tests, JaCoCo and the regressions profile without the regressions).
#   Test failures are ignored, only the dependencies matter. The EvoAl
#   artifacts are removed, the pipeline builds or downloads them.
FROM base AS dependencies
ARG EVOAL_LANGUAGES_VERSION=2026.10.0-SNAPSHOT
COPY . /src
WORKDIR /src
RUN mvn --batch-mode -f src/evoal/pom.xml \
        -Dmaven.repo.local=/opt/m2-tail \
        -Dbranch=develop \
        -Devoal.languages.version=${EVOAL_LANGUAGES_VERSION} \
        -Pjacoco,regressions -DskipITs -Dmaven.test.failure.ignore=true \
        flatten:flatten verify \
 && rm -rf /opt/m2-tail/de/evoal \
 && find /opt/m2-tail \( -name "*.lastUpdated" -o -name "resolver-status.properties" \) -delete

FROM base
COPY --from=dependencies /opt/m2-tail /opt/m2-tail

ENTRYPOINT ["/usr/local/bin/mvn-entrypoint.sh"]
CMD ["mvn"]

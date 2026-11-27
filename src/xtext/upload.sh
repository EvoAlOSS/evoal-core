#!/usr/bin/env bash
#
# Installs the merged org.eclipse.xtext jar that merge.sh built in target/ into the local Maven
#   repository and deploys it to the custom-xtext package registry of EvoAl (see README.md):
#
#   upload.sh <merged version, e.g. 2.41.1>
#
# The deployment needs the credentials of the server 'evoal-artifacts' in Maven's settings.

set -euo pipefail

if [ "$#" -ne 1 ]; then
    echo "Usage: $0 <merged version, e.g. 2.41.1>" >&2
    exit 1
fi

VERSION="$1"
TARGET="$(cd "$(dirname "$0")" && pwd -P)/target"
JAR="$TARGET/org.eclipse.xtext-${VERSION}.jar"
POM="$TARGET/org.eclipse.xtext-${VERSION}.pom"

for file in "$JAR" "$POM"; do
    [ -f "$file" ] || { echo "No $file; run merge.sh first." >&2; exit 1; }
done

# for local testing
mvn -X \
    -Dorg.slf4j.simpleLogger.log.org.apache.maven.wagon.providers.http.httpclient=trace \
    -Dorg.slf4j.simpleLogger.log.org.apache.maven.wagon.providers.http.httpclient.wire=trace \
    install:install-file \
    -DgroupId=org.eclipse.xtext \
    -DartifactId=org.eclipse.xtext \
    -Dversion="$VERSION" \
    -Dpackaging=jar \
    -Dfile="$JAR" \
    -DgeneratePom=false \
    -DpomFile="$POM"

# for final push
mvn -X \
    -Dorg.slf4j.simpleLogger.log.org.apache.maven.wagon.providers.http.httpclient=trace \
    -Dorg.slf4j.simpleLogger.log.org.apache.maven.wagon.providers.http.httpclient.wire=trace \
    deploy:deploy-file \
    -DgroupId=org.eclipse.xtext \
    -DartifactId=org.eclipse.xtext \
    -Dversion="$VERSION" \
    -Dpackaging=jar \
    -Dfile="$JAR" \
    -DrepositoryId=evoal-artifacts \
    -Durl=https://gitlab.informatik.uni-bremen.de/api/v4/projects/30380/packages/maven/custom-xtext \
    -DgeneratePom=false \
    -DpomFile="$POM"

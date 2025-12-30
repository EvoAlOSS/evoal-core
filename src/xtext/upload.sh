# for local testing

VERSION=2.41.1

mvn -X \
    -Dorg.slf4j.simpleLogger.log.org.apache.maven.wagon.providers.http.httpclient=trace \
    -Dorg.slf4j.simpleLogger.log.org.apache.maven.wagon.providers.http.httpclient.wire=trace \
    install:install-file \
    -DgroupId=org.eclipse.xtext \
    -DartifactId=org.eclipse.xtext \
    -Dversion=$VERSION \
    -Dpackaging=jar \
    -Dfile=org.eclipse.xtext-${VERSION}.jar \
    -DgeneratePom=false \
    -DpomFile=org.eclipse.xtext-${VERSION}.pom

# for final push
mvn -X \
    -Dorg.slf4j.simpleLogger.log.org.apache.maven.wagon.providers.http.httpclient=trace \
    -Dorg.slf4j.simpleLogger.log.org.apache.maven.wagon.providers.http.httpclient.wire=trace \
    deploy:deploy-file \
    -DgroupId=org.eclipse.xtext \
    -DartifactId=org.eclipse.xtext \
    -Dversion=${VERSION} \
    -Dpackaging=jar \
    -Dfile=org.eclipse.xtext-${VERSION}.jar \
    -DrepositoryId=evoal-artifacts \
    -Durl=https://gitlab.informatik.uni-bremen.de/api/v4/projects/30380/packages/maven/custom-xtext \
    -DgeneratePom=false \
    -DpomFile=org.eclipse.xtext-${VERSION}.pom




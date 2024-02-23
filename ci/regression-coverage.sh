JACOCO_PATH=/Users/berber/bin/jacoco

echo "Downloading Jacoco-Agent"
mvn org.apache.maven.plugins:maven-dependency-plugin:2.1:get -Dmaven.repo.local=${CI_PROJECT_DIR}/.m2/repository -Dartifact=org.jacoco:org.jacoco.agent:0.8.10 -DrepoUrl=https://repo.maven.apache.org/maven2/

pushd evoal/examples

export EVOAL_VM=-javaagent:${CI_PROJECT_DIR}/.m2/repository/org/jacoco/org.jacoco.agent/0.8.10/org.jacoco.agent-0.8.10-runtime.jar=dumponexit=true

set -e
for EXAMPLE in *; do
    if [ ! -d $EXAMPLE ]; then
      continue
    fi 

    pushd $EXAMPLE
    for SCRIPT in *sh; do
        echo "Executing example: $SCRIPT"
        ./$SCRIPT
    done
    popd

done
popd
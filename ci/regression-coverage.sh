#!/bin/bash

set -e -x -u

if [ -z ${CI_PROJECT_DIR+x} ]; then
    CI_PROJECT_DIR=$HOME
fi

echo "Downloading Jacoco-Agent"
JACOCO_JAR=${CI_PROJECT_DIR}/.m2/repository/org/jacoco/org.jacoco.agent/0.8.14/org.jacoco.agent-0.8.14-runtime.jar

if [ ! -e ${JACOCO_JAR} ]; then
  mkdir -p `dirname $JACOCO_JAR`
  curl -o ${JACOCO_JAR} https://repo1.maven.org/maven2/org/jacoco/org.jacoco.agent/0.8.14/org.jacoco.agent-0.8.14-runtime.jar
fi

echo "Changing into examples folder"
pushd evoal/examples

export EVOAL_VM=-javaagent:${JACOCO_JAR}=dumponexit=true

for EXAMPLE in *; do
    if [ ! -d $EXAMPLE ]; then
      continue
    fi 

    if [ "$EXAMPLE" = "surrogate.adaption-search" ]; then
      continue
    fi

    if [ "$EXAMPLE" = "surrogate.adaption-training" ]; then
      continue
    fi

    pushd $EXAMPLE
    for SCRIPT in *sh; do
        echo "Executing example: $SH $SCRIPT"
        $SHELL $SCRIPT
    done
    popd
done
popd

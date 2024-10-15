#!/bin/bash

JACOCO_PATH=/Users/berber/bin/jacoco
set -e

echo "Downloading Jacoco-Agent"
mkdir -p ${CI_PROJECT_DIR}/.m2/repository/org/jacoco/org.jacoco.agent/0.8.10/
curl -o ${CI_PROJECT_DIR}/.m2/repository/org/jacoco/org.jacoco.agent/0.8.10/org.jacoco.agent-0.8.10-runtime.jar https://repo1.maven.org/maven2/org/jacoco/org.jacoco.agent/0.8.10/org.jacoco.agent-0.8.10-runtime.jar
pushd evoal/examples

export EVOAL_VM=-javaagent:${CI_PROJECT_DIR}/.m2/repository/org/jacoco/org.jacoco.agent/0.8.10/org.jacoco.agent-0.8.10-runtime.jar=dumponexit=true

set -e
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
        echo "Executing example: $SCRIPT"
        ./$SCRIPT
    done
    popd
done
popd

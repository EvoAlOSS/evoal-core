#!/bin/bash

if [ -z ${EVOAL_HOME+x} ]; then
  EVOAL_HOME=$( cd -- "$(dirname $0)/../" >/dev/null 2>&1 ; pwd -P )
fi

source $EVOAL_HOME/bin/paths.env

if [ "$#" -lt 3 ]; then
    echo "Usage: $0 <execution-folder> <eal-file> <output-folder>"
    exit 1
fi

cd "$1" || exit 1

POSITIONAL_ARGUMENTS=( "$@" )
POSITIONAL_ARGUMENTS=("${POSITIONAL_ARGUMENTS[@]:3}")

declare -a JVM_ARGUMENTS=()

if [ ${EVOAL_VM+x} ]; then
  JVM_ARGUMENTS+=( "${EVOAL_VM[@]}" )
fi

if [ ${EVOAL_DEBUG+x} ]; then
  JVM_ARGUMENTS+=( "-agentlib:jdwp=transport=dt_socket,server=y,suspend=y,address=1044" )
fi

if [ ${EVOAL_LOGGING+x} ]; then
  POSITIONAL_ARGUMENTS+=( "-Bcore:logging=$EVOAL_LOGGING" )
fi

set -x
java ${JVM_ARGUMENTS[@]} \
     ${CLASSPATH[@]} \
     ${POSITIONAL_ARGUMENTS[@]} \
     -Bcore:main=heuristic-search-evaluation \
     "-Bcore:optimisation-configuration-file=$2" \
     "-Bcore:evaluation-output-folder=$3" \
     "-Bcore:evaluation-iterations=$4"

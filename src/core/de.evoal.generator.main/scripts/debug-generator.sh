#!/bin/bash

if [ -z ${EVOAL_HOME+x} ]; then
  EVOAL_HOME=$( cd -- "$(dirname $0)/../" >/dev/null 2>&1 ; pwd -P )
fi

source $EVOAL_HOME/bin/paths.env

if [ "$#" -lt 2 ]; then
    echo "Usage: $0 <execution-folder> <generator-file> [EvoAl parameters]"
    exit 1
fi

cd "$1" || exit 1

POSITIONAL_ARGUMENTS=( "$@" )
POSITIONAL_ARGUMENTS=("${POSITIONAL_ARGUMENTS[@]:2}")

set -x
java -agentlib:jdwp=transport=dt_socket,server=y,suspend=y,address=1044 \
     ${CLASSPATH[@]} \
     ${POSITIONAL_ARGUMENTS[@]} \
     -Bcore:main=data-generator \
     "-Bgenerator:configuration-file=$2"

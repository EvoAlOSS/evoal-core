#!/bin/sh

if [ -z ${EVOAL_HOME+x} ]; then
  EVOAL_HOME=$( cd -- "$(dirname $0)/../" >/dev/null 2>&1 ; pwd -P )
fi

source $EVOAL_HOME/bin/paths.env

if [ "$#" -ne 3 ]; then
    echo "Usage: $0 <execution-folder> <eal-file> <output-folder>"
    exit 1
fi

cd "$1" || exit 1

set -x
java ${CLASSPATH[@]} \
     -Bcore:main=heuristic-search \
     "-Bcore:optimisation-configuration-file=$2" \
     "-Bcore:evaluation-output-folder=$3"

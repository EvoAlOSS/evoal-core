#!/bin/bash

if [ -z ${EVOAL_HOME+x} ]; then
  EVOAL_HOME=$( cd -- "$(dirname $0)/../" >/dev/null 2>&1 ; pwd -P )
fi

source $EVOAL_HOME/bin/paths.env

if [ "$#" -ne 7 ]; then
    echo "Usage: $0 <execution-folder> <ea-file> <mll-file> <pre-trained.pson> <training-points.json> <output> <constraint-folder>"
    exit 1
fi

cd "$1" || exit 1

set -x
java -agentlib:jdwp=transport=dt_socket,server=y,suspend=y,address=1044\
     ${CLASSPATH[@]} \
     -Bcore:main=heuristic-search \
     "-Bcore:optimisation-configuration-file=$2" \
     "-Bsurrogate:configuration-file=$3" \
     "-Bsurrogate:pre-trained=$4" \
     "-Bsurrogate:training-data=$5"\
     "-Bcore:evaluation-output-folder=$6" \
     "-Bcore:constraint-folder=$7"

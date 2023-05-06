#!/bin/bash

source $( cd -- "$(dirname $0)/" >/dev/null 2>&1 ; pwd -P)/paths.env

if [ "$#" -ne 3 ]; then
    echo "Usage: $0 <execution-folder> <eal-file> <output-folder>"
    exit 1
fi

cd $1

set -x
java $CLASSPATH \
    "-Bcore:logging=debug" \
     "-Bcore:main=heuristic-search" \
     "-Bcore:optimisation-configuration-file=$2" \
     "-Bcore:evaluation-output-folder=$3"

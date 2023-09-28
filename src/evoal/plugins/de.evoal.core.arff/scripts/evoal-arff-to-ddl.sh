#!/bin/bash

if [ -z ${EVOAL_HOME+x} ]; then
  EVOAL_HOME=$( cd -- "$(dirname $0)/../" >/dev/null 2>&1 ; pwd -P )
fi

source $EVOAL_HOME/bin/paths.env

if [ "$#" -ne 3 ]; then
    echo "Usage: $0 <execution-folder> <input.arff> <output.ddl>"
    exit 1
fi

cd "$1" || exit 1

set -x
java ${CLASSPATH[@]} \
     -Bcore:main=extract-data-definition-from-arff \
     -Barff:input=$2 \
     -Barff:output=$3

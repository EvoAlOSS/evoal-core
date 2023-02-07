#!/bin/bash

source $( cd -- "$(dirname $0)/" >/dev/null 2>&1 ; pwd -P)/paths.env

if [ "$#" -ne 3 ]; then
    echo "Usage: $0 <execution-folder> <input.arff> <output.ddl>"
    exit 1
fi

cd $1

set -x
java $CLASSPATH \
     -Bcore:main=extract-data-definition-from-arff \
     -Barff:input=$2 \
     -Barff:output=$3

#!/bin/bash

source $( cd -- "$(dirname $0)/" >/dev/null 2>&1 ; pwd -P)/paths.env

if [ "$#" -ne 2 ]; then
    echo "Usage: $0 <execution-folder> <mll-file>"
    exit 1
fi

cd $1

set -x
java -agentlib:jdwp=transport=dt_socket,server=y,suspend=y,address=1044\
     $CLASSPATH \
     -Bcore:main=surrogate-training \
     "-Bsurrogate:configuration-file=$2"

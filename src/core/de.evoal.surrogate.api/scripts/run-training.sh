#!/bin/bash

source $( cd -- "$(dirname $0)/" >/dev/null 2>&1 ; pwd -P)/paths.env

if [ "$#" -ne 2 ]; then
    echo "Usage: $0 <execution-folder> <mll-file>"
    exit 1
fi

cd $1

set -x
java $CLASSPATH \
     -Bcore:main=surrogate-training \
     "-Bsurrogate:configuration-file=$2"

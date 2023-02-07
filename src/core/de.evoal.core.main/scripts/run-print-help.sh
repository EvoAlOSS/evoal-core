#!/bin/bash

source $( cd -- "$(dirname $0)/" >/dev/null 2>&1 ; pwd -P)/paths.env

if [ "$#" -ne 0 ]; then
    echo "Usage: $0"
    exit 1
fi

cd $1

set -x
java $CLASSPATH
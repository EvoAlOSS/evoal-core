#!/bin/bash

if [ -z ${EVOAL_HOME+x} ]; then
  EVOAL_HOME=$( cd -- "$(dirname $0)/../" >/dev/null 2>&1 ; pwd -P )
fi

source $EVOAL_HOME/bin/paths.env

if [ "$#" -ne 2 ]; then
    echo "Usage: $0 <execution-folder> <mll-file>"
    exit 1
fi

cd $1

set -x
java $CLASSPATH \
     -Bcore:main=surrogate-training \
     "-Bsurrogate:configuration-file=$2"

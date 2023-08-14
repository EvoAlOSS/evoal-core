#!/bin/sh

if [ -z ${EVOAL_HOME+x} ]; then
  EVOAL_HOME=$( cd -- "$(dirname $0)/../" >/dev/null 2>&1 ; pwd -P )
fi

source $EVOAL_HOME/bin/paths.env

if [ "$#" -lt 2 ]; then
    echo "Usage: $0 <execution-folder> <mll-file>  [EvoAl parameters]"
    exit 1
fi

cd "$1" || exit 1

POSITIONAL_ARGUMENTS=( "$@" )
POSITIONAL_ARGUMENTS=("${POSITIONAL_ARGUMENTS[@]:2}")


set -x
java ${CLASSPATH[@]}  \
     ${POSITIONAL_ARGUMENTS[@]} \
     -Bcore:main=surrogate-training \
     "-Bsurrogate:configuration-file=$2"

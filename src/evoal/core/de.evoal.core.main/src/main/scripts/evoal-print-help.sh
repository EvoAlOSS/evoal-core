#!/usr/bin/env bash

# Prints the functions and parameters of the installation.

if [ -z ${EVOAL_HOME+x} ]; then
  EVOAL_HOME=$( cd -- "$(dirname $0)/../" >/dev/null 2>&1 ; pwd -P )
fi

source $EVOAL_HOME/bin/paths.env

if [ "$#" -ne 0 ]; then
    echo "Usage: $0"
    exit 1
fi

declare -a LOCAL_JVM_ARGUMENTS=()

if [ ${EVOAL_VM+x} ]; then
  LOCAL_JVM_ARGUMENTS+=( "${EVOAL_VM[@]}" )
fi

if [ ${EVOAL_DEBUG+x} ]; then
  LOCAL_JVM_ARGUMENTS+=( "-agentlib:jdwp=transport=dt_socket,server=y,suspend=y,address=1044" )
fi

# Evoal prints the help only if --help is the only argument
java ${LOCAL_JVM_ARGUMENTS[@]} \
     ${EVOAL_JVM_ARGUMENTS[@]} \
     --help

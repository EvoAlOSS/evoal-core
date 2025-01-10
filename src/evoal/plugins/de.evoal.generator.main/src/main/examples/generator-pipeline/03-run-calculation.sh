#!/bin/bash

if [ -z ${EVOAL_HOME+x} ]; then
  export EVOAL_HOME=$( cd -- "$(dirname $0)/../../" >/dev/null 2>&1 ; pwd -P )
fi

$SHELL $EVOAL_HOME/bin/evoal-pipeline.sh . recalculate.generator


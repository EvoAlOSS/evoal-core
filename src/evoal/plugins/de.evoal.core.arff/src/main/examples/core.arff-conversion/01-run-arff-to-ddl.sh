#!/usr/bin/env bash

# Derives the DDL module output/measurements.ddl from the attributes of data.arff.

set -e

export EVOAL_HOME=${EVOAL_HOME:-$( cd -- "$(dirname "$0")/../../" >/dev/null 2>&1 ; pwd -P )}
export EVOAL_LOGGING=${EVOAL_LOGGING:-INFO}

mkdir -p output
"${SHELL:-bash}" "$EVOAL_HOME/bin/evoal-arff-to-ddl.sh" . data.arff output/measurements.ddl

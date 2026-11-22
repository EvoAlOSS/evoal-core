#!/usr/bin/env bash

# Samples points of the triangle x >= 0, y >= 0, x + y <= 1 into output/triangle.csv by
# dropping the samples that violate the constraints of triangle.ddl.

set -e

export EVOAL_HOME=${EVOAL_HOME:-$( cd -- "$(dirname "$0")/../../" >/dev/null 2>&1 ; pwd -P )}
export EVOAL_LOGGING=${EVOAL_LOGGING:-INFO}

mkdir -p output
"${SHELL:-bash}" "$EVOAL_HOME/bin/evoal-pipeline.sh" . triangle.generator

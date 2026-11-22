#!/usr/bin/env bash

# Samples points on [0, 1] whose density grows linearly (2x) into output/points.csv by
# rejection sampling from a uniform distribution.

set -e

export EVOAL_HOME=${EVOAL_HOME:-$( cd -- "$(dirname "$0")/../../" >/dev/null 2>&1 ; pwd -P )}
export EVOAL_LOGGING=${EVOAL_LOGGING:-INFO}

mkdir -p output
"${SHELL:-bash}" "$EVOAL_HOME/bin/evoal-pipeline.sh" . points.generator

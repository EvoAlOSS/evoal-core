#!/usr/bin/env bash

# Predicts with output/model.pson in a generator pipeline; output/predictions.csv holds the
# predictions in the original unit of y:0.

set -e

export EVOAL_HOME=${EVOAL_HOME:-$( cd -- "$(dirname "$0")/../../" >/dev/null 2>&1 ; pwd -P )}
export EVOAL_LOGGING=${EVOAL_LOGGING:-INFO}

mkdir -p output
"${SHELL:-bash}" "$EVOAL_HOME/bin/evoal-pipeline.sh" . prediction.generator

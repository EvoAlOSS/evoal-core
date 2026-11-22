#!/usr/bin/env bash

# Trains the surrogate model output/model.pson on the data of 01-run-generator.sh and tests
# it on the gap; the goodness of fit on both data sets is in output/gof.json.

set -e

export EVOAL_HOME=${EVOAL_HOME:-$( cd -- "$(dirname "$0")/../../" >/dev/null 2>&1 ; pwd -P )}
export EVOAL_LOGGING=${EVOAL_LOGGING:-INFO}

mkdir -p output
"${SHELL:-bash}" "$EVOAL_HOME/bin/evoal-training.sh" . training.mll

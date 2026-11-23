#!/usr/bin/env bash

# Trains the nearest neighbour output/model.pson and assesses it by resampling; the goodness of
# fit on the training data and of each scheme is in output/gof.json.

set -e

export EVOAL_HOME=${EVOAL_HOME:-$( cd -- "$(dirname "$0")/../../" >/dev/null 2>&1 ; pwd -P )}
export EVOAL_LOGGING=${EVOAL_LOGGING:-INFO}

mkdir -p output
"${SHELL:-bash}" "$EVOAL_HOME/bin/evoal-training.sh" . training.mll

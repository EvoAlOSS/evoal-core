#!/usr/bin/env bash

# Trains the SVR output/model.pson on prepared data and tests it; the goodness of fit (in the
# original unit of y:0) is in output/gof.json.

set -e

export EVOAL_HOME=${EVOAL_HOME:-$( cd -- "$(dirname "$0")/../../" >/dev/null 2>&1 ; pwd -P )}
export EVOAL_LOGGING=${EVOAL_LOGGING:-INFO}

mkdir -p output
"${SHELL:-bash}" "$EVOAL_HOME/bin/evoal-training.sh" . training.mll

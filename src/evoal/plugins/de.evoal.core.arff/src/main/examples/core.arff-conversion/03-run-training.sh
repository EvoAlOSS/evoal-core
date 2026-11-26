#!/usr/bin/env bash

# Trains the linear regression output/model.pson directly on data.arff; the rows with a missing
# value are left out. The goodness of fit is in output/gof.json.

set -e

export EVOAL_HOME=${EVOAL_HOME:-$( cd -- "$(dirname "$0")/../../" >/dev/null 2>&1 ; pwd -P )}
export EVOAL_LOGGING=${EVOAL_LOGGING:-INFO}

mkdir -p output
"${SHELL:-bash}" "$EVOAL_HOME/bin/evoal-training.sh" . training.mll

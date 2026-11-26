#!/usr/bin/env bash

# Trains the linear regression output/model.pson on the rows of data.json that the validation
# pipeline keeps; the goodness of fit on these rows is in output/gof.json.

set -e

export EVOAL_HOME=${EVOAL_HOME:-$( cd -- "$(dirname "$0")/../../" >/dev/null 2>&1 ; pwd -P )}
export EVOAL_LOGGING=${EVOAL_LOGGING:-INFO}

mkdir -p output
"${SHELL:-bash}" "$EVOAL_HOME/bin/evoal-training.sh" . training.mll

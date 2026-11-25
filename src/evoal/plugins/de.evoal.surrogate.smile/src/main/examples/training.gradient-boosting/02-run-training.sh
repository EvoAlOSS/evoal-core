#!/usr/bin/env bash

# Trains the gradient boosting model model/gradient-boosting.onnx on the data of
# 01-run-generator.sh and tests it on the right segment; the goodness of fit, including the
# coverage and the width of the prediction interval, is in output/gof.json.

set -e

export EVOAL_HOME=${EVOAL_HOME:-$( cd -- "$(dirname "$0")/../../" >/dev/null 2>&1 ; pwd -P )}
export EVOAL_LOGGING=${EVOAL_LOGGING:-INFO}

mkdir -p output model
"${SHELL:-bash}" "$EVOAL_HOME/bin/evoal-training.sh" . training.mll

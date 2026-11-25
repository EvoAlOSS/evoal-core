#!/usr/bin/env bash

# Generates the training data output/left.csv, output/middle.csv and output/right.csv and the
# test data output/test.csv from the Forrester function with noise that grows with x:0, see
# README.md.

set -e

export EVOAL_HOME=${EVOAL_HOME:-$( cd -- "$(dirname "$0")/../../" >/dev/null 2>&1 ; pwd -P )}
export EVOAL_LOGGING=${EVOAL_LOGGING:-INFO}

mkdir -p output
"${SHELL:-bash}" "$EVOAL_HOME/bin/evoal-pipeline.sh" . training-data.generator

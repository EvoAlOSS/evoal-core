#!/usr/bin/env bash

# Generates 1024 rows of a normal x and a log-normal y, coupled by a Gaussian copula, into
# output/points.csv and estimates their Pearson correlation into output/correlations.csv.

set -e

export EVOAL_HOME=${EVOAL_HOME:-$( cd -- "$(dirname "$0")/../../" >/dev/null 2>&1 ; pwd -P )}
export EVOAL_LOGGING=${EVOAL_LOGGING:-INFO}

mkdir -p output
"${SHELL:-bash}" "$EVOAL_HOME/bin/evoal-pipeline.sh" . points.generator

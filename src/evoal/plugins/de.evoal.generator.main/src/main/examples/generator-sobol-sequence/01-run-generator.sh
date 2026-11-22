#!/usr/bin/env bash

# Generates 256 points of a randomly shifted Sobol' sequence on [0, 1)² into output/sobol.csv
# and 256 independent uniform points into output/uniform.csv for comparison.

set -e

export EVOAL_HOME=${EVOAL_HOME:-$( cd -- "$(dirname "$0")/../../" >/dev/null 2>&1 ; pwd -P )}
export EVOAL_LOGGING=${EVOAL_LOGGING:-INFO}

mkdir -p output
"${SHELL:-bash}" "$EVOAL_HOME/bin/evoal-pipeline.sh" . points.generator

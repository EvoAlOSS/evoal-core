#!/usr/bin/env bash

# Converts data.arff to JSON, CSV and ARFF; the extension of the output file selects the format.
# The missing values stay missing.

set -e

export EVOAL_HOME=${EVOAL_HOME:-$( cd -- "$(dirname "$0")/../../" >/dev/null 2>&1 ; pwd -P )}
export EVOAL_LOGGING=${EVOAL_LOGGING:-INFO}

mkdir -p output
for FORMAT in json csv arff; do
  "${SHELL:-bash}" "$EVOAL_HOME/bin/evoal-convert-arff.sh" . data.arff measurements.ddl "output/measurements.$FORMAT"
done

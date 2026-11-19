#!/usr/bin/env bash

# Runs the evolutionary algorithm 3 times for every target of data.json, see README.md.

set -e

export EVOAL_HOME=${EVOAL_HOME:-$( cd -- "$(dirname "$0")/../../" >/dev/null 2>&1 ; pwd -P )}
export EVOAL_LOGGING=${EVOAL_LOGGING:-INFO}

"${SHELL:-bash}" "$EVOAL_HOME/bin/evoal-evaluate-search.sh" . search.ol output 3 -Boptimisation:target-points-file=data.json

#!/usr/bin/env bash

# Searches an expression for the data of y = 5 x^3 + 42 with genetic programming, see README.md.

set -e

export EVOAL_HOME=${EVOAL_HOME:-$( cd -- "$(dirname "$0")/../../" >/dev/null 2>&1 ; pwd -P )}
export EVOAL_LOGGING=${EVOAL_LOGGING:-INFO}

"${SHELL:-bash}" "$EVOAL_HOME/bin/evoal-search.sh" . gp-example.ol output

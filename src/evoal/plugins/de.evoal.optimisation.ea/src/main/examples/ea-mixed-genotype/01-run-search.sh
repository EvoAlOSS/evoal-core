#!/usr/bin/env bash

# Runs an evolutionary algorithm with a mixed genotype, see README.md.

set -e

export EVOAL_HOME=${EVOAL_HOME:-$( cd -- "$(dirname "$0")/../../" >/dev/null 2>&1 ; pwd -P )}
export EVOAL_LOGGING=${EVOAL_LOGGING:-INFO}

"${SHELL:-bash}" "$EVOAL_HOME/bin/evoal-search.sh" . search.ol output

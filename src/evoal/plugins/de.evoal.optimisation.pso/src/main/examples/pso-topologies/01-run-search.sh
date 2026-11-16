#!/usr/bin/env bash

# Runs the same particle swarm with a global and with a ring topology, see README.md.

set -e

export EVOAL_HOME=${EVOAL_HOME:-$( cd -- "$(dirname "$0")/../../" >/dev/null 2>&1 ; pwd -P )}
export EVOAL_LOGGING=${EVOAL_LOGGING:-INFO}

"${SHELL:-bash}" "$EVOAL_HOME/bin/evoal-search.sh" . search-global.ol output
"${SHELL:-bash}" "$EVOAL_HOME/bin/evoal-search.sh" . search-ring.ol output

#!/usr/bin/env bash

# Runs an evolutionary algorithm on a noisy Rastrigin function, once with a single evaluation
# per candidate and once with re-evaluation, see README.md.

set -e

export EVOAL_HOME=${EVOAL_HOME:-$( cd -- "$(dirname "$0")/../../" >/dev/null 2>&1 ; pwd -P )}
export EVOAL_LOGGING=${EVOAL_LOGGING:-INFO}

"${SHELL:-bash}" "$EVOAL_HOME/bin/evoal-search.sh" . single-evaluation.ol output
"${SHELL:-bash}" "$EVOAL_HOME/bin/evoal-search.sh" . re-evaluation.ol output

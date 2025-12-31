#!/usr/bin/env bash
set -e

export EVOAL_HOME=$( cd -- "$(dirname $0)/../../" >/dev/null 2>&1 ; pwd -P )

$SHELL $EVOAL_HOME/bin/evoal-search.sh . gp-example.ol output
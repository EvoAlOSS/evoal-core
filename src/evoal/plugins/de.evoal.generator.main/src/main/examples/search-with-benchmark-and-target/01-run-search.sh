#!/bin/sh

export EVOAL_HOME=$( cd -- "$(dirname $0)/../../" >/dev/null 2>&1 ; pwd -P )

$SHELL $EVOAL_HOME/bin/evoal-evaluate-search.sh . search.ol output 3 -Boptimisation:target-points-file=data.json

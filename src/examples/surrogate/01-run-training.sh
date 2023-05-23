#!/bin/sh

export EVOAL_HOME=$( cd -- "$(dirname $0)/../../" >/dev/null 2>&1 ; pwd -P )

$SHELL $EVOAL_HOME/bin/run-training.sh . training.mll

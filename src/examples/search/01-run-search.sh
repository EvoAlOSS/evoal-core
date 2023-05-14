#!/bin/sh

EVOAL_HOME=$( cd -- "$(dirname $0)/../../" >/dev/null 2>&1 ; pwd -P )

sh $EVOAL_HOME/bin/run-search.sh . search.ol output

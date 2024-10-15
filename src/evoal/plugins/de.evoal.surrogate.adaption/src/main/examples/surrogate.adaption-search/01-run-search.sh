#!/bin/sh

export EVOAL_HOME=$( cd -- "$(dirname $0)/../../" >/dev/null 2>&1 ; pwd -P )

$SHELL $EVOAL_HOME/bin/evoal-search.sh . search.ol output -Bsurrogate:configuration-file=training.mll -Bcore:optimisation-configuration-file=search.ol -Bsurrogate:pre-trained=surrogate.pson -Bsurrogate:training-data=data.json

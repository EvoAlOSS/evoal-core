#!/bin/bash

if [ "$#" -ne 5 ]; then
    echo "Usage: $0 <execution-folder> <mll-file> <pre-trained.pson> <training-points.json>"
    exit 1
fi

EVOALPATH="$( cd -- "$(dirname "$0")" >/dev/null 2>&1 ; pwd -P )"

cd $1

PLUGIN_PATHS=`ls -d "${EVOALPATH}/plugins"/* | tr '\n' ':'`

set -x
java -Dorg.jboss.logging.provider=slf4j\
     --module-path "${EVOALPATH}/modules/:$PLUGIN_PATHS" \
     --add-modules ALL-MODULE-PATH \
     --add-opens java.base/java.lang=guice \
     --add-exports io.jenetics.base/io.jenetics.internal.collection=de.evoal.core \
     --add-exports io.jenetics.base/io.jenetics.internal.util=de.evoal.core \
     -m de.evoal.core/de.evoal.core.main.Evoal \
     -Bcore:main=heuristic-search \
     "-Bcore:ea-configuration-file=$2" \
     "-Bcore:evaluation-output-folder=$3" \
     "-Bsurrogate:pre-trained=$4" \
     "-Bsurrogate:training-data=$5"

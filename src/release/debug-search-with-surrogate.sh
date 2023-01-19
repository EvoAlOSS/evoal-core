#!/bin/bash

if [ "$#" -ne 7 ]; then
    echo "Usage: $0 <execution-folder> <ea-file> <mll-file> <pre-trained.pson> <training-points.json> <output> <constraint-folder>"
    exit 1
fi

EVOALPATH="$( cd -- "$(dirname "$0")" >/dev/null 2>&1 ; pwd -P )"

cd $1

PLUGIN_PATHS=`ls -d "${EVOALPATH}/plugins"/* | tr '\n' ':'`

set -x
java -Dorg.jboss.logging.provider=slf4j\
     -agentlib:jdwp=transport=dt_socket,server=y,suspend=y,address=1044\
     --module-path "${EVOALPATH}/modules/:$PLUGIN_PATHS" \
     --add-modules ALL-MODULE-PATH \
     --add-opens java.base/java.lang=guice \
     --add-exports io.jenetics.base/io.jenetics.internal.math=de.evoal.core \
     --add-exports io.jenetics.base/io.jenetics.internal.collection=de.evoal.core \
     --add-exports io.jenetics.base/io.jenetics.internal.util=de.evoal.core \
     -m de.evoal.core/de.evoal.core.main.Evoal \
     -Bcore:main=heuristic-search \
     "-Bcore:ea-configuration-file=$2" \
     "-Bsurrogate:configuration-file=$3" \
     "-Bsurrogate:pre-trained=$4" \
     "-Bsurrogate:training-data=$5"\
     "-Bcore:evaluation-output-folder=$6" \
     "-Bcore:constraint-folder=$7"

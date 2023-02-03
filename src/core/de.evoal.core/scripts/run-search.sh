#!/bin/bash

source $( cd -- "$(dirname $0)/" >/dev/null 2>&1 ; pwd -P)/paths.env

if [ "$#" -ne 3 ]; then
    echo "Usage: $0 <execution-folder> <eal-file> <output-folder>"
    exit 1
fi

cd $1

set -x
java -Dorg.jboss.logging.provider=slf4j\
     --module-path "${EVOALPATH}/modules/:$PLUGIN_PATHS" \
     --add-modules ALL-MODULE-PATH \
     --add-opens java.base/java.lang=guice \
     --add-exports io.jenetics.base/io.jenetics.internal.math=de.evoal.core \
     --add-exports io.jenetics.base/io.jenetics.internal.collection=de.evoal.core \
     --add-exports io.jenetics.base/io.jenetics.internal.util=de.evoal.core \
     -m de.evoal.core/de.evoal.core.main.Evoal \
     "-Bcore:main=heuristic-search" \
     "-Bcore:ea-configuration-file=$2" \
     "-Bcore:evaluation-output-folder=$3"

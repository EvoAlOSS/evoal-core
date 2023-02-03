#!/bin/bash

source $( cd -- "$(dirname $0)/" >/dev/null 2>&1 ; pwd -P)/paths.env

if [ "$#" -ne 4 ]; then
    echo "Usage: $0 <execution-folder> <input.arff> <specification.ddl> <output.json>"
    exit 1
fi

cd $1

set -x
java -Dorg.jboss.logging.provider=slf4j\
     --module-path "${EVOALPATH}/modules/:$PLUGIN_PATHS" \
     --add-modules ALL-MODULE-PATH \
     --add-opens java.base/java.lang=guice \
     -m de.evoal.core/de.evoal.core.main.Evoal \
     -Bcore:main=convert-arff-to-json \
     -Barff:input=$2 \
     -Barff:ddl-specification=$3 \
     -Barff:output=$4

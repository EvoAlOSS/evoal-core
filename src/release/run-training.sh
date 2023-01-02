#!/bin/bash

if [ "$#" -ne 2 ]; then
    echo "Usage: $0 <execution-folder> <mll-file>"
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
     -m de.evoal.core/de.evoal.core.main.Evoal \
     -Bcore:main=surrogate-training \
     "-Bsurrogate:configuration-file=$2"

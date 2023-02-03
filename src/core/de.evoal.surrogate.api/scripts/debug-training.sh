#!/bin/bash

source paths.env

if [ "$#" -ne 2 ]; then
    echo "Usage: $0 <execution-folder> <mll-file>"
    exit 1
fi

cd $1

set -x
java -Dorg.jboss.logging.provider=slf4j\
     -agentlib:jdwp=transport=dt_socket,server=y,suspend=y,address=1044\
     --module-path "${EVOALPATH}/modules/:$PLUGIN_PATHS" \
     --add-modules ALL-MODULE-PATH \
     --add-opens java.base/java.lang=guice \
     -m de.evoal.core/de.evoal.core.main.Evoal \
     -Bcore:main=surrogate-training \
     "-Bsurrogate:configuration-file=$2"

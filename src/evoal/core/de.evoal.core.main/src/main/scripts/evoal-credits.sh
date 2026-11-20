#!/usr/bin/env bash

# Lists the libraries of the installation with licence, purpose and citation:
#   evoal-credits.sh                          the list
#   evoal-credits.sh bibtex                   the citations as BibTeX
#   evoal-credits.sh release-files <folder>   writes licenses/, NOTICE and sbom.json of a release

if [ -z ${EVOAL_HOME+x} ]; then
  EVOAL_HOME=$( cd -- "$(dirname $0)/../" >/dev/null 2>&1 ; pwd -P )
fi

source $EVOAL_HOME/bin/paths.env

declare -a LOCAL_JVM_ARGUMENTS=()

if [ ${EVOAL_VM+x} ]; then
  LOCAL_JVM_ARGUMENTS+=( "${EVOAL_VM[@]}" )
fi

java ${LOCAL_JVM_ARGUMENTS[@]} \
     ${EVOAL_JVM_ARGUMENTS[@]} \
     --credits "$@"

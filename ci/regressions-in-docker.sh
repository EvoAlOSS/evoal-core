#!/bin/sh

###############################################################################
# Builds EvoAl and runs the regressions in the EvoAl CI image, so that the
#   results are the same as in the merge request pipeline (the references are
#   compared exactly, and floating-point results may differ between platforms).
#
# Usage: ci/regressions-in-docker.sh [--update]
#   --update  rewrites the references (expected/) instead of comparing.
#
# Requirements:
#   - a running Docker daemon, logged in to the GitLab registry
#     (docker login gitlab.informatik.uni-bremen.de:5005)
#   - the languages installed in the local Maven repository
#     (mvn -f src/languages/pom.xml flatten:flatten install)
###############################################################################

set -e -u

IMAGE=${EVOAL_IMAGE:-gitlab.informatik.uni-bremen.de:5005/evoal/source/evoal-core/evoal/maven-with-bash:3.9.15}
MAVEN_REPOSITORY=${MAVEN_REPOSITORY:-$HOME/.m2/repository}
ROOT=$( cd -- "$(dirname "$0")/.." >/dev/null 2>&1 ; pwd -P )

UPDATE=false
if [ "${1:-}" = "--update" ]; then
    UPDATE=true
fi

docker run --rm \
    --platform linux/amd64 \
    --volume "$ROOT:/work" \
    --volume "$MAVEN_REPOSITORY:/root/.m2/repository" \
    --workdir /work \
    "$IMAGE" \
    mvn --batch-mode -f src/evoal/pom.xml -Pregressions -Devoal.regressions.update="$UPDATE" verify

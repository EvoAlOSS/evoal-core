#!/bin/sh

###############################################################################
# Builds EvoAl and runs the regressions in the EvoAl CI image, i.e., in the
#   same environment as the merge request pipeline, e.g., to reproduce a
#   pipeline failure. The results do not depend on the platform, so
#   `mvn -f src/evoal/pom.xml -Pregressions verify` gives the same results
#   locally.
#
# Usage: ci/regressions-in-docker.sh [--update] [--examples]
#   --update    rewrites the references (expected/) instead of comparing.
#   --examples  also runs the examples that have references (as the nightly
#               pipeline does).
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
EXAMPLES=false
for ARGUMENT in "$@"; do
    case "$ARGUMENT" in
        --update)   UPDATE=true ;;
        --examples) EXAMPLES=true ;;
        *)          echo "Unknown argument: $ARGUMENT" >&2; exit 1 ;;
    esac
done

docker run --rm \
    --platform linux/amd64 \
    --volume "$ROOT:/work" \
    --volume "$MAVEN_REPOSITORY:/root/.m2/repository" \
    --workdir /work \
    "$IMAGE" \
    mvn --batch-mode -f src/evoal/pom.xml -Pregressions -Devoal.regressions.update="$UPDATE" -Devoal.regressions.examples="$EXAMPLES" verify

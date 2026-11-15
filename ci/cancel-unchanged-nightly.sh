#!/bin/sh

###############################################################################
# Cancels the current (nightly) pipeline if the last successful nightly
#   regression run already tested the same commit, i.e., nothing was merged
#   since then.
#
# The last successful run is the newest successful scheduled pipeline of the
#   branch that contains a successful job 'evoal:nightly-regressions'. Other
#   scheduled pipelines (e.g., maintenance) are ignored.
#
# Requires: curl, jq and the variable CI_API_TOKEN (scope api).
###############################################################################

set -e -u

NIGHTLY_JOB="evoal:nightly-regressions"
API="$CI_API_V4_URL/projects/$CI_PROJECT_ID"

api() {
    curl --silent --show-error --fail --header "PRIVATE-TOKEN: $CI_API_TOKEN" "$@"
}

PIPELINES=$(api "$API/pipelines?ref=$CI_COMMIT_REF_NAME&source=schedule&status=success&order_by=id&sort=desc&per_page=20" \
            | jq -r '.[] | "\(.id) \(.sha)"')

LAST_TESTED_SHA=""
echo "$PIPELINES" | while read -r PIPELINE SHA; do
    if [ -z "$PIPELINE" ]; then
        continue
    fi

    NIGHTLY_SUCCEEDED=$(api "$API/pipelines/$PIPELINE/jobs?scope[]=success&per_page=100" \
                        | jq --arg name "$NIGHTLY_JOB" 'any(.[]; .name == $name)')

    if [ "$NIGHTLY_SUCCEEDED" = "true" ]; then
        echo "$SHA" > last-tested-sha
        break
    fi
done

if [ -e last-tested-sha ]; then
    LAST_TESTED_SHA=$(cat last-tested-sha)
fi

if [ "$LAST_TESTED_SHA" = "$CI_COMMIT_SHA" ]; then
    echo "Nothing was merged since the last nightly regression run ($LAST_TESTED_SHA), cancelling the pipeline."
    api --request POST "$API/pipelines/$CI_PIPELINE_ID/cancel" > /dev/null
else
    echo "Last nightly regression run tested '${LAST_TESTED_SHA:-none}', now testing $CI_COMMIT_SHA."
fi

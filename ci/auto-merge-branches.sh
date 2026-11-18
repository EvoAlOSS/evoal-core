#!/usr/bin/env bash

###############################################################################
# Merges <source> into <target> through a merge request that GitLab merges
#   when its pipeline succeeds (the schedule with AUTOMATIC_MERGE == "true"
#   merges develop into release every night; the merge request pipeline runs
#   evoal:release-check).
#
#   1. Does nothing if <target> already contains <source>.
#   2. Reuses the open merge request <source> -> <target> or opens one.
#   3. Uses the merge request pipeline of the current commit or starts one. A
#      failed pipeline for this commit is not retried: the job fails.
#   4. Waits until GitLab has checked whether the merge request can be merged
#      and turns on auto merge for exactly this commit.
#
# Every API call is checked; the script fails with the response of GitLab.
#
# Requires: bash, curl, jq and PROJECT_ACCESS_TOKEN (scope api, role
#   Maintainer: it starts pipelines for and merges into protected branches).
#
# Usage: ci/auto-merge-branches.sh <source> <target>
###############################################################################

set -euo pipefail

SOURCE=${1:?Usage: $0 <source> <target>}
TARGET=${2:?Usage: $0 <source> <target>}
API="$CI_API_V4_URL/projects/$CI_PROJECT_ID"

# seconds to wait for GitLab (merge request pipeline, mergeability check)
WAIT_SECONDS=${WAIT_SECONDS:-300}

# api <method> <path> [json]: prints the response, fails on HTTP errors
api() {
  local method=$1 path=$2 data=${3:-}
  local response status body
  local arguments=(--silent --show-error --request "$method"
                   --header "PRIVATE-TOKEN: $PROJECT_ACCESS_TOKEN"
                   --header "Content-Type: application/json"
                   --write-out '\n%{http_code}')
  if [ -n "$data" ]; then
    arguments+=(--data "$data")
  fi

  response=$(curl "${arguments[@]}" "$API$path")
  status=${response##*$'\n'}
  body=${response%$'\n'*}

  if [ "$status" -ge 300 ]; then
    echo "!!! $method $path failed with HTTP $status: $body" >&2
    exit 1
  fi

  printf '%s' "$body"
}

echo "Merging '$SOURCE' into '$TARGET'"

##
## 1. Anything to merge?
##
COMMITS=$(api GET "/repository/compare?from=$TARGET&to=$SOURCE&straight=true" | jq '.commits | length')
if [ "$COMMITS" -eq 0 ]; then
  echo "  '$TARGET' already contains '$SOURCE'. Nothing to do."
  exit 0
fi
echo "  '$SOURCE' has $COMMITS commits that '$TARGET' does not have."

##
## 2. Merge request
##
IID=$(api GET "/merge_requests?state=opened&source_branch=$SOURCE&target_branch=$TARGET" | jq -r '.[0].iid // empty')
if [ -n "$IID" ]; then
  echo "  Reusing the open merge request !$IID."
else
  BODY=$(jq -n --arg source "$SOURCE" --arg target "$TARGET" \
              --arg title "Auto: Merge '$SOURCE' into '$TARGET'" '{
      source_branch: $source,
      target_branch: $target,
      title: $title,
      remove_source_branch: false,
      squash: false,
      assignee_id: 24
    }')
  IID=$(api POST "/merge_requests" "$BODY" | jq -r '.iid')
  echo "  Opened the merge request !$IID."
fi

##
## 3. Merge request pipeline of the current commit
##
SHA=""
for (( WAITED = 0; WAITED < WAIT_SECONDS; WAITED += 5 )); do
  SHA=$(api GET "/merge_requests/$IID" | jq -r '.sha // empty')
  [ -n "$SHA" ] && break
  sleep 5
done
if [ -z "$SHA" ]; then
  echo "!!! The merge request !$IID has no commit after $WAIT_SECONDS s." >&2
  exit 1
fi
echo "  Commit: $SHA"

# GitLab usually starts the pipeline itself when the merge request is opened
PIPELINE=""
for (( WAITED = 0; WAITED < 60; WAITED += 10 )); do
  PIPELINE=$(api GET "/merge_requests/$IID/pipelines" \
             | jq -c --arg sha "$SHA" '[.[] | select(.sha == $sha and .source == "merge_request_event")] | .[0] // empty')
  [ -n "$PIPELINE" ] && break
  sleep 10
done

if [ -z "$PIPELINE" ]; then
  PIPELINE=$(api POST "/merge_requests/$IID/pipelines" | jq -c '{id, status}')
  echo "  Started the merge request pipeline $(jq -r .id <<< "$PIPELINE")."
else
  echo "  Merge request pipeline $(jq -r .id <<< "$PIPELINE") ($(jq -r .status <<< "$PIPELINE"))."
fi

case $(jq -r .status <<< "$PIPELINE") in
  failed|canceled)
    echo "!!! The merge request pipeline of $SHA $(jq -r .status <<< "$PIPELINE"); not merging." >&2
    exit 1
    ;;
esac

##
## 4. Auto merge
##
STATUS=""
for (( WAITED = 0; WAITED < WAIT_SECONDS; WAITED += 5 )); do
  STATUS=$(api GET "/merge_requests/$IID" | jq -r '.detailed_merge_status')
  case $STATUS in
    checking|unchecked|preparing|approvals_syncing) sleep 5 ;;
    *) break ;;
  esac
done
echo "  Merge status: $STATUS"

BODY=$(jq -n --arg sha "$SHA" --arg source "$SOURCE" --arg target "$TARGET" '{
    sha: $sha,
    auto_merge: true,
    merge_when_pipeline_succeeds: true,
    should_remove_source_branch: false,
    squash: false,
    merge_commit_message: "Automatically merged \($source) to \($target)"
  }')
RESULT=$(api PUT "/merge_requests/$IID/merge" "$BODY" | jq -c '{state, merge_when_pipeline_succeeds}')

if [ "$(jq -r .state <<< "$RESULT")" = "merged" ]; then
  echo "  The merge request !$IID is merged."
elif [ "$(jq -r .merge_when_pipeline_succeeds <<< "$RESULT")" = "true" ]; then
  echo "  The merge request !$IID is merged when its pipeline succeeds."
else
  echo "!!! GitLab did not turn on auto merge for !$IID: $RESULT" >&2
  exit 1
fi

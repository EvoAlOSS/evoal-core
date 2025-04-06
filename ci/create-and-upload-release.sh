#!/bin/bash
set -e -x -u
PLATFORM=$1
ARCHIVE=evoal-${CI_COMMIT_TAG}-${PLATFORM}.zip

if [[ "$PLATFORM" != "linux-x86_64" ]]; then
  find evoal -name "*linux-x86_64*jar" | xargs rm
fi 

if [[ "$PLATFORM" != "macosx-arm64" ]]; then
  find evoal -name "*macosx-arm64*jar" | xargs rm
fi 

if [[ "$PLATFORM" != "macosx-x86_64" ]]; then
  find evoal -name "*macosx-x86_64*jar" | xargs rm
fi 

if [[ "$PLATFORM" != "windows-x86_64" ]]; then
  find evoal -name "*windows-x86_64*jar" | xargs rm
fi 

mv evoal evoal-$PLATFORM
jar Mcf $ARCHIVE evoal-$PLATFORM
curl --location --header "JOB-TOKEN: ${CI_JOB_TOKEN}" --upload-file $ARCHIVE "${CI_API_V4_URL}/projects/${CI_PROJECT_ID}/packages/generic/evoal-release/${CI_COMMIT_TAG}/$ARCHIVE"
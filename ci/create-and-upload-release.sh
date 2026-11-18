#!/usr/bin/env bash

###############################################################################
# Creates the package of EvoAl for one platform from the assembled release
#   (folder evoal, see create-release.sh): copies the release, removes the
#   native libraries of the other platforms and zips the copy as
#   evoal-<version>-<platform>.zip, where <version> is the tag or the ref.
#   For a tag the package is uploaded to the generic package registry
#   (evoal-release/<tag>), where the release links it.
#
# Usage: ci/create-and-upload-release.sh <platform>
###############################################################################

set -euo pipefail

PLATFORMS="linux-x86_64 macosx-arm64 macosx-x86_64 windows-x86_64"
PLATFORM=${1:?Usage: $0 <platform>}

if [[ " $PLATFORMS " != *" $PLATFORM "* ]]; then
  echo "Unknown platform '$PLATFORM', expected one of: $PLATFORMS" >&2
  exit 1
fi

VERSION=${CI_COMMIT_TAG:-${CI_COMMIT_REF_SLUG:-local}}
FOLDER=evoal-$PLATFORM
ARCHIVE=evoal-$VERSION-$PLATFORM.zip

rm -rf "$FOLDER" "$ARCHIVE"
cp -r evoal "$FOLDER"

for OTHER in $PLATFORMS; do
  if [ "$OTHER" != "$PLATFORM" ]; then
    find "$FOLDER" -name "*${OTHER}*.jar" -delete
  fi
done

jar Mcf "$ARCHIVE" "$FOLDER"
rm -rf "$FOLDER"
echo "Created $ARCHIVE"

if [ -n "${CI_COMMIT_TAG:-}" ]; then
  curl --fail --silent --show-error --location \
       --header "JOB-TOKEN: ${CI_JOB_TOKEN}" \
       --upload-file "$ARCHIVE" \
       "${CI_API_V4_URL}/projects/${CI_PROJECT_ID}/packages/generic/evoal-release/${CI_COMMIT_TAG}/$ARCHIVE"
  echo "Uploaded $ARCHIVE"
fi

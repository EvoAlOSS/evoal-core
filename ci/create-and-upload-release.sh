#!/usr/bin/env bash

###############################################################################
# Creates the package of EvoAl for one platform from the assembled release
#   (folder evoal, see create-release.sh): copies the release, removes the
#   native libraries of the other platforms and zips the copy as
#   evoal-<version>-<platform>.zip. The package is uploaded to the generic
#   package registry
#   - for a tag as evoal-release/<tag>/evoal-<tag>-<platform>.zip, which the
#     release links,
#   - for the branch release (updated by the nightly auto merge) as
#     evoal-nightly/nightly/evoal-nightly-<platform>.zip; every night replaces
#     it (the cleanup policy of the registry keeps one file per name).
#   Other refs only create the package.
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

PACKAGE=""
if [ -n "${CI_COMMIT_TAG:-}" ]; then
  VERSION=$CI_COMMIT_TAG
  PACKAGE=evoal-release
elif [ "${CI_COMMIT_BRANCH:-}" = "release" ]; then
  VERSION=nightly
  PACKAGE=evoal-nightly
else
  VERSION=${CI_COMMIT_REF_SLUG:-local}
fi

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

if [ -n "$PACKAGE" ]; then
  curl --fail --silent --show-error --location \
       --header "JOB-TOKEN: ${CI_JOB_TOKEN}" \
       --upload-file "$ARCHIVE" \
       "${CI_API_V4_URL}/projects/${CI_PROJECT_ID}/packages/generic/$PACKAGE/$VERSION/$ARCHIVE"
  echo "Uploaded $ARCHIVE to $PACKAGE/$VERSION"
  rm "$ARCHIVE"
fi

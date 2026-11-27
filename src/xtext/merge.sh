#!/usr/bin/env bash
#
# Builds EvoAl's merged org.eclipse.xtext jar from the official org.eclipse.xtext and
#   org.eclipse.xtext.util jars of a version (see README.md):
#
#   merge.sh <official version> [--compare <jar>]
#
# The result, version <official version> + 1 in the last digit, is written to target/ next to
# this script: org.eclipse.xtext-<version>.jar and org.eclipse.xtext-<version>.pom. With
# --compare, the entries of the result are compared with those of the given jar.

set -euo pipefail

CENTRAL="https://repo.maven.apache.org/maven2/org/eclipse/xtext"

# The date of every entry, so that a second run gives the same jar.
ENTRY_DATE="2000-01-01T00:00:02Z"

usage() {
    echo "Usage: $0 <official version, e.g. 2.41.0> [--compare <jar>]" >&2
    exit 1
}

[ "$#" -eq 1 ] || [ "$#" -eq 3 ] || usage
OFFICIAL="$1"
COMPARE=""
if [ "$#" -eq 3 ]; then
    [ "$2" = "--compare" ] || usage
    COMPARE="$(cd "$(dirname "$3")" && pwd -P)/$(basename "$3")"
    [ -f "$COMPARE" ] || { echo "No such jar: $3" >&2; exit 1; }
fi

[[ "$OFFICIAL" =~ ^([0-9]+)\.([0-9]+)\.([0-9]+)$ ]] || usage
MERGED="${BASH_REMATCH[1]}.${BASH_REMATCH[2]}.$(( BASH_REMATCH[3] + 1 ))"

HERE="$(cd "$(dirname "$0")" && pwd -P)"
TARGET="$HERE/target"
WORK="$TARGET/work-$OFFICIAL"
rm -rf "$WORK"
mkdir -p "$WORK/content"

sha1() {
    if command -v sha1sum > /dev/null; then
        sha1sum "$1" | cut -d ' ' -f 1
    else
        shasum -a 1 "$1" | cut -d ' ' -f 1
    fi
}

# Downloads an artifact of the official version from Maven Central and checks its SHA-1.
download() {
    local artifact="$1" extension="$2"
    local file="$WORK/$artifact-$OFFICIAL.$extension"
    local url="$CENTRAL/$artifact/$OFFICIAL/$artifact-$OFFICIAL.$extension"

    curl --fail --silent --show-error --location --output "$file" "$url"
    local expected
    expected="$(curl --fail --silent --show-error --location "$url.sha1" | cut -c 1-40)"
    if [ "$(sha1 "$file")" != "$expected" ]; then
        echo "SHA-1 of $url does not match Maven Central's checksum." >&2
        exit 1
    fi
}

download org.eclipse.xtext jar
download org.eclipse.xtext.util jar

# The util jar without its META-INF (manifest, signatures, Maven files), then the xtext jar,
#   whose files win on a conflict (plugin.properties).
unzip -q "$WORK/org.eclipse.xtext.util-$OFFICIAL.jar" -x 'META-INF/*' -d "$WORK/content"
unzip -q -o "$WORK/org.eclipse.xtext-$OFFICIAL.jar" -d "$WORK/content"

# The signatures do not fit the merged content, and the manifest is replaced.
rm -f "$WORK/content/META-INF/MANIFEST.MF" "$WORK/content/META-INF/"*.SF \
      "$WORK/content/META-INF/"*.RSA "$WORK/content/META-INF/"*.DSA "$WORK/content/META-INF/"*.EC

# The pom: the version of the merged jar, the Xtext dependencies keep the official version.
MAVEN="$WORK/content/META-INF/maven/org.eclipse.xtext/org.eclipse.xtext"
sed -e "s|^\(	<packaging>eclipse-plugin</packaging>\)\$|\1\\
	<version>$MERGED</version>|" \
    -e 's|\${project.version}|${project.parent.version}|g' \
    "$MAVEN/pom.xml" > "$WORK/pom.xml"
grep -q "<version>$MERGED</version>" "$WORK/pom.xml" || { echo "The pom has no <packaging> line for the version." >&2; exit 1; }
cp "$WORK/pom.xml" "$MAVEN/pom.xml"
sed -e "s|^version=$OFFICIAL\$|version=$MERGED|" "$MAVEN/pom.properties" > "$WORK/pom.properties"
cp "$WORK/pom.properties" "$MAVEN/pom.properties"

# Java derives no module name from a renamed file; state it.
printf 'Manifest-Version: 1.0\nAutomatic-Module-Name: org.eclipse.xtext\n' > "$WORK/MANIFEST.MF"

JAR="$TARGET/org.eclipse.xtext-$MERGED.jar"
rm -f "$JAR"
(cd "$WORK/content" && find . -type f | sed 's|^\./||' | LC_ALL=C sort > "$WORK/files.txt")
(cd "$WORK/content" && jar --create --file "$JAR" --manifest "$WORK/MANIFEST.MF" --date="$ENTRY_DATE" "@$WORK/files.txt")
cp "$WORK/pom.xml" "$TARGET/org.eclipse.xtext-$MERGED.pom"

echo "Built $JAR"
echo "  and $TARGET/org.eclipse.xtext-$MERGED.pom"

if [ -n "$COMPARE" ]; then
    rm -rf "$WORK/compare"
    mkdir -p "$WORK/compare/built" "$WORK/compare/given"
    unzip -q "$JAR" -d "$WORK/compare/built"
    unzip -q "$COMPARE" -d "$WORK/compare/given"

    echo "Differences to $COMPARE (none if empty):"
    (cd "$WORK/compare" && diff -rq built given) || true
fi

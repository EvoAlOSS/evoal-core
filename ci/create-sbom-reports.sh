#!/bin/bash
###############################################################################
# Turns the SBOMs of the shipped modules into reports for GitLab's dependency
#   scanning (#298).
#
# Every shipped module (core.main and the plugins) writes the CycloneDX SBOM of
#   its runtime libraries to target/classes/META-INF/evoal/sbom.cdx.json (#312).
#   For each of them, this script writes <module>/gl-sbom-evoal.cdx.json, a copy
#   with the properties GitLab needs to scan it (GitLab CycloneDX property
#   taxonomy): the schema version and the module's pom.xml as input file, so
#   that findings point to the module that ships the library. A plugin's SBOM
#   lists only the libraries it adds, those of core.main are provided; together
#   the SBOMs cover the release without duplicates. SBOMs of POM modules (e.g.
#   the parent core.plugin) are skipped, as nothing of them is shipped.
#
# The build marks the libraries that a module does not ship (e.g. transitive
#   dependencies of a plugin) with the scope 'excluded' (credits check, #298).
#   The copy leaves them out, and their entries in the dependency graph too, so
#   that GitLab only reports libraries of the release.
#
# Usage: ci/create-sbom-reports.sh [<source folder>]   (default: src/evoal)
#   Paths are relative to the current folder, which is the repository root in
#   CI. Fails if no SBOM is found, so a broken build path does not go unnoticed.
###############################################################################

set -euo pipefail

SOURCE_FOLDER="${1:-src/evoal}"
SBOM_SUFFIX="/target/classes/META-INF/evoal/sbom.cdx.json"
REPORT_NAME="gl-sbom-evoal.cdx.json"

COUNT=0
while IFS= read -r SBOM; do
    MODULE="${SBOM%"$SBOM_SUFFIX"}"
    if jq -e '.metadata.component.purl | test("[?&]type=pom")' "$SBOM" > /dev/null; then
        echo "$MODULE: skipped (POM module)"
        continue
    fi
    jq --arg pom "$MODULE/pom.xml" '
        .metadata.properties = [(.metadata.properties // [])[] | select(.name | startswith("gitlab:") | not)]
          + [ {name: "gitlab:meta:schema_version", value: "1"},
              {name: "gitlab:dependency_scanning:input_file:path", value: $pom},
              {name: "gitlab:dependency_scanning:package_manager:name", value: "maven"} ]
        | .components = [(.components // [])[] | select(.scope != "excluded")]
        | ([.components[]."bom-ref"] + [.metadata.component."bom-ref"]) as $kept
        | if has("dependencies") then
            .dependencies = [ .dependencies[]
                              | select(.ref | IN($kept[]))
                              | .dependsOn = [(.dependsOn // [])[] | select(IN($kept[]))] ]
          else . end
    ' "$SBOM" > "$MODULE/$REPORT_NAME"
    SHIPPED=$(jq '.components | length' "$MODULE/$REPORT_NAME")
    EXCLUDED=$(jq '[(.components // [])[] | select(.scope == "excluded")] | length' "$SBOM")
    echo "$MODULE/$REPORT_NAME: $SHIPPED shipped components, $EXCLUDED excluded"
    COUNT=$((COUNT + 1))
done < <(find "$SOURCE_FOLDER" -path "*$SBOM_SUFFIX" | sort)

if [ "$COUNT" -eq 0 ]; then
    echo "No SBOM found below $SOURCE_FOLDER (*$SBOM_SUFFIX)."
    exit 1
fi
echo "$COUNT SBOM reports written."

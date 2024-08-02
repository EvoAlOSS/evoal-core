#!/bin/bash

echo "Changing version number to ${CI_COMMIT_TAG}"

pushd src/languages
for FILE in `find . -name MANIFEST.MF`; do
    sed -e "s;Bundle-Version: [0-9.]*qualifier;Bundle-Version: ${CI_COMMIT_TAG};g" $FILE > tmp
    mv tmp $FILE
done

for FILE in `find . -name feature.xml`; do
    sed -e "s/[0-9]\{4\}\.[0-9]\{1,2\}\.[0-9]\{1,2\}\.qualifier/${CI_COMMIT_TAG}/g" $FILE > tmp
    mv tmp $FILE
done

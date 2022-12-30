#!/bin/bash

set -e -x

RELEASE_PLUGINS="generator.main surrogate.api surrogate.simple surrogate.svr"


mkdir -p evoal/plugins

cp src/languages/de.evoal.languages.releng.site/target/de.evoal.languages.releng.site-*.zip "evoal/eclipse-update-site.zip"
cp -r src/core/de.evoal.core/target/core evoal/modules

for NAME in $RELEASE_PLUGINS; do
    echo "Copying plugin $NAME"
    cp -r src/core/de.evoal.$NAME/target/$NAME evoal/plugins/$NAME
done

# remove multiple definitions of javax stuff
rm evoal/modules/javax.inject*
rm evoal/modules/javax.annotation-api-*
rm evoal/modules/jsr305-*
# remove multiple definietions of CDI stuff
rm evoal/modules/jboss-annotations-api*
rm evoal/modules/jboss-interceptors-api*
rm evoal/modules/jboss-el-api*

# Now, we do have to do a small hack to fix an Xtext/jigsaw issue. Xtext is not yet modularized
#  and multiple 'modules' have classes in the same package which is not supported by jigsaw.
#  Therefore, we merge the modules and create a single module.
cd evoal
mkdir xtext-merge
pushd xtext-merge
  unzip -o ../modules/org.eclipse.xtext.util-*.jar
  unzip -o ../modules/org.eclipse.xtext-*.jar
  rm ../modules/org.eclipse.xtext.util-*.jar
  rm ../modules/org.eclipse.xtext-*.jar
  jar Mcf ../modules/org.eclipse.xtext.jar *
popd
rm -rf xtext-merge

# let's copy the scripts to the correct location
cp ../src/scripts/*sh .

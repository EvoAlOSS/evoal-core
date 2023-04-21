#!/bin/bash





RELEASE_PLUGINS="generator.main surrogate.api surrogate.simple surrogate.svr approximative.density core.arff core.ea"


rm -rf evoal
mkdir -p evoal/plugins

cp src/languages/de.evoal.languages.releng.site/target/de.evoal.languages.releng.site-*.zip "evoal/eclipse-update-site.zip"
cp -r src/core/de.evoal.core.main/target/core.main evoal/modules

for NAME in $RELEASE_PLUGINS; do
    echo "Copying plugin $NAME"
    cp -r src/core/de.evoal.$NAME/target/$NAME evoal/plugins/$NAME
done

# remove multiple definitions of javax stuff
rm evoal/modules/javax.inject*
rm evoal/modules/javax.annotation-api-*
rm evoal/modules/jsr305-*

# remove multiple definitions of CDI stuff
rm evoal/modules/jboss-annotations-api*
rm evoal/modules/jboss-interceptors-api*
rm evoal/modules/jboss-el-api*

cd evoal

# remove xtext util since we merged it to xtext
rm modules/org.eclipse.xtext.util-*

# let's copy the scripts to the correct location
mkdir bin

cp -r ../src/core/de.evoal.core.main/scripts/* "bin"
for NAME in $RELEASE_PLUGINS; do
    echo "Copying scripts of plugin $NAME"

    if [ -e ../src/core/de.evoal.$NAME/scripts ]; then
      cp -r ../src/core/de.evoal.$NAME/scripts/* bin
    fi
done

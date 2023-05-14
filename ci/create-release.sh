#!/bin/bash

RELEASE_PLUGINS="generator.main surrogate.api surrogate.simple surrogate.svr approximative.density core.arff core.ea"


EVOAL_HOME=evoal
PROJECT_HOME=src/core/

# clear old build
rm -rf "$EVOAL_HOME"
mkdir -p "$EVOAL_HOME/bin"
mkdir -p "$EVOAL_HOME/definitions"
mkdir -p "$EVOAL_HOME/plugins"









# create evoal release
echo "Copying Eclipse Update Site."
cp src/languages/de.evoal.languages.releng.site/target/de.evoal.languages.releng.site-*.zip "evoal/eclipse-update-site.zip"

echo "Copying core.main"
cp -r "$PROJECT_HOME/de.evoal.core.main/target/core.main" "$EVOAL_HOME/modules"

for NAME in $RELEASE_PLUGINS; do
    echo "Copying plugin $NAME"
    cp -r "$PROJECT_HOME/de.evoal.$NAME/target/$NAME" "$EVOAL_HOME/plugins/$NAME"
done

# link scripts
for NAME in core.main $RELEASE_PLUGINS; do
    echo "Copying scripts of plugin $NAME"

    if [ -e "$PROJECT_HOME/de.evoal.$NAME/scripts" ]; then
      for SCRIPT in $PROJECT_HOME/de.evoal.$NAME/scripts/*; do
        cp $SCRIPT "$EVOAL_HOME/bin/`basename $SCRIPT`"
      done
    fi
done

# copy definitions
for NAME in core.main $RELEASE_PLUGINS; do
    echo "Copying definitions of plugin $NAME"

    PLUGIN_BASE="$PROJECT_HOME/de.evoal.$NAME/src/main/resources"
    if [ -e $PLUGIN_BASE ]; then
      DEFINITION_FILES=`cd $PLUGIN_BASE && find . -name "*dl"`

      for DF in $DEFINITION_FILES; do
        mkdir -p $EVOAL_HOME/definitions/`dirname "$DF"`
        cp $PLUGIN_BASE/$DF "$EVOAL_HOME/definitions/$DF"
      done
    fi
done

# copy examples
cp -r $PROJECT_HOME/../examples $EVOAL_HOME/examples
#!/bin/bash

RELEASE_PLUGINS="core.arff generator.main surrogate.api surrogate.simple surrogate.svr approximative.density core.ea"

JAVA_HOME=/Library/Java/JavaVirtualMachines/openjdk17/Contents/Home
EVOAL_HOME=$( cd -- "$(dirname $0)/../../../" >/dev/null 2>&1 ; pwd -P )/evoal
PROJECT_HOME=$( cd -- "$(dirname $0)/../" >/dev/null 2>&1 ; pwd -P )

# clear old build
rm -rf "$EVOAL_HOME"
mkdir -p "$EVOAL_HOME/bin"
mkdir -p "$EVOAL_HOME/definitions"
mkdir -p "$EVOAL_HOME/plugins"


# build new release
pushd "$PROJECT_HOME/de.evoal.releng.parent"
set -e
#mvn package -DskipTests
set +e
popd

# create evoal release



echo "Linking core.main"
ln -sf "$PROJECT_HOME/de.evoal.core.main/target/core.main" "$EVOAL_HOME/modules"

for NAME in $RELEASE_PLUGINS; do
  echo "Linking plugin $NAME"
  ln -sf "$PROJECT_HOME/de.evoal.$NAME/target/$NAME" "$EVOAL_HOME/plugins/$NAME"
done

# link scripts
for NAME in core.main $RELEASE_PLUGINS; do
    echo "Linking scripts of plugin $NAME"

    if [ -e "$PROJECT_HOME/de.evoal.$NAME/scripts" ]; then
      for SCRIPT in $PROJECT_HOME/de.evoal.$NAME/scripts/*; do
        ln -sf $SCRIPT "$EVOAL_HOME/bin/`basename $SCRIPT`"
      done
    fi
done

# link definitions
for NAME in core.main $RELEASE_PLUGINS; do
    echo "Linking definitions of plugin $NAME"

    PLUGIN_BASE="$PROJECT_HOME/de.evoal.$NAME/src/main/resources"
    if [ -e $PLUGIN_BASE ]; then
      DEFINITION_FILES=`cd $PLUGIN_BASE && find . -name "*dl"`

      for DF in $DEFINITION_FILES; do
        mkdir -p $EVOAL_HOME/definitions/`dirname "$DF"`
        ln -sf $PLUGIN_BASE/$DF "$EVOAL_HOME/definitions/$DF"
      done
    fi
done

# link examples
ln -sf $PROJECT_HOME/../examples $EVOAL_HOME/examples

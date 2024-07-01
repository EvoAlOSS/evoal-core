#!/bin/bash

RELEASE_PLUGINS="core.arff generator.main optimisation.api optimisation.ea optimisation.pso approximative.density surrogate.api surrogate.simple surrogate.smile" 
EVOAL_HOME=evoal
PROJECT_HOME=src/evoal/

# clear old build
rm -rf "$EVOAL_HOME"
mkdir -p "$EVOAL_HOME/bin"
mkdir -p "$EVOAL_HOME/definitions"
mkdir -p "$EVOAL_HOME/examples"
mkdir -p "$EVOAL_HOME/plugins"

###############################################################################
###############################################################################
### create evoal release
echo "Copying binary files ..."
echo "    ... Eclipse Update Site"
cp src/languages/de.evoal.languages.releng.site/target/de.evoal.languages.releng.site-*.zip "$EVOAL_HOME/eclipse-update-site.zip"

echo "    ... core.main"
cp -r "$PROJECT_HOME/core/de.evoal.core.main/target/core.main" "$EVOAL_HOME/modules"

for NAME in $RELEASE_PLUGINS; do
  echo "    ... plugin $NAME"
  cp -r "$PROJECT_HOME/plugins/de.evoal.$NAME/target/$NAME" "$EVOAL_HOME/plugins/$NAME"
done

###############################################################################
###############################################################################
### copy options
echo "Copying options ..."
if [ -e "$PROJECT_HOME/core/de.evoal.core.main/src/main/options" ]; then
  echo "    ... core.main"

  for FILE in $PROJECT_HOME/core/de.evoal.core.main/src/main/options/*; do
    cp $FILE "$EVOAL_HOME/modules"
  done
fi

for NAME in $RELEASE_PLUGINS; do
    if [ -e "$PROJECT_HOME/plugins/de.evoal.$NAME/src/main/options" ]; then
      echo "    ... plugin $NAME"

      for FILE in $PROJECT_HOME/plugins/de.evoal.$NAME/src/main/options/*; do
        cp $FILE "$EVOAL_HOME/plugins/$NAME"
      done
    fi
done

###############################################################################
###############################################################################
### copy scripts
echo "Copying scripts ..."
if [ -e "$PROJECT_HOME/core/de.evoal.core.main/src/main/scripts" ]; then
  echo "    ... core.main"
  for SCRIPT in $PROJECT_HOME/core/de.evoal.core.main/src/main/scripts/*; do
    cp $SCRIPT "$EVOAL_HOME/bin/`basename $SCRIPT`"
  done
fi

for NAME in $RELEASE_PLUGINS; do
    if [ -e "$PROJECT_HOME/plugins/de.evoal.$NAME/src/main/scripts" ]; then
      echo "    ... plugin $NAME"

      for SCRIPT in $PROJECT_HOME/plugins/de.evoal.$NAME/src/main/scripts/*; do
        cp $SCRIPT "$EVOAL_HOME/bin/`basename $SCRIPT`"
      done
    fi
done

###############################################################################
###############################################################################
### copy definitions
echo "Copying definitions ..."
PLUGIN_BASE="$PROJECT_HOME/core/de.evoal.core.main/src/main/resources"
if [ -e $PLUGIN_BASE ]; then
  DEFINITION_FILES=`cd $PLUGIN_BASE && find . -name "*dl"`
  
  echo "    ... core.main"
  for DF in $DEFINITION_FILES; do
    mkdir -p $EVOAL_HOME/definitions/`dirname "$DF"`
    cp $PLUGIN_BASE/$DF "$EVOAL_HOME/definitions/$DF"
  done
fi

for NAME in $RELEASE_PLUGINS; do
    PLUGIN_BASE="$PROJECT_HOME/plugins/de.evoal.$NAME/src/main/resources"
    if [ -e $PLUGIN_BASE ]; then
      echo "    ... plugin $NAME"

      DEFINITION_FILES=`cd $PLUGIN_BASE && find . -name "*dl"`

      for DF in $DEFINITION_FILES; do
        mkdir -p $EVOAL_HOME/definitions/`dirname "$DF"`
        cp $PLUGIN_BASE/$DF "$EVOAL_HOME/definitions/$DF"
      done
    fi
done

###############################################################################
###############################################################################
### copy examples
echo "Copying examples ..."
if [ -e "$PROJECT_HOME/core/de.evoal.core.main/src/main/examples" ]; then
  echo "     ... core.main"

  for SCRIPT in $PROJECT_HOME/core/de.evoal.core.main/src/main/examples/*; do
    cp -r $SCRIPT "$EVOAL_HOME/examples/`basename $SCRIPT`"
  done
fi

for NAME in $RELEASE_PLUGINS; do
    if [ -e "$PROJECT_HOME/plugins/de.evoal.$NAME/src/main/examples" ]; then
     echo "     ... plugin $NAME"

      for SCRIPT in $PROJECT_HOME/plugins/de.evoal.$NAME/src/main/examples/*; do
        cp -r $SCRIPT "$EVOAL_HOME/examples/`basename $SCRIPT`"
      done
    fi
done


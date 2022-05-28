#! /bin/bash -x

CURRENT_DIR=$(dirname "$0")
WORKING_DIR="$(dirname "$CURRENT_DIR")"
CLASSPATH="$WORKING_DIR/lib/*:$WORKING_DIR/bin"
OUTPUT_DIR="$WORKING_DIR/bin"
SRC_DIR="$WORKING_DIR/src"

# get javac
if [ -z "$JAVACCMD" ] ; then
  if [ -n "$JAVA_HOME"  ] ; then
    JAVACCMD="$JAVA_HOME/bin/javac"
  else
    JAVACCMD="$(command -v javac)"
  fi
fi

# create bin folder
if [ ! -d "$OUTPUT_D
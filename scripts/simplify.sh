#!/bin/sh -x

CURRENT_DIR=$(dirname "$0")
WORKING_DIR="$(dirname "$CURRENT_DIR")"
CLASSPATH="$WORKING_DIR/lib/*:$WORKING_DIR/bin"

# get java
if [ -z "$JAVACMD" ] ; then
  if [ -n "$JAVA_HOME"  ] ; then
    JAVACMD="$JAVA_HOME/bin/java
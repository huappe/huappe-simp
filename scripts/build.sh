#! /bin/bash -x

CURRENT_DIR=$(dirname "$0")
WORKING_DIR="$(dirname "$CURRENT_DIR")"
CLASSPATH="$WORKING_DIR/lib/*:$WORKING_DIR/bin"
OUTPUT_DIR="$W
#!/bin/bash

# Exit on errors
set -e

# Define variables
SRC_DIR="src"
OUT_DIR="out"
MANIFEST_FILE="MANIFEST.MF"
JAR_FILE="MessageController.jar"
MAIN_CLASS_SAME_PROCESS="org.sameprocess.Main"
MAIN_CLASS_LAUNCHER="org.separatepid.Launcher"

# Step 1: Clean up previous builds
echo "Cleaning up..."
rm -rf $OUT_DIR $JAR_FILE
mkdir -p $OUT_DIR

# Step 2: Compile the project using Maven
echo "Compiling the project with Maven..."
mvn clean compile
if [ $? -ne 0 ]; then
  echo "Maven compilation failed. Exiting..."
  exit 1
fi

# Step 3: Compile manually for Java source files
echo "Compiling Java files..."
javac -d $OUT_DIR $SRC_DIR/main/java/org/sameprocess/*.java $SRC_DIR/main/java/org/separatepid/*.java
if [ $? -ne 0 ]; then
  echo "Java compilation failed. Exiting..."
  exit 1
fi

# Step 4: Create MANIFEST.MF file for the "Same Process" approach
echo "Creating manifest for Same Process..."
echo "Main-Class: $MAIN_CLASS_SAME_PROCESS" > $MANIFEST_FILE
echo "" >> $MANIFEST_FILE # Ensure newline at the end

# Step 5: Package the JAR file for "Same Process"
echo "Packaging JAR for Same Process..."
jar cfm $JAR_FILE $MANIFEST_FILE -C $OUT_DIR .
if [ $? -ne 0 ]; then
  echo "Failed to create JAR file. Exiting..."
  exit 1
fi

# Step 6: Run the "Same Process" approach
echo "Running Same Process approach..."
java -jar $JAR_FILE
if [ $? -ne 0 ]; then
  echo "Failed to run Same Process. Exiting..."
  exit 1
fi

# Step 7: Update MANIFEST.MF for the "Separate PID" approach
echo "Creating manifest for Separate PID..."
echo "Main-Class: $MAIN_CLASS_LAUNCHER" > $MANIFEST_FILE
echo "" >> $MANIFEST_FILE # Ensure newline at the end

# Step 8: Package the JAR file for "Separate PID"
echo "Packaging JAR for Separate PID..."
jar cfm $JAR_FILE $MANIFEST_FILE -C $OUT_DIR .
if [ $? -ne 0 ]; then
  echo "Failed to create JAR file for Separate PID. Exiting..."
  exit 1
fi

# Step 9: Run the "Separate PID" approach
echo "Running Separate PID approach..."
java -jar $JAR_FILE
if [ $? -ne 0 ]; then
  echo "Failed to run Separate PID. Exiting..."
  exit 1
fi

echo "All approaches completed successfully!"

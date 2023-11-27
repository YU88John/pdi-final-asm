#!/bin/bash

# Compile and run the first Java file
echo "Data input system is initialized..."
javac ValidityChecks.java
javac UserInputHandler.java
javac CSVWriter.java

echo "Data input program is starting..."
echo " "
javac DataEntry.java
java DataEntry
echo " "
echo "Data input program is successful and data is written as csv file."
echo " "

echo "**********************************************************************"

echo " "
echo "Data analysis system is initialized..."
javac Nation.java
javac DataAnalysis.java
javac DisplayAnalysis.java
javac GroupAnalysis.java
echo "Data analysis program is starting ..."
echo " "
javac DataRetrieval.java
java DataRetrieval
echo "Data analysis and filtering by continent is successful."
echo " "

echo "*************************************************************************"

echo " "

# Ask the user if they want to clear data
# shellcheck disable=SC2162
read -p "Do you want to clear data? (Y/N): " choice

# Check the user's choice
if [[ "$choice" == "Y" || "$choice" == "y" ]]; then
    # If the user chooses "Y", compile and run RemoveCsv.java
    echo "Removing the data..."
    javac RemoveCsv.java
    java RemoveCsv
    echo "All .csv files are successfully deleted."
else
    echo "Data not cleared."
fi
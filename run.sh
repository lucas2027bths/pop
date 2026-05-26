#!/bin/bash
POPULATIONSTATEMENTS=~/pop/populate.sql
SPLITDIR=~/pop/splitFiles
cd src
javac *.java
touch $POPULATIONSTATEMENTS
java Main > $POPULATIONSTATEMENTS
#splitting not needed anymore
mysql --max_allowed_packet=100M -h 127.0.0.1 -u "$USER" -p -D "${USER}_db" < $POPULATIONSTATEMENTS


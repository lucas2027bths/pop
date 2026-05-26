#!/bin/bash
POPULATIONSTATEMENTS=~/pop/populate.sql
SPLITDIR=~/pop/splitFiles
cd src
javac *.java
touch $POPULATIONSTATEMENTS
java Main > $POPULATIONSTATEMENTS

if [ -d "$SPLITDIR" ]; then
        rm $SPLITDIR/*
        rmdir $SPLITDIR
fi

mkdir $SPLITDIR

split -l 8000 -d $POPULATIONSTATEMENTS $SPLITDIR/chunk_

read -s -p "What is your sql password? " PASSWORD
echo ""

for file in $(ls "$SPLITDIR" | sort -V); do
    mysql --max_allowed_packet=100M -h 127.0.0.1 -u "$USER" -p"$PASSWORD" -D "${USER}_db" < "$SPLITDIR/$file"
done

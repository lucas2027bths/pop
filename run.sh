#!/bin/bash
cd src
javac *.java
touch ~/pop/populate.sql
java tester > ~/pop/populate.sql
mysql -h 127.0.0.1 -u "$USER" -p < ~/pop/populate.sql
#!/bin/bash
cd src
javac *.java
touch ~/pop/populate.sql
java Main > ~/pop/populate.sql
mysql  --max_allowed_packet=100M -h 127.0.0.1 -u "$USER" -p < ~/pop/populate.sql
#!/bin/bash
cd src
javac *.java
touch ../pop.sql
java tester > ../pop.sql

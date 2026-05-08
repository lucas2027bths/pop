#!/bin/bash
cd src
javac *.java
java tester < ../pop.sql

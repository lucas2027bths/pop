
#!/bin/bash
cd src
javac *.java
touch ~/pop/populate.sql
java Main > ~/pop/populate.sql
mkdir ~/pop/split
split -l 1000 -d ~/pop/populate.sql ~/pop/split/piece_
ls | sort -V | while read file; do mysql --max_allowed_packet=100M -h 127.0.0.1 -u "$USER" -p"20795756" < "$file"; done

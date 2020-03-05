#!/usr/bin/env bash

#NAME="Chris Kay"
#echo "Hello $NAME!"

#PART 5
echo "Part 5 Execution: Check part5.txt"
: '
no parameters
3 working parameters
3 invalid parameters
'


IFS=" "

cat src/subset/600.txt | while read line; do
 set $line 
 #echo $1
 make run2 "params=$1" >> LSBSTfind600.txt
done

unset ifs

#!/usr/bin/env bash

#NAME="Chris Kay"
#echo "Hello $NAME!"

#PART 1
echo "Part 1 Execution: Check part1.txt"

: '
no parameters
3 working parameters
3 invalid parameters
'
(make run &&
make run params="2 29 00" &&
make run params="4 17 10" &&
make run params="8 10 22" &&
make run params="3 5 7" &&
make run params="4 7" &&
make run params="invalid text input") > part1.txt


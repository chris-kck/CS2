#!/usr/bin/env bash

#NAME="Chris Kay"
#echo "Hello $NAME!"

#PART 1
echo "Part 1 & 2 Execution: Check part1_2.txt"
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
make run params="invalid text input") > part1_2.txt

#PART 3
echo "Part 3 & 4 Execution: Check part3_4.txt"

: '
no parameters
3 working parameters
3 invalid parameters
'
(make run &&
make run2 params="2 29 00" &&
make run2 params="4 17 10" &&
make run2 params="8 10 22" &&
make run2 params="3 5 7" &&
make run2 params="4 7" &&
make run2 params="invalid text input") > part3_4.txt



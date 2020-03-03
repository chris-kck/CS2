#!/usr/bin/env bash

#NAME="Chris Kay"
#echo "Hello $NAME!"

# Part 1
echo "Part 1 Execution: Check part1.txt"
#3 working parameters
make run params="2 29 00"
make run params="4 17 10"
make run params="8 10 22"

#3 invalid parameters
make run params="3 5 7"
make run params="4 7"
make run params="my name is"

#no parameters
make run
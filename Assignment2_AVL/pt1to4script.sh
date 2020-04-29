#!/usr/bin/env bash

#NAME="Chris Kay"
#echo "Hello $NAME!"

#PART 1&2
echo "Part 1 & 2 Execution: Check bst_part1_2.txt"
: '
BST
no parameters
3 working parameters
3 invalid parameters
'
(make bst &&
make bst params="2 29 00" &&
make bst params="4 17 10" &&
make bst params="8 10 22" &&
make bst params="3 5 7" &&
make bst params="4 7" &&
make bst params="invalid text input") > bst_part1_2.txt

#PART 3&4
echo "Part 3 & 4 Execution: Check avl_part3_4.txt"

: '
AVL
no parameters
3 working parameters
3 invalid parameters
'
(make avl &&
make avl params="2 29 00" &&
make avl params="4 17 10" &&
make avl params="8 10 22" &&
make avl params="3 5 7" &&
make avl params="4 7" &&
make avl params="invalid text input") > avl_part3_4.txt



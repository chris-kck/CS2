#!/usr/bin/env bash

#NAME="Chris Kay"
#echo "Hello $NAME!"

#PART 5
echo "Part 5 Execution: Check ./insertCount"
: '
Searches for key in each of the subset files & writes findCount
'


IFS=" "
cat src/subset/300.txt | while read line; do
 set $line
 #echo $1
 make avl "params=$1" 2>> insertCount/BSTfind300.txt
done


cat src/subset/600.txt | while read line; do
 set $line 
 #echo $1
 make avl "params=$1" 2>> insertCount/BSTfind600.txt
done

cat src/subset/900.txt | while read line; do
 set $line
 #echo $1
 make avl "params=$1" 2>> insertCount/BSTfind900.txt
done

cat src/subset/1200.txt | while read line; do
 set $line
 #echo $1
 make avl "params=$1" 2>> insertCount/BSTfind1200.txt
done

cat src/subset/1500.txt | while read line; do
 set $line
 #echo $1
 make avl "params=$1" 2>> insertCount/BSTfind1500.txt
done

cat src/subset/1800.txt | while read line; do
 set $line
 #echo $1
 make avl "params=$1" 2>> insertCount/BSTfind1800.txt
done

cat src/subset/2100.txt | while read line; do
 set $line
 #echo $1
 make avl "params=$1" 2>> insertCount/BSTfind2100.txt
done

cat src/subset/2400.txt | while read line; do
 set $line
 #echo $1
 make avl "params=$1" 2>> insertCount/BSTfind2400.txt
done

cat src/subset/2700.txt | while read line; do
 set $line
 #echo $1
 make avl "params=$1" 2>> insertCount/BSTfind2700.txt
done

cat src/subset/2900.txt | while read line; do
 set $line
 #echo $1
 make avl "params=$1" 2>> insertCount/BSTfind2900.txt
done

cat src/subset/300.txt | while read line; do
 set $line
 #echo $1
 make avl "params=$1" 2>> insertCount/AVLfind300.txt
done


cat src/subset/600.txt | while read line; do
 set $line
 #echo $1
 make avl "params=$1" 2>> insertCount/AVLfind600.txt
done

cat src/subset/900.txt | while read line; do
 set $line
 #echo $1
 make avl "params=$1" 2>> insertCount/AVLfind900.txt
done

cat src/subset/1200.txt | while read line; do
 set $line
 #echo $1
 make avl "params=$1" 2>> insertCount/AVLfind1200.txt
done

cat src/subset/1500.txt | while read line; do
 set $line
 #echo $1
 make avl "params=$1" 2>> insertCount/AVLfind1500.txt
done

cat src/subset/1800.txt | while read line; do
 set $line
 #echo $1
 make avl "params=$1" 2>> insertCount/AVLfind1800.txt
done

cat src/subset/2100.txt | while read line; do
 set $line
 #echo $1
 make avl "params=$1" 2>> insertCount/AVLfind2100.txt
done

cat src/subset/2400.txt | while read line; do
 set $line
 #echo $1
 make avl "params=$1" 2>> insertCount/AVLfind2400.txt
done

cat src/subset/2700.txt | while read line; do
 set $line
 #echo $1
 make avl "params=$1" 2>> insertCount/AVLfind2700.txt
done

cat src/subset/2900.txt | while read line; do
 set $line
 #echo $1
 make avl "params=$1" 2>> insertCount/AVLfind2900.txt
done

unset ifs

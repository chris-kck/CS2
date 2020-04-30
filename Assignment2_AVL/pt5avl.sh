#!/usr/bin/env bash

#NAME="Chris Kay"
#echo "Hello $NAME!"

#PART 5
echo "Part 5 Execution: Check ./src/subset"
: '
Searches for key in each of the subset files & writes findCount
'


IFS=" "
cat src/subset/300.txt | while read line; do
 set $line
 #echo $1
 make avl "params=$1" 2>> src/subset/AVLfind300.txt
done


cat src/subset/600.txt | while read line; do
 set $line
 #echo $1
 make avl "params=$1" 2>> src/subset/AVLfind600.txt
done

cat src/subset/900.txt | while read line; do
 set $line
 #echo $1
 make avl "params=$1" 2>> src/subset/AVLfind900.txt
done

cat src/subset/1200.txt | while read line; do
 set $line
 #echo $1
 make avl "params=$1" 2>> src/subset/AVLfind1200.txt
done

cat src/subset/1500.txt | while read line; do
 set $line
 #echo $1
 make avl "params=$1" 2>> src/subset/AVLfind1500.txt
done

cat src/subset/1800.txt | while read line; do
 set $line
 #echo $1
 make avl "params=$1" 2>> src/subset/AVLfind1800.txt
done

cat src/subset/2100.txt | while read line; do
 set $line
 #echo $1
 make avl "params=$1" 2>> src/subset/AVLfind2100.txt
done

cat src/subset/2400.txt | while read line; do
 set $line
 #echo $1
 make avl "params=$1" 2>> src/subset/AVLfind2400.txt
done

cat src/subset/2700.txt | while read line; do
 set $line
 #echo $1
 make avl "params=$1" 2>> src/subset/AVLfind2700.txt
done

cat src/subset/2900.txt | while read line; do
 set $line
 #echo $1
 make avl "params=$1" 2>> src/subset/AVLfind2900.txt
done
unset ifs
0: commit 4eb34b12447a733644b866dbd76d221310625730
1: Author: root <root@li345-229.members.linode.com>
2: Date: Thu Apr 30 08:51:39 2020 +0200
3:
4: Accurate AVL Data
5:
6: commit e5f04f5cff13a3a72596a03b7a74dd7564764eb5
7: Author: Chris Kay <kckateera@gmail.com>
8: Date: Thu Apr 30 07:18:51 2020 +0200
9:
...
163: commit b18002cdd4a324e475a9547e9f467c6e07eb5234
164: Author: Chris Kay <kckateera@gmail.com>
165: Date: Wed Apr 29 15:41:12 2020 +0200
166:
167: Packages renaming
168:
169: commit 3a28d52c531ae8f20325a2d98989c378aa6e03fb
170: Author: Chris Kay <kckateera@gmail.com>
171: Date: Wed Apr 29 15:29:33 2020 +0200
172:


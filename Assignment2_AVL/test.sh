IFS=" "
cat src/subset/300.txt | while read line; do
 set $line
 #echo $1
 make avl "params=$1" 2>> insertCount/BSTfind300.txt
done

unset IFS
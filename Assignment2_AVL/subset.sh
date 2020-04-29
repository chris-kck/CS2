#ONLY RUN ONCE! ELSE YOU WILL APPEND TO EXISTING FILES

#for i in $(seq 1 15);
#do
#cat src/Load_Shedding_All_Areas_Schedule_and_Map.clean.final.txt | while read line;
#echo $line >> 15.txt;
#done
#for i in {1..5}; do
#    cat src/Load_Shedding_All_Areas_Schedule_and_Map.clean.final.txt |
#for i in {1..5}
#do
#for line in $(cat src/Load_Shedding_All_Areas_Schedule_and_Map.clean.final.txt )
#do
#   echo "$line">>kck.txt
#done
#done

LS="src/Load_Shedding_All_Areas_Schedule_and_Map.clean.final.txt"

#sed -n '1,3p' src/Load_Shedding_All_Areas_Schedule_and_Map.clean.final.txt >> 3.txt 
sed -n '1,300p' $LS >> src/subset/300.txt
sed -n '1,600p' $LS >> src/subset/600.txt
sed -n '1,900p' $LS >> src/subset/900.txt
sed -n '1,1200p' $LS >> src/subset/1200.txt
sed -n '1,1500p' $LS >> src/subset/1500.txt
sed -n '1,1800p' $LS >> src/subset/1800.txt
sed -n '1,2100p' $LS >> src/subset/2100.txt
sed -n '1,2400p' $LS >> src/subset/2400.txt
sed -n '1,2700p' $LS >> src/subset/2700.txt
sed -n '1,2900p' $LS >> src/subset/2900.txt

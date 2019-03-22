#!/bin/bash
for loop in {1,2}
do
file="./ReportList.txt"
while IFS= read -r report
do
PID=`pgrep -f "$report"`
if [ -n "$PID" ];
then PIDS=`echo "$PID"`
PID_DIR_ID=`pwdx $PID`
PID_DIR_CUT=`echo $PID_DIR_ID | cut -d ' ' -f 2`
PID_DIR=$PID_DIR_CUT
tail -26 $PID_DIR_CUT/nohup.out | grep refused \
> ./refused_log1.txt
Exst1=`echo "$?"`
tail -26 $PID_DIR_CUT/nohup.out | grep Starting \
> ./refused_log2.txt
Exst2=`echo "$?"`
echo "$Exst1 $Exst2"
if [ $Exst1 -eq 0 ] && [ $Exst2 -ne 0 ];
  then
    `kill -9 $PID`
  fi
fi
done <"$file"
sleep 5
rm refused_log1.txt
rm refused_log2.txt
done

file="./ReportNameList.txt"
while IFS= read -r report

do
ps -ef | grep -v grep | grep "$report" \
> ./log.txt
if [ $? -ne 0 ]; then echo "$report" >> ReportNotRunning.list

fi

done <"$file"

echo "To:lakshmi.narayanan@platform3solutions.com
From:SVC-InfoArchive@medtronic.com
Subject:Report  Engine - Alert Info

Below Reports are not running on "  >> mail.txt
TZ=IST-5:30 date >> mail.txt
echo "
" >> mail.txt

file="./ReportNotRunning.list"
while IFS= read -r line

do

echo "$line" >> mail.txt

done <"$file"

echo "

" >> mail.txt


mailx  -vt  <   ./mail.txt

rm mail.txt

rm ReportNotRunning.list
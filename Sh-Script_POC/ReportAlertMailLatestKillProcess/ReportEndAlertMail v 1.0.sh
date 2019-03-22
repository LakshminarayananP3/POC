#!/bin/bash
file="./ReportList.txt"
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
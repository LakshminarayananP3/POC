# bin/bash
cd /Users/admin/GitHub/backend
for d in *; do
 cd $d
 echo ---------------------------------- $(pwd) ---------------------------------- 
 develop=$(git branch --list develop | wc -l)
 master=$(git branch --list master | wc -l)
 echo develop $develop
 echo master $master
 if [ $develop == 1 ]
 then
 	echo fetching from develop
 	git pull origin develop	
 elif [ $master == 1 ]
 	then
	 	echo fetching from master
	 	git pull origin master
	 else
	 	echo "*** its not a valid git dir ***"
 fi
 cd ..
done
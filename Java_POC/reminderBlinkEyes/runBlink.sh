if ! [[ "$1" =~ ^[0-9]+$ ]]
    then
        echo "\n\tSorry input arguement should be an integers only. \n\n\tTerminating...\n"
        exit 1
fi
 # if [ -z $1 ] # check input is null or not
 # then
 # 	echo "Pass sleeping time in seconds as argument"
 # 	exit 1
 # fi
 while true; do
 	java -jar ./Blink.jar
 	echo "Sleeping for " 1800
 	sleep $1
 done
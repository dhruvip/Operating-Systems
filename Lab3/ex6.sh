#!/bin/bash
#6. Write a shell script, which scans the name of the command and executes it.

if [ "$?" -eq 0 ]
then
	 echo "$#"
	 
	 $1 $2 $3 $4
	 if [ "$?" -eq 0 ]
	 then echo "command executed successfully"
	 else echo "commant exit status 1"
	 fi
fi  

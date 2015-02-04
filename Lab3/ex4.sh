#!/bin/bash

echo "Enter first number:"
read n1
echo "Enter second number:"
read n2
if [ "$n1" -gt "$n2" ]
then 
	echo $n1 "greater than" $n2
elif [ "$n1" -lt "$n2" ]
then 
	echo $n1 "less than" $n2
	
else
	echo $n1 "equal to" $n2
	
fi	

if [ "$?" -eq 0 ]
then

echo "do you want to continue? (y/n)"		
read choice
	if [ "$choice" = "y" ]
	then echo "no....u can't........bye bye"
	else
	     echo "no problemo!!!...bye bye"
	fi
	
fi	

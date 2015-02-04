#!/bin/bash
#5. Write a shell script to accept numbers below 50 and to display the square of each. This should continue as long as the user wishes.

iChoice="y"
while test "$iChoice" = "y"
do
	echo "Enter a number below 50:"
	read n1
	if  test "$n1" -lt 50  ||  "$n1" -eq 50 
	then
		echo "The square is: $(($n1 * $n1))"
	else
		echo "The number should be less than 50!!"
		
	fi
	
	echo "do you want to continue? (y/n)"		
	read iChoice

done	

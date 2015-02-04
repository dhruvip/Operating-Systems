#!/bin/bash

#3. Write a shell script to scan two variables and to display their sum, mul, div, sub and modulo division as per the user choice. (no need to continue, only once is OK)
echo "Please enter two numbers; number 1 should be greater than other!!"
echo "Enter first number:"
read n1
echo "Enter second number:"
read n2
echo "Enter your choice:
      1.Addition
      2.SUbtraction
      3.Division
      4.Multiplication
      5.Modulo"
read iChoice

case $iChoice in
	1) sums=`expr $n1 + $n2`
	echo "sum" $sums;;
	2) sub=`expr $n1 - $n2`
	echo "sub" $sub;;
	3)div=`expr $n1 / $n2`
	if [ "$n1" -gt "$n2" ]
	then
	echo "div" $div
	else
	echo "div The answer is less tha 1; hence answer is 0 or division!!"
	fi;;
	4)mul=`expr $n1 \* $n2`
	echo "mul" $mul;;
	*) echo "INVALID NUMBER!" ;;
	
	5)mod=`expr $n1 % $n2` 
	echo "mod" $mod;;
	
esac	

#!/bin/bash

echo "Please enter two numbers; number 1 should be greater than other!!"
echo "Enter first number:"
read n1
echo "Enter second number:"
read n2


sums=`expr $n1 + $n2`
sub=`expr $n1 - $n2`
div=`expr $n1 / $n2`
mul=`expr $n1 \* $n2`
mod=`expr $n1 % $n2` 
echo "sum" $sums
echo "sub" $sub
echo "mul" $mul
if [ "$n1" -gt "$n2" ]
then
echo "div" $div
else
echo "div The answer is less tha 1; hence answer is 0 or division!!"
fi
echo "mod" $mod

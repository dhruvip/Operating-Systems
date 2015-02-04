#!/bin/bash
# This code will take 2 command line parameters and print its arithmatic operations

sums=`expr $1 + $2`
sub=`expr $1 - $2`
div=`expr $1 / $n2`
mul=`expr $1 \* $2`
mod=`expr $1 % $2`

echo "sum" $sums
echo "sub" $sub
echo "mul" $mul
echo "mod" $mod

echo "div" $div
echo "div The answer is less tha 1; hence answer is 0 or fractional!!"



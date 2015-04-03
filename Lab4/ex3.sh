#3. Write a shell script to generate Fibonacci series.
echo "Generating 100 Fibonacci sequence; Press Cntrl +C to stop"
n1=0
n2=1
for (( i = 1; i <= 100 ; i++ ))
do
echo $n2
n3=$(($n1 + $n2))
n1=$n2
n2=$n3 

done

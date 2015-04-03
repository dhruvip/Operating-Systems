echo "enter a string"
read string
flag=1
len=${#string}
mid=$((len/2))
for (( i=0; i<=$mid ; i++  ))
do
	for (( j=$((mid+1));j<=$len;j++ ))
	do
		if test  ${string:$j:1} = ${string:$i:1} 
		then 
			
			continue
		else
			flag=0
			break	
		fi
	done
	
done

if [ $flag -eq 0 ]
then echo "not a palindrome"
else
echo "palindrome"
fi

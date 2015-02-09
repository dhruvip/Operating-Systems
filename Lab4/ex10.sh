#tr -s ' \t\r\n' '\n'


echo ENter the string
read s

a=( $s )
#echo ${a[0]}
echo Number of words are 
echo ${#a[@]}

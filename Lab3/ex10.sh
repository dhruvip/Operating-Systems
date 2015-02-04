find_index() {
    local str=$1
    local search=$2
    local len="${#var}"
    echo "$len"
    let local n=0
    local retval=1 # here, 1 is failure, 0 success
    for (( i = 0; i <= "$len" ; i++ ))
    do # $str unquoted -> whitespace tokenization!
	    if [ "${str:$i:1}" = "$search" ]
	     then
	     	echo "hi"
		echo $n
		retval=0
		break
	    else
		((n++))
		
	    fi
    done
    return $retval
}

echo "Enter the list:"
read var
echo "Enter the pattern to search:"
read pat

#echo `expr index "$var" "$pat"`
idx= find_index "$var" "$pat"
if [ $? -ne 0 ]
 then
    echo "Not found!"
else
    echo "Found: $idx"
fi

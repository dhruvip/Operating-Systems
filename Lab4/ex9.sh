
echo enter the filename 
read filenm
#y=$( wc -w $1)
#echo "Number of words:"
n=`cut -d' ' -f 1- $filenm | tr ' ' '\n' | wc -l |cut -d' ' -f1 `
#echo $n
echo $(( n - 1))


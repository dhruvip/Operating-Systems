filename1=$1
filename2=$2
flag=0
if test -e $filename1 && test -e $filename2
then 
	echo "yes"
	flag=1
else 
	echo "no"
fi

if [ $flag -eq 1 ]
then
	cat $filename1 >> $filename2
else
	cp $filename1 $filename2
	
	
	
	

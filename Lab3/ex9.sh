#9. Write a shell script that asks the capital of Gujarat and repeats the question until the user gives correct answer.

flag=1
while [ "$flag" -eq 1 ]
do
echo "Enter the Capital of Gujarat"
read Capital
case $Capital in
	gandhinagar) 
	echo "correct!!" 
	flag=0;;
	Gandhinagar) 
	echo "correct!!" 
	flag=0;;
	*) echo "wrong"
	flag=1;;
	
esac
done

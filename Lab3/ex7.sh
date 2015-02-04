#7. Write a shell script which displays January if we enter Jan, Janu, Janua or January.(use of case)
read iChoice

case $iChoice in
	Jan) 
	echo "January" ;;
	Janu) 
	echo "January" ;;
	Janua)
	echo "January";;
	January)
	echo "January" ;;
	*) echo "You are supposed to enter January" ;;
	
	Januar)
	echo "January" ;;
	
esac	

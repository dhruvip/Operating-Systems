echo "enter the pattern to be match"
read pat
y=$( grep -o "$pat" grep.txt )  

if [ "$y" = "$pat" ]

then
echo "ryt"
else
echo "wrong"

fi


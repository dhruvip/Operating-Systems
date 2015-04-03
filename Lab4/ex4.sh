echo "enter the number"
read var
y=$( factor "$var" )  
#echo $y
m="$var: $var"
#echo $m

if [ "$m" = "$y" ];

then
echo "ryt"
else
echo "wrong"

fi


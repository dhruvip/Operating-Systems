echo enter the filename
read fname
echo "Number of lines in the file: "
grep -c '\n' $fname

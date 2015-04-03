echo "Do you wants to revoke the read, write permissions for the group and others for this
particular file ? (y/n):"
read choice

if [ "$choice" = "y" ]
then 

	chmod go-rw $1

fi		

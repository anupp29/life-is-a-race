#!/bin/bash

echo "Enter A Number : "
read num 

if [ $num -gt 10 ] 
then 
	echo "The number is greater than 10 "
elif [ $num -eq 10 ] 
then 
	echo "The number is equal to 10 "
else 
	echo "The number is lesser than 10" 
fi 	


# zeo@zeolite:~/desktop/practical$ chmod +x os_1.sh 
# zeo@zeolite:~/desktop/practical$ ./os_1.sh 
# enter a number : 
# 10
# the number is equal to 10 
# zeo@zeolite:~/desktop/practical$ ./os_1.sh 
# enter a number : 
# 9
# the number is lesser than 10
# zeo@zeolite:~/desktop/practical$ ./os_1.sh 
# enter a number : 
# 12
# the number is greater than 10 
# zeo@zeolite:~/desktop/practical$ 

echo "For Loop counting from to 1 to 5 entered : " 
for i in {1..5}
do
	echo "Number: $i"
done

# zeo@zeolite:~/desktop/practical$ ./os_1.sh 
# For Loop counting from to 1 to 5 entered : 
# Number: 1
# Number: 2
# Number: 3
# Number: 4
# Number: 5

echo "While Loop rev count: "
count=5 	
while [ $count -gt 0 ]
do 
	echo "Countdown : $count"
	count=$((count -1))
done

# zeo@zeolite:~/desktop/practical$ ./os_1.sh 
# While Loop rev count: 
# Countdown : 5
# Countdown : 4
# Countdown : 3
# Countdown : 2
# Countdown : 1


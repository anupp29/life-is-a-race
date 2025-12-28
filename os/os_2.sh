#!/bin/bash

echo " -- Number : "
read num

if [ $num -ge 0 ] ;then 
	fact=1 
	for ((i=1;i<=num;i++)); do 
		fact=$((fact * i))
	done
	echo "Factorial of $num --> $fact"
else
	echo "Enter non -ve integer"
fi


# zeo@ZeoLiTe:~/Desktop/practical$ chmod +x os_2.sh 
# zeo@ZeoLiTe:~/Desktop/practical$ ./os_2.sh 
#  -- Number : 
# 5
# Factorial of 5 --> 120
# zeo@ZeoLiTe:~/Desktop/practical$ ./os_2.sh 
#  -- Number : 
# -2
# Enter non -ve integer
# zeo@ZeoLiTe:~/Desktop/practical$

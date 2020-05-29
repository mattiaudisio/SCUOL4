#!/bin/bash
arabi=( 500 499 100 99 50 49 10 9 5 4 1 )
romani=( C IC L IL X IX V IV I )

function cambia {
i=0		
a=$1
     while [ $a != 0 ]
     do			
	a=$(($a-${arabi[$i]}))
 	if [ $a -lt 0 ]
	then
		a=$(($a+${arabi[$i]}))
		i=$(($i+1))
	else
		echo "${romani[$i]}"
	fi
     done		
}

echo "Inserisci il numero da convertire in numero romano"
read numero
cambia

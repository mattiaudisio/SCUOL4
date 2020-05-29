#!/bin/bash 

vettore=( 0 4 2 1 5 3 )

stampa () {
      
     for ((i=0; i<elem;  i++ ))      
     do       
          echo ${vettore[i]}      
    

     done   
}

ordina (){
    flag=0
    J=$elem    
    while [ $flag -eq 0 ]
    do
       flag=1
       for (( i=0; i< J-1 ; i++ ))  
       do
            if [[ ${vettore[$i]} > ${vettore[$((i+1))]} ]]
            then
                    scambia $i $(( i+1 ))
                    flag=0
            fi    
       done  
       (( J-- ))  
    done
}

scambia (){
    tmp=${vettore[$1]}
    vettore[$1]=${vettore[$2]}
    vettore[$2]=$tmp
}

elem=${#vettore[*]}
stampa 
ordina
echo 
stampa

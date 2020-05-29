#!/bin/bash
#Utilizzando le funzioni, dato un vettore di N elementi:
#- caricare il vettore A
#- stampare il vettore A
#- Ordinare il vettore A
#- stampare il vettore A ordinato
#- creare un secondo vettore B contenente la somma tra il numero [i] ed il successivo nel vettore [i+1]
#- stampare il vettore B
#- ordinare al contrario il vettore B
#- Calcolare e visualizzare la somma degli elementi dispari di A e di B
#- Calcolare e visualizzare il prodotto degli elementi pari di A e B
#- Cercare un elemento (inserito in input dall'utente) nel vettore A


A=( )
B=( )
vettore=( )
#-----------------------------------------------------------------------
carica () {
    i=0
    for (( i=0; i<$N; i++ ))
    do
       echo "Inserisci un numero"
       read num 
       A[$i]=$num
    done
}
#-----------------------------------------------------------------------
stampa () {
    i=0
    for (( i=0; i<$N; i++ ))
    do
      echo ${vettore[i]}
    done
     
}   
#-----------------------------------------------------------------------
ordina () {
    flag=0
    j=$N
    while [ $flag == 0 ]
    do
        flag=1
        for (( i=0; i< j-1; i++ ))
        do
            if [[ ${A[$i]} > ${A[$((i+1))]} ]]
            then
                  scambia $i $(( i+1 ))
                  flag=0               
            fi
        done
        ((j--))    
    done
}
#-----------------------------------------------------------------------
scambia () {
    tmp=${vettore[$1]}
    vettore[$1]=${vettore[$2]}
    vettore[$2]=$tmp
}
#-----------------------------------------------------------------------
vetB () {
    i=0
    for (( i=0; i<$N; i++ ))
    do
        ((B[$i]=A[$i]+A[$(( i+1 ))]))
    done    
}
#-----------------------------------------------------------------------
ordinacontrario () {
    flag=0
    j=$N
    while [ $flag == 0 ]
    do
        flag=1
        for (( i=0; i< j-1; i++ ))
        do
            if [[ ${B[$i]} < ${B[$((i+1))]} ]]
            then
                  scambia $i $(( i+1 ))
                  flag=0               
            fi
        done
        ((j--))    
    done
}
#-----------------------------------------------------------------------
pariodispari () {
   somma=0 
   sommatot=0
   prod=1
   prodtot=1
    if [[ (${vettore[i]}%2) -eq 0 ]]
    then
        ((prod=prod*vettore[$i]))
        ((prodtot=prodtot*prod))
    else
        ((somma=somma+vettore[$i]))
        ((sommatot=sommatot+somma))
    fi      

}    
#-----------------------------------------------------------------------
i=0
echo "Di quanti elementi e' composto il vettore "
read N
carica
echo "" 
echo "${A[i]}"
echo "" 
ordina 
echo "${A[i]}"
vetB
echo "" 
echo "${B[i]}"  
ordinacontrario
for (( i=0; i<$N; i++ ))
do
    vettore[$i]=${A[$i]}
done
pariodispari
for (( i=0; i<$N; i++ ))
do
    vettore[$i]=${B[$i]}
done
pariodispari
echo ""
echo "somma totale      $sommatot"
echo "prodotto totale      $prodtot"

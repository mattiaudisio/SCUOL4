#!/bin/bash
#Creare uno script shell che permetta di:
#
#- Caricare il vettore alunni composto di N elementi (cognomi)  
#
#- Caricare il vettore voti composto di N elementi (votazioni)  
#
#- Stampare entrambi i vettori 
#
#- Ordinare in modo crescente il vettore cognomi (mantenendo per ogni studente il proprio voto)
#
#- Creare un terzo vettore contenente solo i voti sufficienti  
#
#- Dato il cognome di un alunno, visualizzare il relativo voto 
#
#- Contare il numero di voti insufficienti 

studenti=( )
voto=( )
sufficienti=( )
#--------------------------------------------------------------------------------------------------------
carica () {
    for ((i=0 ; i<$N ; i++ ))
    do
        echo "Inserisci il cognome"
        read cognome
        studenti[$i]=$cognome
        echo "Inserisci il voto"
        read voto
        voto[$i]=$voto        
    done
    echo ""
    echo ${studenti[*]}
    echo ${voto[*]}
}
#--------------------------------------------------------------------------------------------------------
sufficienti () {
    votisufficienti=0
    insufficienti=0
    if [[ ${voto[i]} -lt 6 ]]
    then
     votisufficienti=${voto[i]}
     sufficienti[$i]=$votisufficienti 
    else
    ((insufficenti=$insufficienti+1))
    fi
    echo ""
    echo "Ci sono $insufficienti insufficienti"
    echo "sufficienti"
    echo ${sufficenti[*]}
}
#--------------------------------------------------------------------------------------------------------
bubble () {
    j=${#studenti[*]}
    flag=0
    while [ $flag -eq 0 ]   
    do
        flag=1    
        for (( i=0 ; i< (($j -1)) ; i++ ))
        do
            if [[ ${studenti[i]} > ${studenti[i+1]} ]]  
            then
                scambia $i $((i+1))
                flag=0
            fi
        done
        ((J--))
    done
    echo ""
    echo ${studenti[*]}
    echo ${voto[*]}
}
#--------------------------------------------------------------------------------------------------------
scambia () {
    local tmp=${studenti[$1]}
          studenti[$1]=${studenti[$2]}
          studenti[$2]=$tmp
          mpt=${voto[$i]}
          voto[$i]=${voto[$i+1]}
          voto[$((i+1))]=$mpt    
}
#--------------------------------------------------------------------------------------------------------
cerca () {
    echo "Inserisci il cognome dell'alunno per visualizzare il voto "
    read alunno
    votoalunno=0
    h=${#studenti[*]}
    for (( i=0; i<h; i++ ))
    do
        if [[ $alunno == ${studenti[i]} ]]
        then
            votoalunno=${voto[i]}
        fi
    done
    echo "$votoalunno"
}
#--------------------------------------------------------------------------------------------------------
echo "Inserisci il numero di alunni "
read N
carica $N
bubble $N
sufficienti
echo ""
cerca

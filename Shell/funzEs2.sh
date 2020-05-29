#!/bin/bash

mag=0
min=999
pari=0
parmag=0
dispari=0
dismag=0
sommatot=0
paritot=0
disparitot=0
#posso anche scrivere nomefunzione(){   
#
#
#}
function numero {   
    echo "quanti numeri vuoi inserire"
    read numeri
    for ((i=0;i<numeri;i++))
    do
        echo "inserisci un numero"
        read num
        maggiore
        minore
        pari
        dispari
        sommatot
    done
    echo "Il numero più grande e' $mag e il più piccolo e' $min"
    echo "ci sono $pari numeri pari e $dispari numeri dispari"
    echo "sommatotale $sommatot, somma pari $paritot, somma dispari $disparitot"     
}

function maggiore {
    if [ $num -gt $mag ]    
    then
            mag= $num
    fi
}

function minore {
    if [ $num -lt $min ]    
    then
            min= $num
    fi
}

function pari {
    if [ $num / 2 -eq 0 ]    
    then
            pari=$pari+1
    fi
    paritot=(($paritot+$pari))            
}

function dispari {
    if [ $num / 2 -ne 0 ]    
    then
            dispari=$dispari+1
    fi
    disparitot=(($disparitot+$dispari))         
}

function sommatot {
    sommatot=(($sommatot+$num))     
}

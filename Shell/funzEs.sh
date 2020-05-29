#!/bin/bash

function numero {
    echo "Inserisci il primo numero"
    read num1
    echo "Inserisci il secondo numero"
    read num2
}

function uguali {
    if [ $num1 -eq $num2 ]
    then
      echo "i due numeri sono uguali"
    fi
}

function maggiore {
    if [ $num1 -gt $num2 ]
    then
           echo "$num1 è il maggiore"   #posso anche scrivere return$nomevariabile
    else 
           echo "$num2 è il maggiore"      
    fi

}

function minore {
    if [ $num1 -lt $num2 ]
    then
           echo "$num1 è il minore"
    else 
           echo "$num2 è il minore"      
    fi

}

function esci {
    exit
}

numero 
uguali
maggiore
minore
esci

#!/bin/bash

regioni=(Lombardia Lazio Campania Sicilia Veneto "Emilia Romagna" Piemonte Puglia Toscana Calabria Sardegna Liguria Marche Abruzzo "Friuli Venezia Giulia" "Trentino Alto Adige" Umbria Basilicata Molise "Valle d'Aosta")

scambia () {
    temp=${regioni[i]}
    regioni[i]=${regioni[i+1]}
    regioni[i+1]=$temp

    return
}     

stampaArray () {
    for (( i=0; i<${#regioni[*]}; i++ ))
    do
        echo ${regioni[i]}
    done
}



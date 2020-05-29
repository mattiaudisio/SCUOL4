#!/bin/bash 
titoli=("Guida Galattica per autostoppisti" 1984 "La fattoria degli animali" Odissea "Il signore degli anelli" "Il cacciatore di aquiloni" "Don Chisciotte della Mancia" Dracula )
prezzi=(18 12 20 25 19 12 24 16 )
totali=( )

libri () {
    $i
    n=$elenco
    costo=${#prezzi[*]}
    for (( i=0; i<elenco; i++ ))
    do              
        echo ${titoli[i]}
        echo -n "Quante copie hai acquistato "        
        read copie
        prezzo=($copie*${prezzi[i]})
        totali[i]=$prezzo
        echo ${totali[i]}
    done
}


somma () {        
    i=0
    somma=0
    for (( i=0; i<elenco; i++ ))
    do
        sommatot=($somma+${totali[i]})
    done
    read "prezzo totale"
    read $sommatot
}

maggiore () {
    i=0
    mag=0
    for (( i=0; i<elenco; i++ ))
    do
        if [${prezzi[$i]} > $mag ]
        then
            $mag= ${prezzi[i]}
        fi
    done
    echo "prezzo maggiore $mag "
    for (( i=0; i<elenco2; i++ ))
    do
        if [${totali[$i]} > $mag ]
        then
            $mag= ${totali[i]}
        fi
    done
    echo "prezzo maggiore $mag "
}

libro () {
    echo -n "Inserisci il titolo di un libro presente "    
    read ${titoli[i]}    
    echo ${prezzi[i]}
}

elenco=${#titoli[*]}
elenco2=${#prezzi[*]}
echo ${titoli[*]}
echo ${prezzi[*]}
libro
libri
maggiore
somma 

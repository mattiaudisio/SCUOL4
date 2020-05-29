#!/bin/bash 
# se scrivo -x vicino a /bin/bash mi fa un debug per vedere i passaggi 

function saluti {
      echo  "Ciao! " # per visualizzarli di seguito 
 } 

function numero {
    echo -n "inserisci un numero: "
    read num
    echo "hai inserito $num"
}

function scrivi {
        while [ $1 ]
        do
            echo "Ciao $1"
            shift
        done
}

function esci {
    exit
}

saluti
scrivi 'Pippo' 'Pluto' 'Topolino'    
numero
for ((i=0;i<5;i++)) 
do
    saluti 
done
esci
echo "Ho finito"
SSSS

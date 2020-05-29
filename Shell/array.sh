#!/bin/bash

# Definizione di array: 
# nome_array=(VAL0 VAL1 VAL2 VAL3 .... VALN-1)    dove N è la dimensione dell'array

rapaci=(aquila "falco pellegrino" gufo gheppio)

# Per referenziare i singoli valori dell'array si usa la seguente espressione:
#
# ${nome_array[i]}      dove i è l'indice dell'elemento -->   i=0,1,2,...,N-1

echo $rapaci        # aquila

echo ${rapaci[0]}   # aquila

echo ${rapaci[1]}   # falco pellegrino

a=(${rapaci[1]})    # Crea un array "a" con due elementi 

echo ${a[0]}    # falco
echo ${a[1]}    # pellegrino

# Per ottenere il numero degli elementi all'interno di un array devo utilizzare la seguente espressione: 
#
#  ${#nome_array[*]}

echo ${#rapaci[*]}      # restituisce 4

# Per riferirsi a tutti gli elementi dell'array: ${nome_array[*]}

echo ${rapaci[*]}       # aquila falco pellegrino gufo gheppio

echo ${#rapaci[0]}      # restituisce la lunghezza del primo elemento dell'array

echo ${#rapaci}         # Analogo al precedente comando

# Per aggiungere elementi ad un array usiamo la seguente sintassi: nome_array[i]=valore

rapaci[4]=allocco   	# Aggiunge l'elemento "allocco" come quinto elemento dell'array

echo ${rapaci[*]}		

rapaci[10]=poiana       # In bash sono ammessi elementi di un array non contigui

echo ${rapaci[*]}
echo ${#rapaci[*]}
echo ${#rapaci[10]}     # dimensione elemento indice 10 --> 6 
echo ${rapaci[10]}

echo "Contenuto cella indice 6: ${rapaci[6]}"  # NOTA: il contenuto della cella con indice 6 è vuoto!

echo 
echo "#######################"
echo
# Dichiarazione indiretta di un array
mio_array[0]=zero

mio_array[1]=uno

mio_array[5]=cinque     # Ho crato un array con tre elementi

echo ${mio_array[*]}

# Dichiarazione esplicita di un array: declare -a nome_array  
# NOTA: l'opzione -a indica che si tratta di un array
declare -a mio_array2  # Inizialmente vettore vuoto

mio_array2[0]=primo

mio_array2[1]=secondo

echo ${mio_array2[*]}

# Ulteriore metodo per dichiarare gli array
mio_array3=([0]=pippo [1]=paperino [5]=pluto [2]=topolino)

echo ${mio_array3[*]}
echo ${#mio_array3[*]}      # Stampa il numero degli elementi non nullo --> 4

# Cancellare il contenuto delle celle di un array:
#
# unset nome_array[i]  --> Cancella il contenuto della cella specificata dall'indice i
#
# unset nome_array     --> Cancella il contenuto dell'intero array NB: Non cancella la variabile array

echo
echo "################"
echo

echo ${rapaci[*]}
echo
unset rapaci[1]
echo ${rapaci[*]}

unset mio_array3
echo "Contenuto mio_array3: ${mio_array3[*]}"

# L'opzione -a del comando read permette di inserire gli elementi in input 
# dati dall'utente all'interno di un array

read -a new_array
echo ${new_array[*]}


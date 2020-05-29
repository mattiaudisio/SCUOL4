#!/bin/bash

# Algoritmo Bubble Sort:
# ad ogni passaggio successivo lungo l’array che deve essere ordinato,
# vengono confrontati due elementi adiacenti e scambiati se non ordinati.
# Al termine del primo passaggio, l’elemento "più pesante" è sprofondato
# nell’ultima posizione dell’array. Al termine del secondo passaggio, il
# rimanente elemento "più pesante" si trova al penultimo posto. E così via.
# Questo significa che ogni successivo passaggio deve attraversare una
# porzione minore di array. Noterete, quindi, un aumento della velocità
# di visualizzazione dopo ogni passaggio.

# Esercizio: 
# Creare uno script di shell che implementi una versione dell'algoritmo Buble Sort 
# per ordinare l'elenco delle 20 regioni italiane. Si supponga di avere a disposizione un 
# array iniziale contenente i nomi delle regioni in ordine sparso.
# Ad esempio: Lombardia, Lazio, Campania, Sicilia, Veneto, Emilia Romagna, Piemonte, Puglia, 
# Toscana, Calabria, Sardegna, Liguria, Marche, Abruzzo, Friuli Venezia Giulia, 
# Trentino Alto Adige, Umbria, Basilicata, Molise, Valle d'Aosta.
# Per scambiare due elementi dell'array, si faccia uso di una funzione "scambio"

#Svolgimento:

#dichiarazione e inizializzazione vettore 
regioni=(Lombardia Lazio Campania Sicilia Veneto "Emilia Romagna" Piemonte Puglia \
 Toscana Calabria Sardegna Liguria Marche Abruzzo "Friuli Venezia Giulia" "Trentino Alto Adige" \
 Umbria Basilicata Molise "Valle d'Aosta") 

#regioni=(10 9 8 7 6 5 4 3 2 1 0)    # Prova con vettore numerico (CASO ESTREMO)
#regioni=(0 1 2 3 5 4 6 7 8 9 10)

function scambio {
	#scambia due elementi dell'array regioni

	local tmp=${regioni[$1]}	#Variabile temporanea per lo scambio
	regioni[$1]=${regioni[$2]}
	regioni[$2]=$tmp
	
	return
}

clear 	# Pulisce lo schermo prima dell'elaborazione

echo "0: ${regioni[*]}" 		# Elenca l'intero array al passaggio 0
echo

conto=1 	# Numero di passaggi

num_elementi=${#regioni[*]}	# Memorizza il numero di elementi dell'array

flag=0 	# Flag di controllo che indica se ci sono stati eventuali scambi

while [ $flag -eq 0 ]
do
	flag=1
	for (( i = 0 ; i < $num_elementi -1 ; i++ ))
	do
		#if [ ${regioni[$i]} -gt ${regioni[$((i+1))]} ]			# Confronto tra numeri
		if [[ ${regioni[$i]} > ${regioni[$((i+1))]} ]]			# Confronto tra strunghe
		then
			scambio $i $((i+1))
			flag=0					# C'è stato uno scambio
		fi
	done
	((num_elementi--))

	echo "$conto: ${regioni[*]}"	# Visualizza la situazione dell'array al termine di ogni passaggio
	echo
	conto=$((conto+1))

done

exit

# L'utilizzo del costrutto di verifica [[ ... ]] al posto di [ ... ] può evitare molti errori logici negli script.
# Per esempio, gli operatori &&, ||, < e > funzionano correttamente in una verifica [[ ]], mentre potrebbero dare
# degli errori con il costrutto [ ] 

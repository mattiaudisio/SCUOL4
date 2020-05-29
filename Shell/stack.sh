#!/bin/bash
# stack.sh: simulazione di uno stack push-down
# Simile ad uno stack di CPU, lo stack push-down registra i dati
# sequenzialmente, ma li rilascia in ordine inverso, last-in first-out
# (l’ultimo inserito è il primo prelevato).

BP=100 # Base Pointer (puntatore alla base) dello stack (array). Inizio dall’elemento 100.
SP=$BP # Stack Pointer (puntatore allo stack). Viene inizializzato alla "base" (fondo) dello stack.
Dato="" 	# Contenuto di una locazione dello stack. Inizialmente una stringa vuota. 
			# Poi conterrà il dato prelevato ad ogni pop()

declare -a stack # Dichiariamo il nostro array che servirà da stack

# Fate attenzione che lo stack pointer si decrementa ad ogni push, e si incrementa ad ogni pop.

push(){ # Pone un dato sullo stack.
	
	if [ -z "$1" ] # Niente da immettere?
	then
		return
	fi
	
	#let "SP -= 1" # Riposiziona lo stack pointer.
	((SP -= 1))
	
	stack[$SP]=$1
	return
}

pop(){ # Preleva un dato dallo stack.

	Dato= # Svuota la variabile.
	if [ "$SP" -eq "$BP" ] # Lo stack è vuoto?
	then
		return
	fi # Questo evita anche che SP oltrepassi il 100, cioè, impedisce la "fuga" dallo stack.
	
	Dato=${stack[$SP]}
	unset stack[$SP]
	
	#let "SP += 1" # Riposiziona lo stack pointer.
	((SP += 1))
	
	return
}

situazione(){ # Permette di verificare quello che sta avvenendo.
	echo "-------------------------------------"
	echo "RAPPORTO"
	echo "Stack Pointer = $SP"
	echo "Contenuto dello stack: "
	echo ${stack[*]}
	echo "-------------------------------------"
	echo
}

# =======================================================
# Ora un po’ di divertimento.
echo
# Vedete se riuscite a prelevare qualcosa da uno stack vuoto.
pop
situazione

push Roma
push Venezia
push Palermo
situazione	# Palermo Venezia Roma

pop
situazione # Venezia Roma

pop
push Catania
push Messina
push Trapani
situazione # Trapani Messina Catania Roma  

exit

'''Scrivere un programma in python che, creata una lista presenti il seguente menu:
1. Stampa la lista
2. Aggiungi un elemento alla lista
3. Cancella un elemento dalla lista
4. Modifica un elemento dalla lista
5. Ordina la lista
6. Stampa il grafico
9. Esci
sapendo che:
    l'inserimento di un elemento puo' essere di un numero intero (da 1 a 20) o di una parola (menu' 2)
    la cancellazione deve cancellare qualsiasi occorrenza di un numero o di una parola inserita dall'utente
    la modifica di un elemento deve essere fatta per ogni occorrenza di tale elemento inserito dall'utente
    la stampa di un grafico deve inserire in una sola riga tanti "*" di seguito quanto vale il numero intero da rappresentare, oppure, in presenza di una parola, una riga che riporti la parola stessa.
    Es:
    ***************
    *********
    albero
    ***********
    ciao
    ******
Occorre che ci sia sempre qualche messaggio di controllo dei possibili errori.'''


from time import sleep
from os import system

lista = []


def menu():
	sc=int(input("\nScegli:\n\t1. Stampa la lista\n\t2. Aggiungi un elemento alla lista\n\t3. Cancella un elemento dalla lista\n\t4. Modifica un elemento dalla lista\n\t5. Ordina la lista\n\t6. Stampa il grafico\n\t9. Esci\n"))
	return sc

def strint(stringa):
	try:
		num=int(stringa)
		'''while num<1 or num>20:
			num=input("\nDevi inserire un numero tra 1 e 20! Riprova: ") '''
	except:
		return stringa
	
	return num


system("clear")
scelta=menu()

while scelta!=9:

	if scelta==1:
		i=0
		if len(lista)>0:
			while i<len(lista):
				print(i+1,".",lista[i])
				i+=1
		else:
			print("\nLa lista non contiene elementi\n")

	elif scelta==2:
		elemento=input("\nInserisci un elemento da aggiungere alla lista: ")
		elemento=strint(elemento)
		lista.append(elemento)

	elif scelta==3:
		cancella=input("\nInserisci l' elemento da cancellare: ")
		cancella=strint(cancella)
		if cancella in lista:
			while cancella in lista:
				i=lista.index(cancella)
				del lista[i]
		else:
			print("\nElemento non trovato\n")
			
	elif scelta==4:
		elemento=input("\nInserisci l' elemento da modificare: ")
		elemento=strint(elemento)
		if elemento in lista:
			while elemento in lista:
				i=lista.index(elemento)
				nuovo=input("\nInserisci il nuovo elemento: ")
				nuovo=strint(nuovo)
				lista[i]=nuovo
		else:
			print("\nNon esiste alcun elemento",elemento,"!\n")

	elif scelta==5:
		listanum=[]
		listastringhe=[]
		x=0
		y=0
		i=0
		# dividere la lista in 2 sottoliste di soli numeri e sole
		# stringhe in modo da porterle ordinare con il .sort() e
		# stamparle una dopo l'altra e sostituire la lista originale
		for i in range(0,len(lista))
			try:
			  num=int(lista[i])
			  listanum.append(num)
			except:
			  listastringhe.append(num)			  				
		listanum.sort()
		listastringhe.sort()
		lista=listanum+listastringhe
		print(lista)
		

	elif scelta==6:
		i=0
		while i<len(lista):
			if lista[i] in range(1,21):
				print("*"*lista[i])
			else:
				print(lista[i])
			i+=1

	else:
		print("\nNumero non valido\n")
	
	sleep(3)
	system("clear")
	scelta=menu()

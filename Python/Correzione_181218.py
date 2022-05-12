#Correzione Verifica 

import random

tpiloti={}
circuiti=[]
arrivi=[[0 for x in range(20)] for y in range(10)]


def riempiPiloti():
	for i in range(5):	
		nome=input("\nInserisci il nome del  %d° pilota:" % (i+1))
		scuderia=input("\nInserisci la scuderia del %d° pilota:" % (i+1))
		punti=0
		tpiloti[nome]=(scuderia,0,)		

def riempicirc():
	for i in range(5):
		ctr=input("\nInserisci il nome del %d° circuito:" % (i+1))
		circuiti.append(ctr)

def riempiarrivi():
	for j in range(10):
		#per ogni gara inizio con j=0
		#posiz=[1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20]
		posiz=list(range(1,6))
		for i in range(5):
			#per i=0, per il primo pilota
			pospil=random.randrange(5-i)		#al 1°giro mi tira un numero casuale da 0 a 19	
			arrivi[i][j]=posiz[pospil]			#dentro posiz prendo un valore casuale e lo posiziono in arrivi
			del posiz[pospil]
			i=+1
		j=+1						

def menu1():
	nscud=input("\nInserisci il nome di una scuderia per sapere quali piloti ha dentro:")		#nome della scuderia
	valori=list(tpiloti.values())		#[('ferrari',0),('bmw',0)]
	chiavi=list(tpiloti.keys())
	indice=valori.index((nscud,0))		#se nscud='bmw' --> 1
	nomepilota=chiavi[indice] 	#--> nome del pilota in posizione 1		print(nomepilota)

def menu2():
	#dato il nome di un pilota elencare i circuiti nei quali ha vinto
	npil=input("\nInserisci il nome di un pilota per sapere in quali cricuti ha vinto:")
	nomscud=[]
	nompil=[]
	chiavi=list(tpiloti.keys())
	valori=list(tpiloti.values())
	for i in range(int(tpiloti)):
		a,b=chiavi[i]
		nomscud.append(b)
		nompil.append(a)
	i=0
	if nscud in nomscud:
		k=nomscud.count(nscud)
		while k>1:
			indice=nomscud.index(nscud)
			print(nompil[indice])
			del nompil[indice]
			del nomscud[indice]
			k=k-1

def menu3():
	#dato il numero di gara stampare la classifica arrivi
	circuito=input("\nInserisci il nome del circuito di cui vuoi sapere la classifica:")
	for i in range(len(circuiti)):
		if circuito==circuiti[i]:
			chiave=len(circuiti[i])
			for j in range(len(arrivi)):
				print(arrivi[i][j])
				j=+1
		i=+1

'''def menu4():
	#convertire le posizioni di arrivo in punti (6-1) e salvare su file i pt totali di ogni pilota
	var=0
	punti=[]
	for i in range(5):
		if arrivi[i] [j]==1:
			var=+6
		elif arrivi[i] [j]==2:'''	


riempiPiloti()
riempicirc()
riempiarrivi()
menu1()
menu2()
menu3()
menu4()

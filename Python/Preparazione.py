lista=[]
lista2=[]
lista3=[]
ordinatot=[]
num=0

def inserisci():
	i=0
	quant=int(input("\nQuanti libri vuoi inserire:"))
	for i in range(0,quant):
		codice=int(input("codice -->"))
		lista.append(codice)
		titolo=input("titolo -->")
		lista.append(titolo)
		autore=input("autore -->")
		lista.append(autore)
		anno=int(input("anno di pubblicazione -->"))
		lista.append(anno)
		lista2.append(anno)
		prestito=input("prestito (X se in prestito)-->")
		lista.append(prestito)	
	print(lista)


def ordina():
	i=0
	while(i<num):
		occorrenze=lista2.index(lista2[i])
		listmin=-2
		for y in range(0,occorrenze):
			listatmp=lista[listmin+2]
			indice=listamp.index(lista2[i])
			indiceprec=listmin+indice+2
			ordinatot.append[indice-3]
			ordinatot.append[indice-2]
			ordinatot.append[indice-1]
			ordinatot.append[indice]
			ordinatot.append[indice+1]
		i=i+occorrenze
		lista=ordinatot
		print("\nLa lista ordinata totale è: ")
		print(ordinatot)

def aggiungi():
	codice=int(input("codice -->"))
	lista.append(codice)
	titolo=input("titolo -->")
	lista.append(titolo)
	autore=input("autore -->")
	lista.append(autore)
	anno=int(input("anno di pubblicazione -->"))
	lista.append(anno)
	lista2.append(anno)
	prestito=input("prestito (X se in prestito)-->")
	lista.append(prestito)
	print(lista)	

def cerca():
	i=0
	cerCod=int(input("\nInserisci il codice del libro che vuoi cercare:"))
	while i<num:
		for y in range(0,num):
			cerX=lista.index(lista[i])
			if cerCod==cerX:
				print(lista[cerX+1])
				print(lista[cerX+2])
				print(lista[cerX+3])
				print(lista[cerX+4])
		i=i+1

def prestito():
	i=0
	while i<num:
		Z=lista.index(lista[i])
		if Z=='X':
			lista3.append(lista[i-3])	
		i=i+1 
	print(lista3)

scelta=1
while scelta!=0:
	print("\n1.Inserisci\n2.Ordina\n3.Aggiungi\n4.Aggiungi\n5.Cerca\n6. In prestito\n0.Esci")
	scelta=int(input("scelta -->"))
	if scelta==1:
		inserisci()
	elif scelta==2:
		ordina()
	elif scelta==3:
		aggiungi()
	elif scelta==4:
		cerca()
	elif scelta==5:
		prestito()
	elif scelta==0:
		print("\nSei uscito dal programma\n")
	else:
		print("\nInserimento errato\n")	

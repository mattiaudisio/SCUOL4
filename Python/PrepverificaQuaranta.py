#!/usr/bin/env python3
lista=[]
lista2=[]
ordinatot=[]
num=0
nome=""
eta=0
numerotel=""
i=0
num=input("\nInserisci il numero di persone nella rubrica: ")
num=int(num)
for i in range(0,num):
	nome=input("\nInserisci nome: ")
	lista.append(nome)
	eta=input("\nInserisci età: ")
	eta=int(eta)
	lista.append(eta)
	lista2.append(eta)
	numerotel=input("\nInserisci numero telefono: ")
	lista.append(numerotel)
print("\nLista principale: ")
print(lista)
print("\nLista ordinata per i numeri: ")
lista2.sort()
print(lista2)
numero=int(input("\nQual'e' il numero che si ripete piu' volte:"))	
x=lista.count(numero)
for i in range(0,num):
	if lista2[i]==lista2[i+1]:
		indice=lista.index(lista2[i])
		ordinatot.append(lista[indice+2])	
		ordinatot.append(lista[indice+3])
		ordinatot.append(lista[indice+4])
	else:			
		indice=lista.index(lista2[i])
		ordinatot.append(lista[indice-1])	
		ordinatot.append(lista[indice])
		ordinatot.append(lista[indice+1])
print("\nLa lista ordinata totale è: ")
print(ordinatot)

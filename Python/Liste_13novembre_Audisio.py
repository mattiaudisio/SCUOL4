#Mattia Audisio 4C

import random
random.seed()

def Riempi():
	lista.clear()
	i=0
	quant=int(input("\nQuanti elementi vuoi ?\n"))
	while i!=quant:
		lista.append(random.randint(1,4))
		i=i+1
		print(lista)

def Crea():
	i=0
	for i in range(0,len(lista)):		
		if lista[i]%2==0:
			pari.append(i)		
		else:		
			dispari.append(i)		
	print("Numeri pari:\n",pari)
	print("Numeri dispari:\n",dispari)

def Somma():
	i=0
	sompari=0
	somdispari=0
	for i in pari:			
		sompari=sompari+i
	for i in dispari:			
		somdispari=somdispari+i
		i=i+1
	print("\nSomma pari:",sompari,"\nSomma dispari:",somdispari)
	if sompari>somdispari:
		print("\nLa sottolista pari ha la somma maggiore\n")
	else:
		print("\nLa sottolista dispari ha la somma maggiore\n")
		
def Conta():
	if len(pari)>len(dispari):
		print("\nLa sottolista pari ha piu' elementi\n")
	elif len(pari)<len(dispari):
		print("\nLa sottolista dispari ha piu' elementi\n")
	else:
		print("\nHanno lo stesso numero di elementi\n")	

def Istanze():
		paric=pari[:]
		while len(paric)>0:
			nist=paric.count(paric[0])	
			print(paric[0],"-->",nist*'*')
			for i in range(0,nist):
				paric.remove(paric[0])		
		disparic=dispari[:]
		while len(disparic)>0:
			nist=disparic.count(disparic[0])	
			print(disparic[0],"-->",nist*'*')
			for i in range(0,nist):
				disparic.remove(disparic[0])
'''				
		lista.sort()
		i=0
		while i<len(lista):
				print(lista[i],"--> *",end="")
				if i+1<len(lista):
				while lista[i+1]==lista[i]
					print("*",end="")
					i=i+1
				i=i+1
				print("")					'''									

lista=[]
pari=[]
dispari=[]
scelta=7					
while scelta!=0:
	scelta=int(input("1.Riempi la lista\n2.Crea delle sottoliste\n3.Esegui la somma\n4.Conta le istanze\n5.Conta le istanze ripetute\n0.Uscire\nscelta -->"))
	if scelta==1:
		Riempi()
	elif scelta==2:
		if len(lista)>0:
			Crea()
		else:
			print("\nPrima di andare avanti riempi la lista\n")
	elif scelta==3:
		if len(lista)>0:
			if len(pari)>0:
				Somma()
			else:
				print("\nPrima di andare avanti esegui il punto 2\n")
		else:
			print("\nPrima di andare avanti riempi la lista\n")
	elif scelta==4:
		if len(lista)>0:
			if len(pari)>0:
				Conta()
			else:
				print("\nPrima di andare avanti esegui il punto 2\n")
		else:
			print("\nPrima di andare avanti riempi la lista\n")
	elif scelta==5:
		if len(lista)>0:
			if len(pari)>0:
				Istanze()
			else:
				print("\nPrima di andare avanti esegui il punto 2\n")
		else:
			print("\nPrima di andare avanti riempi la lista\n")
	else:
		print("\nNumero non riconosciuto.Inserisci un numero da 0 a 5\n")
print("\nSei uscito dal programma\n")

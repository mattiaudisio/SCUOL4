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
	pari.clear()
	dispari.clear()
	for i in lista:		
		if i%2==0:
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
	elif len(dispari)>len(pari):
		print("\nLa sottolista dispari ha piu' elementi\n")
	else:
		print("le sottoliste hanno lo stesso numero di elementi")

def Istanze():
	i=0
	nc=0
	parcopia=pari[::]
	disparicopia=dispari[::]
	for i in parcopia:
		k=0
		nc=parcopia.count(i)
		print(i,"-->",nc*'*')
		parcopia.remove(i)
	for i in disparicopia:
		k=0
		nc=disparicopia.count(i)
		print(i,"-->",nc*'*')
		disparicopia.remove(i)
		

lista=[]
pari=[]
dispari=[]
scelta=int(input("1.Riempi la lista\n2.Crea delle sottoliste\n3.Esegui la somma\n4.Conta le istanze\n5.Conta le istanze ripetute\n0.Uscire\n"))
while scelta!=0:
	if scelta==1:
		Riempi()
	elif scelta==2:
		if len(lista)>0:
			Crea()
		else:
			print("\nPrima di andare avanti riempi la lista\n")
	elif scelta==3:
		if len(lista)>0:
			Somma()
		else:
			print("\nPrima di andare avanti riempi la lista\n")

	elif scelta==4:
		if len(lista)>0:		
			Conta()
		else:
			print("\nPrima di andare avanti riempi la lista\n")

	elif scelta==5:
		if len(lista)>0:	
			Istanze()
		else:
			print("\nPrima di andare avanti riempi la lista\n")

	else:
		print("\nNumero non riconosciuto.Inserisci un numero da 0 a 5\n")
	scelta=int(input("1.Riempi la lista\n2.Crea delle sottoliste\n3.Esegui la somma\n4.Conta le istanze\n5.Conta le istanze ripetute\n0.Uscire\n"))
print("\nSei uscito dal programma\n")

#Mattia Audisio 4C

rubrica={}

def ciclo():
	tmp=[]
	nome='c'
	while nome=='fine':
		nome=str(print("\nInserisci un nome [fine per terminare]:"))
		if nome!='fine':
			eta=int(print("\nInserisci l'eta':"))
			tmp.append(eta)
			numTelefono=input("\nInserisci il numero di telefono:")
			tmp.append(eta)
			rubrica[nome]=tmp			
		
def Aggiungi():
	nome=str(print("\nInserisci un nome:"))
	eta=int(print("\nInserisci l'eta':"))
	rubrica[nome]=eta
	numTelefono=int(print("\nInserisci il numero di telefono:"))
	rubrica[nome]=numTelefono

def Stampa():
	if len(rubrica)>0:
		print("\nRubrica\n")
		for nome in rubrica.keys():			
		print("\nNome:\t\t\t",nome,"\netà:\t\t\t",rubrica[nome] [0],"\nNumero di telefono:",rubrica[nome] [1],"\n")
		i+=1
	else:
		print("\nRubrica vuota\n")		

def Ordinare():
	eta=[]
	i=1
	for nome in rubrica.keys(): eta.append(rubrica[nome][0])
		eta.sort
		print("\nVoci in ordine di età:")
		while len(eta)>0:
			for nome in rubrica.keys():
				if eta[0]==rubrica[nome] [0]:
				print("\nNome:\t\t\t",nome,"\netà:\t\t\t",rubrica[nome] [0],"\nNumero di telefono:",rubrica [nome] [1],"\n")
			i+=1
			occorre=0
			if len(eta)>1:
				while (eta[1]==eta[0] and len(eta)>1): occorre=1
				while occorre=1:
					del eta[1]
					occorre=0
					if len(eta)>1:
						if eta[1]==eta[0]: occorre=1
			del eta[0]

def modifica():
	tmp=[]
	cerca=str(print("\nInserisci il nome a cui vuoi modificare nome ed eta':"))
	if cerca in rubrica.keys():
		eta=int(print("\nInserisci l'eta':"))
		tmp.append(eta)
		numTelefono=input("\nInserisci il numero di telefono:")
		tmp.append(numTelefono)
		rubrica[cerca]=tmp		
	else:
		print("\nNumero non trovato\n")
						
i=0
ciclo()
while i==5:
	scelta=int(print("\n1) Aggiungere un nuovo elemento nella rubrica\n2) Stampare gli elementi della rubrica \n3) Ordinare \n4) Richiedere un nome da cercare in rubrica per modificare i suoi valori di età e numero di telefono\n5) Esci\nScelta:"))
	if scelta==1:
		Aggiungi()
	elif scelta==2:
		Stampa()
	elif scelta==3:
		Ordinare()
	elif scelta==4:
		Modifica()
	elif scelta==5:
		print("\nSei uscito dal programma\n")
	else:
		print("\nInserimento errato\n")

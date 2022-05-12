#Mattia Audisio 4C
def inserimento():
	i=0
	t=0
	X=int(input("\nQuante voci vuoi registrare in rubrica:"))
	for i in range(0,X):
		nome=str(input("\nInserisci il nome:"))
		rubrica.append(nome)
		t=t+1
		eta=int(input("\nInserisci l'eta':"))
		rubrica.append(eta)
		t=t+1
		telefono=int(input("\nInserisci il numero di telefono:"))
		rubrica.append(telefono)
		t=t+1
		i=i+1

def ordinamento():
	i=0	
	if len(rubrica)>0:
		for i in range(0,len(rubrica)):
				indice=rubrica.index(rubrica[i])	
				eta.append(rubrica[indice])
				nome.append(rubrica[indice-1])
				telefono.append(rubrica[indice+1])

def stampa():
	i=0	
	for i in range(0,len(eta)):
		print(i+1,"° voce:")
		print(nome[i])
		print(eta[i])
		print(telefono[i])
		print("\n")

def altro():
	print("\nInserisci ancora un voce\n")
	rubrica[len(rubrica)-1]=str(input("\nInserisci il nome:"))
	rubrica[len(rubrica)-1]=int(input("\nInserisci l'eta':"))
	rubrica[len(rubrica)-1]=int(input("\nInserisci il numero di telefono:"))

rubrica=[]
nome=[]
eta=[]
telefono=[]
inserimento()
ordinamento()
altro()
ordinamento()
stampa()

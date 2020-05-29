import random

def crea():
	for i in range(3):
		for a in range(3):
			matrice[i,a]="#"
def stampa():
	for i in range(0,3):
		print('%4s' %(i+1),end='')
	print()
	for i in range(1,4):
		print('%3s' %(i),end='')
		for a in range(1,4):
			print('%3s' %(matrice.get((i,a),'#')),end='')		 #il get serve a restituire un valore predefinito se non trova la chiave
		print("\n")	
	print()
	print()

def gioca():
	giocatore1=0
	giocatore2=0
	contX=0
	contO=0	
	vittoria=0
	riga=999
	casella=999
	while vittoria==0:
		print("Giocatore uno\n")		
		while riga>=3:
			riga=int(input("Inserisci la riga:"))
		while casella>=3:
			casella=int(input("Inserisci la casella:"))
		while matrice[riga-1,casella-1]!='#':
			print("\nSpazio gia' occupato\n")	
			riga=int(input("Inserisci la riga:"))
			casella=int(input("Inserisci la casella:"))
		matrice [riga-1,casella-1]='X'
		stampa()
		for i in range(3):
			for a in range(3):
				aaa=matrice[i,a]
				if aaa==matrice[riga-1,casella-1]:
					matrice[i,a]='X'	
		controllo(contX)
		if contX==4: vittoria=1
		print("Giocatore due\n")		
		while riga>=3:
			riga=int(input("Inserisci la riga:"))
		while casella>=3:
			casella=int(input("Inserisci la casella:"))
		while matrice[riga-1,casella-1]!='#':
			print("\nSpazio gia' occupato\n")	
			riga=int(input("Inserisci la riga:"))
			casella=int(input("Inserisci la casella:"))
		matrice [riga-1,casell-1]='O'
		stampa()
		controllo(contO)		
		if contO==4: vittoria=1

def controllo(cont):
	if matrice [0,0]=='X' and matrice [0,1]=='X' and matrice [0,2]=='X':
		print("\nGIOCATORE 1 HAI VINTO!\n")
		contX+=1
	if matrice [1,0]=='X' and matrice [1,1]=='X' and matrice [1,2]=='X':
		print("\nGIOCATORE 1 HAI VINTO!\n")
		contX+=1
	if matrice [2,0]=='X' and matrice [2,1]=='X' and matrice [2,2]=='X':
		print("\nGIOCATORE 1 HAI VINTO!\n")
		contX+=1
	if matrice [0,0]=='X' and matrice [1,0]=='X' and matrice [2,0]=='X':
		print("\nGIOCATORE 1 HAI VINTO!\n")
		contX+=1
	if matrice [0,1]=='X' and matrice [1,1]=='X' and matrice [2,1]=='X':
		print("\nGIOCATORE 1 HAI VINTO!\n")
		contX+=1
	if matrice [0,2]=='X' and matrice [1,2]=='X' and matrice [2,2]=='X':
		print("\nGIOCATORE 1 HAI VINTO!\n")
		contX+=1
	if matrice [0,0]=='X' and matrice [1,1]=='X' and matrice [2,2]=='X':
		print("\nGIOCATORE 1 HAI VINTO!\n")
		contX+=1
	if matrice [0,2]=='X' and matrice [1,1]=='X' and matrice [2,0]=='X':
		print("\nGIOCATORE 1 HAI VINTO!\n")
		contX+=1
	if matrice [0,0]=='O' and matrice [0,1]=='O' and matrice [0,2]=='O':
		print("\nGIOCATORE 2 HAI VINTO!\n")
		contO+=1
	if matrice [1,0]=='O' and matrice [1,1]=='O' and matrice [1,2]=='O':
		print("\nGIOCATORE 2 HAI VINTO!\n")
		contO+=1
	if matrice [2,0]=='O' and matrice [2,1]=='O' and matrice [2,2]=='O':
		print("\nGIOCATORE 2 HAI VINTO!\n")
		contO+=1
	if matrice [0,0]=='O' and matrice [1,0]=='O' and matrice [2,0]=='O':
		print("\nGIOCATORE 2 HAI VINTO!\n")
		contO+=1
	if matrice [0,1]=='O' and matrice [1,1]=='O' and matrice [2,1]=='O':
		print("\nGIOCATORE 2 HAI VINTO!\n")
		contO+=1
	if matrice [0,2]=='O' and matrice [1,2]=='O' and matrice [2,2]=='O':
		print("\nGIOCATORE 2 HAI VINTO!\n")
		contO+=1
	if matrice [0,0]=='O' and matrice [1,1]=='O' and matrice [2,2]=='O':
		print("\nGIOCATORE 2 HAI VINTO!\n")
		contO+=1
	if matrice [0,2]=='O' and matrice [1,1]=='O' and matrice [2,0]=='O':
		print("\nGIOCATORE 2 HAI VINTO!\n")
		contO+=1
	return cont

matrice={}
coordinate=[]
crea()
stampa()
gioca()

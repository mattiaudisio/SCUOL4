#Mattia Audisio 4C

tpiloti={}
circuiti=('Roma','Monaco','Londra','Tokyo','Dubai','Parigi','Torino','Mosca','Pechino','Las Vegas')
arrivi=[['giro','posizione']]

def inserisci():
	for i in range(0,20):
		nome=(input("\nInserisci il nome del pilota:"))
		scuderia=(input("\nInserisci il nome della scuderia:"))
		tpiloti[scuderia]=nome					

def scuderia():
	scelta=str(input("\nInserisci il nome di una scuderia per avere l'elenco completo dei piloti:"))
	for i in tpiloti.keys():
		print(tpiloti[i-1],"\t")
		i=+1

def vinto():
	y=0
	pilota=str(input("\nInserisci il nome del pilota:"))	
	for j in range(0,20):
		if tpiloti[j]==pilota:
			for i in range(0,10):
				if arrivi[i]==1:
					print(circuiti[j,i])
	
def classifica():
	num=int(input("\nInserisci il numero identificativo del circuito:"))
	for j in range(0,10):	
		if arrivi[j]==num:
			for i in range(0,20):			
				print(i+1,":",arrivi[j,i])
				i=+1
			
decisione=1
inserisci()
while decisione==0:
	decisione=int(input("\n1.Stampa l'elenco dei piloti appartenenti ad una determinata scuderia\n2.determina il nome dei circuiti in cui il pilota ha vinto la gara\n3.visualizza la classifica\n4.Calcola i punti\n0.Esci"))
	if decisione==1:
		scuderia()
	elif decisione==2:
		vinto()
	elif decisione==3:
		classifica()
	elif decisione==0:
		print("\nSei uscito dal programma\n")
	else:
		print("\nInserimento errato\n")


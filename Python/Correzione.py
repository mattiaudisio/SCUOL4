# Mattia Audisio

Titoli=[]
Ordini=[]
scelta=1

def riempi():	
	quant=int(print("\nQuanti CD vuoi inserire:")
	for i in range(0,quant):
		titolo=str(print("\nInserisci il titolo:"))
		Titoli.append(titolo)			
		while num >= 2:
			num=int(print("\nInserisci il titolo:"))
			Titoli.append(num)
	print(Titoli)
	
def cerca():	
	cercaCd=str(print("\nInserisci il nome del CD da cercare:"))
	for i in range(0,len(Titoli)):		
		if cercaCd==titoli[i]:
			print("\nCi sono ",titoli[i+1],"copie")

def acquista():
	t=0
	acquistaCd=str(print("\nChe CD vuoi comprare:"))
	quantCd=int(print("\nquante copie vuoi prendere:"))
	for i in range(0,len(Titoli)):
		if acquistaCd==titoli[i]:
			if quantCd>titoli[i+1]:
				titoli[i+1]=titoli[i+1]-quantCd
				print("\nL'acquisto e' avvenuto con successo\n")
			else:
				print("\nCopie insufficienti\n")
				num=len(quantCd)
				while quantCd>=num:	
					quantCd=int(print("\nquante copie vuoi prendere:"))
		if titoli[i+1]==2:
			Ordini[t]=[Titoli[i]]						
			t=t+1
			
def Ordina():				
	for i in range(0,len(Ordini)):		
		print(Ordini[i])		
		quant=int(print("\nQuanti nuovi pezzi vuoi ordinare:"))		
		for i in range(0,len(Titoli)):		
			if quant=Titoli[i]:	
				Titoli[i]=Titoli[i]+1
		del(Ordini[i])	
			
def stampa():

			
def conta():
	cont=0
	lista=[]
	if len(Ordini)==len(Titoli)//2:
		print("\nTutti i titoli sono inseriti in ordini\n")
	else:
		for i in range(0,len(Titoli),2):
			if Titoli[i] not in Ordini:
				cont+=1
				lista.append(Titoli[i])
		print("\nI titoli non inseriti in ordine sono",cont,"e sono"lista)								
						
while scelta!=7
	scelta=int(print("\n1. Riempi\n2. Cerca\n3. Acquista\n4.Ordina\n5. Stampa\n6. Conta\n7. Esci\nscelta:"))	
	if scelta==1:
		riempi()
	elif scelta==2:
		if len(Titoli)!=0:
			cerca() 
		else:								
			print("\nEsegui prima il punto 1")																		
	elif scelta==3:
		if len(Titoli)!=0:
			acquista()		 
		else:								
			print("\nEsegui prima il punto 1")																		
	elif scelta==4:
		if len(Titoli)!=0:
			Ordina() 
		else:								
			print("\nEsegui prima il punto 1")																		
	elif scelta==5:
		if len(Titoli)!=0:
		 	stampa()
		else:								
			print("\nEsegui prima il punto 1")																		
	elif scelta==6:
		if len(Titoli)!=0:
			conta() 
		else:								
			print("\nEsegui prima il punto 1")																		
	elif scelta==7:
		print("\nSei uscito dal programma\n")
	else:																																								
		print("\nInserimento errato\n")	

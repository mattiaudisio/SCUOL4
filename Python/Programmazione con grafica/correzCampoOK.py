import random


def intero(l,m):
	esci=1
	while esci==1:
		try:
			esci=0
			l=int(l)
			m=int(m)
			return l,m
		except:
			esci=1
			print("hai inserito un valore errato!")
			l=input("Reinserisci un valore coretto: ")
			m=input("Reinserisci un valore coretto: ")


def dissemina():
	for i in range(1,lato+1):
		for j in range(1,lato+1):
			matrice[(i,j)]="#"
			cord.append((i,j))
	copia=cord[:]
	for i in range(mine):
		pos=random.randint(1,lato+1)
		posmine[copia[pos-1]]='X'
		del copia[pos-1]


def stampa(mat):
	j=1
	b=0
	for i in range(1,lato+1):
		print("\t",i,end="")
	print("")
	for i in range(0,lato):
		print(i+1,end="")				
		for a in range(0,lato):		
			print("\t",mat[cord[b]],end="")
			b=b+1
		print("")


def cordinatelati():
	for i in range(1,(len(cord)+1)):
		#creo tutta la cornice in cordinatebordi
		if cord[i-1][1]==1 or cord[i-1][0]==1 or cord[i-1][0]==lato or cord[i-1][1]==lato :
			cordinatebordi.append(cord[i-1])
	cordinateangoli.append((1,1)) 		#coordinate partono da 1,1
	cordinateangoli.append((1,lato))	#fino a lato,lato
	cordinateangoli.append((lato,1))
	cordinateangoli.append((lato,lato))
	cordinatebordi.remove((1,1)) #coordinate partono da 1,1 fino a lato,lato
	#if (1,1) in cordinatebordi:
	if len(cordinatebordi)>0:
		cordinatebordi.remove((lato,lato))
		cordinatebordi.remove((1,lato))
		cordinatebordi.remove((lato,1))


def gioca():
	stampa(matrice)
	cordinatelati()
	finito=0
	contamosse=0
	posvicine=[]
	while len(posvicine)!=lato**2 and finito==0:
		riga=9999999
		colonna=9999999
		while riga>lato or colonna>lato:
			riga=input("Inserire la riga: ")
			colonna=input("Inserire la colonna: ")
			riga,colonna=intero(riga,colonna)
		pos=(riga,colonna)
		posEtic=list(posmine.keys())
		contamosse=contamosse+1
		if pos in posEtic:
			if pos in matrice:  # sempre vero
				matrice[pos]='*'
				finito=1
			stampa(matrice)
			print("***GAME OVER***")
			if contamosse==1:
				print("Con",contamosse,"mossa!")
			else:
				print("Con",contamosse,"mosse!")
		elif pos in cordinatebordi:
			if pos[0]==1: #bordo superiore (esclusi angoli)
				# serve per contare le celle scoperte una volta sola
				if pos not in posvicine:
					posvicine.append(pos)
				# scopro le celle vicino a quella giocata
				if (pos[0],pos[1]+1) not in posvicine:
					posvicine.append((pos[0],pos[1]+1))
				if (pos[0],pos[1]-1) not in posvicine:
					posvicine.append((pos[0],pos[1]-1))
				if (pos[0]+1,pos[1]-1) not in posvicine:
					posvicine.append((pos[0]+1,pos[1]-1))
				if (pos[0]+1,pos[1]) not in posvicine:
					posvicine.append((pos[0]+1,pos[1]))
				if (pos[0]+1,pos[1]+1) not in posvicine:
					posvicine.append((pos[0]+1,pos[1]+1))
				# ridisegna il campo da gioco con 'O' o con 'X'
				for i in range(len(posvicine)):
					if posvicine[i] not in posEtic:
						matrice[posvicine[i]]='O'
					else:
						matrice[posvicine[i]]='X'			
				stampa(matrice)  # stampo il campo da gioco
			if pos[1]==1:  # bordo sinistro (esclusi angoli)
				if pos not in posvicine: posvicine.append(pos)
				if (pos[0]-1,pos[1]) not in posvicine: posvicine.append((pos[0]-1,pos[1]))
				if (pos[0]+1,pos[1]) not in posvicine: posvicine.append((pos[0]+1,pos[1]))
				if (pos[0]-1,pos[1]+1) not in posvicine: posvicine.append((pos[0]-1,pos[1]+1))
				if (pos[0],pos[1]+1) not in posvicine: posvicine.append((pos[0],pos[1]+1))
				if (pos[0]+1,pos[1]+1) not in posvicine: posvicine.append((pos[0]+1,pos[1]+1))
				for i in range(len(posvicine)):
					if posvicine[i] not in posEtic:
						matrice[posvicine[i]]='O'
					else:
						matrice[posvicine[i]]='X'
				stampa(matrice)
			if pos[0]==lato:  # bordo inferiore (esclusi angoli)
				if pos not in posvicine: posvicine.append(pos)
				if (pos[0],pos[1]-1) not in posvicine: posvicine.append((pos[0],pos[1]-1))
				if (pos[0],pos[1]+1) not in posvicine: posvicine.append((pos[0],pos[1]+1))
				if (pos[0]-1,pos[1]) not in posvicine: posvicine.append((pos[0]-1,pos[1]))
				if (pos[0]-1,pos[1]+1) not in posvicine: posvicine.append((pos[0]-1,pos[1]+1))
				if (pos[0]-1,pos[1]-1) not in posvicine: posvicine.append((pos[0]-1,pos[1]-1))
				for i in range(len(posvicine)):
					if posvicine[i] not in posEtic:
						matrice[posvicine[i]]='O'
					else:
						matrice[posvicine[i]]='X'
				stampa(matrice)
			if pos[1]==lato:  # bordo destro (esclusi angoli)
				if pos not in posvicine: posvicine.append(pos)
				if (pos[0]-1,pos[1]) not in posvicine: posvicine.append((pos[0]-1,pos[1]))
				if (pos[0]+1,pos[1]) not in posvicine: posvicine.append((pos[0]+1,pos[1]))
				if (pos[0],pos[1]-1) not in posvicine: posvicine.append((pos[0],pos[1]-1))
				if (pos[0]-1,pos[1]-1) not in posvicine: posvicine.append((pos[0]-1,pos[1]-1))
				if (pos[0]+1,pos[1]-1) not in posvicine: posvicine.append((pos[0]+1,pos[1]-1))
				for i in range(len(posvicine)):
					if posvicine[i] not in posEtic:
						matrice[posvicine[i]]='O'
					else:
						matrice[posvicine[i]]='X'
				stampa(matrice)
		elif pos in cordinateangoli:
			if pos[0]==1 and pos[1]==1:  # angolo in alto a sx
				if pos not in posvicine: posvicine.append(pos)
				if (pos[0],pos[1]+1) not in posvicine: posvicine.append((pos[0],pos[1]+1))
				if (pos[0]+1,pos[1]) not in posvicine: posvicine.append((pos[0]+1,pos[1]))
				if (pos[0]+1,pos[1]+1) not in posvicine: posvicine.append((pos[0]+1,pos[1]+1))
				for i in range(len(posvicine)):
					if posvicine[i] not in posEtic:
						matrice[posvicine[i]]='O'
					else:
						matrice[posvicine[i]]='X'
				stampa(matrice)
			if pos[0]==lato and pos[1]==1:  # angolo in basso a sx
				if pos not in posvicine: posvicine.append(pos)
				if (pos[0]-1,pos[1]) not in posvicine: posvicine.append((pos[0]-1,pos[1]))
				if (pos[0]-1,pos[1]+1) not in posvicine: posvicine.append((pos[0]-1,pos[1]+1))
				if (pos[0],pos[1]+1) not in posvicine: posvicine.append((pos[0],pos[1]+1))
				for i in range(len(posvicine)):
					if posvicine[i] not in posEtic:
						matrice[posvicine[i]]='O'
					else:
						matrice[posvicine[i]]='X'
				stampa(matrice)
			if pos[0]==1 and pos[1]==lato:  # angolo in alto a dx
				if pos not in posvicine: posvicine.append(pos)
				if (pos[0]+1,pos[1]) not in posvicine: posvicine.append((pos[0]+1,pos[1]))
				if (pos[0]+1,pos[1]-1) not in posvicine: posvicine.append((pos[0]+1,pos[1]-1))
				if (pos[0],pos[1]-1) not in posvicine: posvicine.append((pos[0],pos[1]-1))
				for i in range(len(posvicine)):
					if posvicine[i] not in posEtic:
						matrice[posvicine[i]]='O'
					else:
						matrice[posvicine[i]]='X'
				stampa(matrice)
			if pos[0]==lato and pos[1]==lato:  # angolo in basso a dx
				if pos not in posvicine: posvicine.append(pos)
				if (pos[0],pos[1]-1) not in posvicine: posvicine.append((pos[0],pos[1]-1))
				if (pos[0]-1,pos[1]-1) not in posvicine: posvicine.append((pos[0]-1,pos[1]-1))
				if (pos[0]-1,pos[1]) not in posvicine:posvicine.append((pos[0]-1,pos[1]))
				for i in range(len(posvicine)):
					if posvicine[i] not in posEtic:
						matrice[posvicine[i]]='O'
					else:
						matrice[posvicine[i]]='X'
				stampa(matrice)
		else: # la giocata è una coordinata interna
			if pos not in posvicine:
				posvicine.append(pos)
			# scopro le 8 celle attorno alla giocata
			if (pos[0]-1,pos[1]) not in posvicine: posvicine.append((pos[0]-1,pos[1]))
			if (pos[0]-1,pos[1]-1) not in posvicine: posvicine.append((pos[0]-1,pos[1]-1))
			if (pos[0]-1,pos[1]+1) not in posvicine: posvicine.append((pos[0]-1,pos[1]+1))
			if (pos[0],pos[1]-1) not in posvicine: posvicine.append((pos[0],pos[1]-1))
			if (pos[0],pos[1]+1) not in posvicine: posvicine.append((pos[0],pos[1]+1))
			if (pos[0]+1,pos[1]) not in posvicine: posvicine.append((pos[0]+1,pos[1]))
			if (pos[0]+1,pos[1]-1) not in posvicine: posvicine.append((pos[0]+1,pos[1]-1))
			if (pos[0]+1,pos[1]+1) not in posvicine: posvicine.append((pos[0]+1,pos[1]+1))
			for i in range(len(posvicine)):
				if posvicine[i] not in posEtic:
					matrice[posvicine[i]]='O'
				else:
					matrice[posvicine[i]]='X'
			stampa(matrice)

	tupla=(len(posvicine),contamosse)
	return tupla


def stampafile(text):
	j=1
	b=0
	text.write("   ")
	for i in range(1,lato+1):
		text.write("%3d"%i)
	text.write("\n")
	for i in range(0,lato):
		text.write("%3d"%(i+1))				
		for a in range(0,lato):		
			text.write("%3s"%matrice[cord[b]])
			b=b+1
		text.write("\n")


cord=[]
cordinatebordi=[]
cordinateangoli=[]
posmine={}
matrice={}
lato=input("Inserisci il lato del campo di gioco: ")
mine=input("Inserisci il numero di bombe: ")
lato,mine=intero(lato,mine)
while mine>lato**2:
	mine=input("Inserisci il numero di bombe, nel campo non ci sono questi spazi: ")
	mine=intero(mine)
dissemina()
tupla=gioca()
if tupla[0]==(lato**2):
	print("Sono state salvate le informazioni della partita!")
	testo=open("campominato.txt","w")
	stampafile(testo)
	testo.write("***HAI VINTO***\n")
	if tupla[1]==1:
		testo.write("Con %d mossa"%tupla[1])
	else:
		testo.write("Con %d mosse"%tupla[1])
	testo.close()

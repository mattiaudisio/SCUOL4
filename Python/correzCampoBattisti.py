import random
def intero(var):
	esci=1
	while esci==1:
		try:
			esci=0
			var=int(var)
			return var
		except:
			esci=1
			print("hai inserito un valore errato!")
			var=input("Reinserisci un valore coretto: ")

def dissemina():
	for i in range(1,lato+1):
		for j in range(1,lato+1):
			matrice[(i,j)]="#"
			cordinate.append((i,j))
	copia=cordinate[:]
	for i in range(mine):
		pos=random.randint(1,lato+1)
		posmine[copia[pos-1]]='X'
		del copia[pos-1]  	

def stampa(mat):
	bb=0
	ff=0
	j=1
	for i in range(lato):
		print("  ",i+1,end="")
	for i in range(1,(len(cordinate)+1)):	
		if i==1:
			print("\n",end="")
			print("1",end="")
		    bb=len(i)-1
			print(" ",mat.get(cordinate[bb],'#'),end=" ")
		else:
			if i%lato==0:
				j=j+1
			    bb=len(i-1)
				print(" ",mat.get(cordinate[bb],'#'), end=" ")
				ff=lato+1
				if j<ff:
					print("\n",end="")
					print(j,end="")
			else:
				bb=len(i)-1
				print(" ",mat.get(cordinate[bb],'#'), end=" ")
	print("\n")


def cordinatelati():
	for i in range(1,(len(cordinate)+1)):
		bb=len(i)-1
		if cordinate[bb][1]==1 or cordinate[bb][0]==1 or cordinate[bb][0]==lato or cordinate[bb][1]==lato :
			cordinatebordi.append(cordinate[bb])
		cordinateangoli.append((1,1))			#coordinate partono da 1,1 fino a lato,lato 
		cordinatebordi.append((1,lato))			
		cordinateangoli.append((lato,1))			
		cordinateangoli.append((lato,lato)
		cordinatebordi.remove((1,1))
		if len(cordinatebordi)>0:			
			cordinateangoli.append((lato,lato)
			cordinatebordi.append((1,lato))			
			cordinateangoli.append((lato,1))			
			
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
			riga=input("Inserisci la riga: ")
			colonna=input("Inserisci la colonna: ")
			riga,colonna=mossa.split(" ")
			riga=intero(riga)
			colonna=intero(colonna)
		pos=(riga,colonna)
		posEtic=list(posmine.keys())
		contamosse=contamosse+1
		if pos in posEtic:
			for i in range(len(cordinate)):
				if pos==cordinate[i]:
					matrice[pos]='*'
					finito=1
			stampa(matrice)
			print("***GAME OVER***")
			if contamosse==1:
				print("Con",contamosse,"mossa!")
			else:
				print("Con",contamosse,"mosse!")
		elif pos in cordinatebordi:						
			if pos[0]==1:		#bordo superiore (esclusi angoli)
				#serve per contare le celle scoperte una volta sola
				if pos not in posvicine: posvicine.append(pos)
				#scopro le celle vicino a  quella giocata
				if (pos[0],pos[1]+1) not in posvicine: posvicine.append((pos[0],pos[1]+1))
				if (pos[0],pos[1]-1) not in posvicine: posvicine.append((pos[0],pos[1]-1))
				if (pos[0]+1,pos[1]-1) not in posvicine: posvicine.append((pos[0]+1,pos[1]-1))
				if (pos[0]+1,pos[1]) not in posvicine: posvicine.append((pos[0]+1,pos[1]))
				if (pos[0]+1,pos[1]+1) not in posvicine: posvicine.append((pos[0]+1,pos[1]+1))
				#ridisegna il campo da gioco con 'O' o con 'X'
				for i in range(len(posvicine)):
					if posvicine[i] not in posEtic:
						matrice[posvicine[i]]='O'
					else:
						matrice[posvicine[i]]='X'			
				stampa(matrice)			#stampo il campo da gioco
			if pos[1]==1:
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
			if pos[0]==lato:	#bordo inferiore (esclusi angoli)
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
			if pos[1]==lato:	#bordo destro (esclusi angoli)
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
			if pos[0]==1 and pos[1]==1: #angolo in alto a sinistra
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
			if pos[0]==lato and pos[1]==1: #angolo in basso a sinistra
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
			if pos[0]==1 and pos[1]==lato: #angolo in alto a destra
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
			if pos[0]==lato and pos[1]==lato: #angolo in basso a destra
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
		else:	#la giocata è una coordinata interna
			if pos not in posvicine: posvicine.append(pos)
			#scopro le otto celle attorno alla giocata
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
	for i in range(lato):
		if i==0:
			text.write("%3d"%(i+1))
		else:
			text.write("%2d"%(i+1))
	for i in range(1,(len(cordinate)+1)):	
		if i==1:
			text.write("\n")
			text.write("1")
			text.write("%2s"%matrice.get(cordinate[i-1]))
		else:
			if i%lato==0:
				j=j+1
				text.write("%2s"%matrice.get(cordinate[i-1]))
				if j<lato+1:
					text.write("\n")
					text.write("%d"%j)
			else:
				text.write("%2s"%matrice.get(cordinate[i-1]))
	text.write("\n")


cordinate={}
cordinatebordi={}
cordinateangoli={}
posmine={}
matrice={}
lato=input("Inserisci il lato del campo di gioco: ")
lato=intero(lato)
mine=input("Inserisci il numero di bombe: ")
mine=intero(mine)
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

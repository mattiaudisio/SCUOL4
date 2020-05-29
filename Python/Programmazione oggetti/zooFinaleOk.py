import time, random

class Animale:

	def __init__(self,nome,eta):
		self.setNome(nome).setEta(eta)

	def __str__(self): return "Nome:{} # Età:{} # {}".format(self.getNome(),self.getEta(),self.info())	

	def info(self): return "** INFO Padre **"
	def parla(self): print("** PARLA Padre **")
	def muove(self): print("** MUOVE Padre **")
	def mangia(self): print("** MANGIA Padre **")
	def beve(self): print("** BEVE Padre **")

	def dorme(self,n):
		try: time.sleep(int(n))
		except: self.dorme(input("Inserire tempo valido: "))	

	def setNome(self,v):
		self.__nome=v
		return self

	def getNome(self): return self.__nome

	def setEta(self,v):
		self.__eta=v
		return self

	def getEta(self): return self.__eta		


class Cane(Animale):

	def __init__(self,nome,eta,razza):
		super().__init__(nome,eta)
		self.setRazza(razza)
	
	def info(self):
		#sovrascrivo la info() del padre
		return "Razza: "+self.getRazza()
	
	def parla(self):
		super().parla()
		return "Abbaia"
	
	def muove(self):
		super().muove()
		return "Corre"
	
	def mangia(self):
		super().mangia()
		return "Mangia"
	
	def beve(self):
		super().beve()
		return "Beve"
			
	def setRazza(self,v): self.__razza=v
	
	def getRazza(self): return self.__razza	


class Cavallo(Animale):
	
	def __init__(self,nome,eta,mantello):
		super().__init__(nome,eta)
		self.setMantello(mantello)
	
	def info(self):
		#sovrascrivo la info() del padre
		return "Mantello: "+self.getMantello()
	
	def parla(self):
		super().parla()
		return "Nitrisce"
	
	def muove(self):
		super().muove()
		return "Galoppa"
	
	def mangia(self):
		super().mangia()
		return "Mangia"
	
	def beve(self):
		super().beve()
		return "Si abbevera"
	
	def setMantello(self,v): self.__mantello=v
	
	def getMantello(self): return self.__mantello
	

class Leone(Animale):
	
	def __init__(self,nome,eta,peso):
		super().__init__(nome,eta)
		self.setPeso(peso)
	
	def info(self):
		#sovrascrivo la info() del padre
		return "Peso: "+str(self.getPeso())
	
	def parla(self):
		super().parla()
		return "Ruggisce"
	
	def muove(self):
		super().muove()
		return "Va come un fulmine"
	
	def mangia(self):
		super().mangia()
		return "Divora"
	
	def beve(self):
		super().beve()
		return "Ingurgita"
	
	def setPeso(self,v): 
		try: self.__peso=int(v)
		except: self.setPeso(input("Inserire peso valido"))
	
	def getPeso(self): return self.__peso		
	
lista=[]
nomi="Abaco","Abbondanzio","Abbondio","Abdone","Abelardo","Abele","Abenzio","Abibo","Abramio","Abramo","Acacio","Acario","Accursio","Achille","Acilio","Aciscolo","Acrisio","Adalardo","Adalberto","Adalfredo","Adalgiso","Adalrico","Adamo","Addo","Adelardo","Adelberto"
razze="Australian Kelpie","Australian Cattle Dog","Australian Sheperd - Pastore Australiano","Bearded Collie","Berger de la Beauce - Beauceron","Berger de la Brie - Briard","Berger de Picardie" ,"Bobtail","Border Collie","Bovaro delle Ardenne","Bovaro delle Fiandre","Cane Lupo Cecoslovacco"
mantello="Baio","Morello","Sauro","Falbo","Grigio","Roano","Isabella","Palomino","Cremello","Albino"
for x in range(random.randint(1,10)): lista.append(Cane(nomi[random.randint(0,len(nomi)-1)],random.randint(0,20),razze[random.randint(0,len(razze)-1)]))
for a in range(random.randint(1,10)): 
	lista.append(Cavallo(nomi[random.randint(0,len(nomi)-1)],random.randint(0,20),mantello[random.randint(0,len(mantello)-1)]))
	x+=1
for a in range(random.randint(1,10)): 
	lista.append(Leone(nomi[random.randint(0,len(nomi)-1)],random.randint(0,20),random.randint(0,50)))
	x+=1	
for i in range(20):
	indice=random.randint(0,len(lista)-1)
	op=random.randint(1,5)
	if op==1: print(lista[indice],"Parla:",lista[indice].parla())
	elif op==2: print(lista[indice],"Muove:",lista[indice].muove())
	elif op==3: print(lista[indice],"Mangia:",lista[indice].mangia())
	elif op==4: print(lista[indice],"Beve:",lista[indice].beve())	
	elif op==5:
		print(lista[indice],"\n--Vorrei dormire...")
		lista[indice].dorme(input("Inserisci quanto posso dormire: "))
		print("--Mi son svegliato!")
	time.sleep(1)				

print("\n**** RESOCONTO ****")
for i in range(len(lista)): print(lista[i])

print("\n>>>> Generico Animale:")
anim1=Animale("GenericoAnimale",17)
print(anim1) #la str originale del padre usa la info() del padre


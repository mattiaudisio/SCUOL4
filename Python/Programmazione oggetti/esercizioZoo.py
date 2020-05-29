import random
import time

nomeCane=['Balto','Beethoven','Brian','Idefix','Nebbia','Rex','Pongo','Toby','Napoleone','Remo']
nomeCavallo=['Pegaso','Canaglia','Macedonia','Freccia','Lucky','Zaffiro','Sultano','Raggio','Odino','Russel']
nomeLeone=['Furia','Simba','Zanna','Garfield','Bianca','Fido','Felino','Akira','Amber','Athos']
caratteristicheCane=['Barboncino','Bastardino','Pitbull','Husky','Bulldog','Carlino','Pastore Tedesco','Maltese','Bassotto','Alano']
caratteristicheCavallo=['Ordinario','Slavato','Dorato','Castagno','Bruno','Corvino','Metallico','Pel di vacca','Sorcino','Roano']
animali=[]

class Animale:
	def __init__(self,nome="",eta=0):
		self.setNome(nome)
		self.setEta(eta)
	
	def __str__(self):
		return 'Nome: {} \tEtà: {}'.format(self.getNome(),self.getEta())

	def info(self):
		pass	

	def parla(self):
		pass	

	def muove(self):
		pass	

	def mangia(self):
		pass	

	def beve(self):
		pass	

	def dorme(self,n):
		try:
			time.sleep(n)
		except:
			num=input("\nInserisci un intero:")	
			dorme(num)				

	def setNome(self,valore):
		self.__n=valore
	
	def getNome(self):
		return self.__n

	def setEta(self,valore):
		self.__e=valore
	
	def getEta(self):
		return self.__e

class Cane(Animale):
	def __init__(self,nome="",eta=0,razza=""):
		super().__init__(nome,eta)			
		self.setRazza(razza)

	def info(self):
		return 'Sono un {}'.format(self.getRazza(self))

	def parla(self):
		return 'abbaia'	

	def muove(self):
		return 'corre'	

	def mangia(self):
		return 'mangia'	

	def beve(self):
		return 'beve'	

	def setRazza(self,valore):
		self.__r=valore
	
	def getRazza(self,valore):
		return self.__r

class Cavallo(Animale):
	def __init__(self,nome="",eta=0,mantello=""):
		super().__init__(nome,eta)
		self.setMantello(mantello)				

	def info(self):
		return 'Sono di colore {}'.format(self.getMantello(self))

	def parla(self):
		return 'nitrisce'	

	def muove(self):
		return 'galoppa'	

	def mangia(self):
		return 'mangia'	

	def beve(self):
		return 'si abbevera'	

	def setMantello(self,valore):
		self.__m=valore
	
	def getMantello(self,valore):
		return self.__m

class Leone(Animale):
	def __init__(self,nome="",eta=0,peso=0):
		super().__init__(nome,eta)
		self.setPeso(peso)	

	def info(self):
		return 'Peso {} kg'.format(self.getPeso(self))

	def parla(self):
		return 'Ruggisce'	

	def muove(self):
		return 'va come un fulmine'	

	def mangia(self):
		return 'divora'	

	def beve(self):
		return 'ingurgita'	

	def setPeso(self,valore):
		self.__p=valore
	
	def getPeso(self,valore):
		return self.__p

numCiclo=random.randint(1,10)
numTot=numCiclo*3
print("animali presenti:",numTot)
print("\n")
for i in range(0,numTot):
	scelta=random.randint(1,10)
	animali.append(Cane(nomeCane[scelta-1],random.randint(1,10),caratteristicheCane[scelta-1]))
	scelta=random.randint(1,10)
	animali.append(Cavallo(nomeCavallo[scelta-1],random.randint(1,10),caratteristicheCavallo[scelta-1]))	   
	scelta=random.randint(1,10)
	peso=int(input("\nInserisci il peso del leone:"))
	animali.append(Leone(nomeLeone[scelta-1],random.randint(1,10),peso))	 
print("\n")
for i in range(20):
	numCasuale=random.randint(0,numCiclo)
	scelta=random.randint(1,5)
	if scelta==1:
		print(animali[numCasuale],"| Informazioni:",animali[numCasuale].info(),"| operazioneScelta: Info")
	elif scelta==2:
		print(animali[numCasuale],"| Informazioni:",animali[numCasuale].parla(),"| operazioneScelta: Parla")
	elif scelta==3:
		print(animali[numCasuale],"| Informazioni:",animali[numCasuale].muove(),"| operazioneScelta: Muove")
	elif scelta==4:
		print(animali[numCasuale],"| Informazioni:",animali[numCasuale].mangia(),"| operazioneScelta: Mangia")
	else:
		print(animali[numCasuale],"| Informazioni:",animali[numCasuale].beve(),"| operazioneScelta: Beve")
	animali[numCasuale].dorme(1)

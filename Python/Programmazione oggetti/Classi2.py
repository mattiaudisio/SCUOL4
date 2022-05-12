class Numeri:
	def __init__(self, primo=1, secondo=1):
		self.pr=primo
		self.se=secondo
	def __str__(self):
		return 'primo: {} secondo:{}'.format(self.pr,self.se)
	def moltiplica(self):
		return self.pr*self.se

coppia1=Numeri(5,8)
coppia2=Numeri()
print(coppia1)
print(coppia2)
print('La moltiplicazione vale: ',coppia1.moltiplica())

#overloading

class Numero:
	def __init__(self,num1=0,num2=0):
		self.n1=num1
		self.n2=num2
	def __str__(self):
		return 'Num1: {} Num2:{}'.format(self.n1,self.n2)
	def __add__(self,num):
		return Numero(self.n1+num,self.n2+num)
	def __mul__(self,num):
		return Numero(self.n1*num,self.n2*num)
	def __sub__(self,num):
		return Numero(self.n1-num,self.n2-num)
	__radd__=__add__

coppia1=Numero(3,2)
print(coppia1+3)
print(coppia1-8)
#SE NON METTO __radd__=__add__ NON POSSO FARE print(num+variabileCheRichiamaLaClasse)
print(2+coppia1)

#introspezione
class Punto:
	def __init__(self,x,y):
		self.x1=x
		self.y1=y	
	def __str__(self):
		return 'x:{} y:{}'.format(self.x1,self.y1)
	def __add__(self,i):
		if type(i) is Punto:
			return Punto(self.x1+i.x1,self.y1+i.y1)
		if type(i) is int:
			return Punto(self.x1+i,self.y1+i)
		return NotImplemented
	__radd__=__add__

P1=Punto(10,20)
print(P1+4)
P2=Punto(6,9)
print(P1+P2)
print(5+P2)

####
class Agenda:
	def __init__(self,nome="",cognome="",eta=0):
		self.n=nome
		self.c=cognome
		self.e=eta
	def __str__(self):
		return 'Nome:{} Cognome:{} Eta:{}'.format(self.n,self.c,self.e)
	def __add__(self,num):
		if type(num)is Agenda:
			return Agenda(self.e+num.e)
		if type(num) is int:
			return Agenda(self.e+num)

contatto1=Agenda("Marco","Tardelli",34)
contatto2=Agenda("Antonio","Cabrini",22)
print(contatto2.e+10)
print(contatto1.e+contatto2.e)
print("\n")

#######################################################################################################
### - Definire una classe Tempo con Ore,Minuti e Secondi 										    ###
### - Definire il meto __add__ che abbia come parametro i secondi 								    ###
### - Se i secondi superano i secondi,aumentare i minuti, sei minuti superano i 60 aumentare le ore ###
#######################################################################################################

class Tempo:
	def __init__(self,ore="",minuti="",secondi=""):
		self.O=ore
		self.min=minuti
		self.sec=secondi
	def __str__(self):
		return 'Ore:{} Minuti:{} Secondi:{}'.format(self.O,self.min,self.sec)	
	def __add__(self,num):
		self.sec=num+self.sec
		while self.sec>=60:
			self.sec=self.sec-60
			self.min=self.min+1
		while self.min>=60:
			self.min=self.sec-60
			self.O=self.O+1
		return Tempo(self.O,self.min,self.sec)
	__radd__=__add__					

tempo1=Tempo(4,25,40)
print(tempo1+100)

##########################################################
class Immagine:
	def __init__(self,nomeFile, altezza=600,larghezza=300, tipoFile='JPG'):
		self.nome=nomeFile
		self.alt=altezza
		self.larg=larghezza
		self.tipo=tipoFile
	def __str__(self):
		return 'Nome: {} Altezza: {} Larghezza: {} tipo File:{}'.format(self.nome,self.alt,self.larg,self.tipo)

imma1=Immagine('vacanze.jpg',larghezza=480)
print(imma1)
imma2=Immagine('vacanza.jpg',larghezza=-12)
print(imma2)

#ridefinizione classe utilizzando metodi get e set

class Immagini:
	def __init__(self,nomeFile, altezza=120,larghezza=480):
		self.n=nomeFile
		self.setAlt(altezza)			#richiama un metodo che settera' l'altezza
		self.l=larghezza
	def setAlt(self,valore):			#metodo set mi imposta un attributo privato	
		assert(isinstance(valore,int))			#verifica il tipo passato
		assert(valore>0)
		self.__a=valore		
	def getAlt(self):					#mi restituisce il valore dell'attributo
		return self.__a
	def __str__(self):
		return 'Nome: {} Altezza: {} Larghezza: {}'.format(self.n,self.getAlt(),self.l)

foto1=Immagini('Topolino.jpg')
foto1.setAlt(680)
print(foto1)

#######################################################################################################################################################
###																esercizio 1																			###
#######################################################################################################################################################
### - creare una classe Animale con metodi di setNome,getNome,setPeso, getPeso, setSesso, getSesso,verso, interroga(restituisce il tipo di animale).###
### - creare 4 oggetti di tipo animale (cane,gatto,ippopotamo,...)																					###			
### - fare in modo che si presentano, settare il peso ed il sesso																				    ###
### - fare la differenza di peso tra es.cane e gatto, gatto e ippopotamo																		    ###				
#######################################################################################################################################################
#######################################################################################################################################################
###																esercizio 2																			###
#######################################################################################################################################################
### - creare una classe Conto in grado di permettere versamenti, prelievi e restituire il saldo														###
### - fare la differenza tra 2 conti. segnalare un conto in rosso																					###			
#######################################################################################################################################################

#Esercizio1
class Animale:
	def __init__(self,tipo="",nome="",peso=0,sesso="",verso=""):
		self.setTipo(tipo)		#gli passo tipo
		self.setNome(nome)
		self.setPeso(peso)	
		self.setSesso(sesso)
		self.setVerso(verso)	
	def __str__(self):
		return 'Sono un {}, mi chiamo {}, peso {}, sono di sesso {}, e faccio come verso {}'.format(self.getTipo(),self.getNome(),self.getSesso(),self.getPeso(),self.getVerso())
	def setTipo(self,valore):
		self.__tip=valore
	def getTipo(self):
		return self.__tip
	def setNome(self,valore):
		self.__n=valore
	def getNome(self):
		return self.__n
	def setPeso(self,valore):
		assert(isinstance(valore,int))
		assert(valore>0)
		self.__p=valore
	def getPeso(self):
		return self.__p
	def setSesso(self,valore):
		self.__s=valore
	def getSesso(self):
		return self.__s
	def setVerso(self,valore):
		self.__v=valore
	def getVerso(self):
		return self.__v
	def __sub__(self,n):			#differenza di peso
		if type(n) is Animale:
			return self.getPeso()-n.getPeso()
		if type(n) is int:
			return self.getPeso()-n
	def interroga(self):
		return 'sono un {}'.format(self.getTipo())
	
anim1=Animale()
anim1.setTipo("Cane")
anim1.interroga()
anim1.setNome("Fido")	
anim1.setPeso(100)
anim1.setsesso("M")
anim1.setVerso("Bau bau")
print(anim1)
anim2=Animale()
tipo1=input("Che animale sei?")
anim2.setTipo(tipo1)
anim2.setTipo("Gatto")
anim2.interroga()
anim2.setNome("Fuffi")	
anim2.setPeso(10)
anim2.setsesso("M")
anim2.setVerso("Miao Miao")
print(anim1-anim2)


#Esercizio 2
class Conto:
	def __init__(self,conto1=0,conto2=0):
		self.cont1=conto1
		self.cont2=conto2
	def __str__(self):
		return 'Versamento:{} Prelievo:{} Saldo:{}'.format(self.vers,self.prel,self.sald)	
	def sceltAzione(self):
		print("\nConto 1")
		scelta=input("\nVuoi effettuare un prelievo o un versamento [0: prelievo	1:versamento]:")
		if scelta==0:
			quant=int(input("\nInserisci la somma di denaro che vuoi prelevare:"))
			self.cont1=self.cont1-quant
		if scelta==1:			
			quant=int(input("\nInserisci la somma di denaro che vuoi versare:"))
			self.cont1=self.cont1+quant
		print("\nConto 2")
		scelta=input("\nVuoi effettuare un prelievo o un versamento [0: prelievo	1:versamento]:")
		if scelta==0:
			quant=int(input("\nInserisci la somma di denaro che vuoi prelevare:"))
			self.cont2=self.cont2-quant
		else:			
			quant=int(input("\nInserisci la somma di denaro che vuoi versare:"))
			self.cont2=self.cont2+quant
		if self.cont1<=0:
			print("\nIl conto 1 e' in rosso")
		if self.cont2<=0:
			print("\nIl conto 2	 e' in rosso")
	def differenza(self):
		return self.cont1-self.cont2

c1=int(input("\nInserisci un conto:"))
c2=int(input("\nInserisci un'altro conto:"))
conto12=Conto(c1,c2)
conto12.sceltAzione()
print("La differenza e' di",conto12.differenza())	

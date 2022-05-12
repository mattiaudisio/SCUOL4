import math

class Auto:
	pass
#gli attriubti sono le caratteristiche, i metodi le azioni

class Libro:
	#costruttore
	#il costruttore della classe è un metodo che definisce le caratteristiche della classe
	def __init__(self,titolo="non specificato",autore="non specificato",numeroPagine=0):	#il primo parametro è sempre self
		self.tit=titolo		#quando richiamerò il costruttore e gli passerò titolo, tit rappresentera titolo; fanno riferimento alla classe in cui sto lavorando
		self.aut=autore
		self.pag=numeroPagine
		#sono gli attributi che vanno a definire il nostro oggetto
	def stampa(self):	
		print('Titolo: {} Autore: {} Pagine: {}'.format(self.tit,self.aut,self.pag))		#{} sono come i %d


#creo l'istanza libro 1
print("\n")
libro1=Libro(titolo="I Promessi Sposi", autore="Manzoni", numeroPagine=550)			#self non è scritto ma è implicito
libro1.stampa()

libro2=Libro()
libro2.stampa()

libro3=Libro("La Divina Commedia","Dante",784)
libro3.stampa()

libro4=Libro("Don Chisciotte",numeroPagine=854)
libro4.stampa()
print("\n")

###################################################

class Persona:
	def __init__(self, nome="",cognome="",eta=0):
		self.nom=nome
		self.cogn=cognome
		self.et=eta
	def __str__(self):		#converte in stringa l'oggetto
		return '{} {} {}'.format(self.nom,self.cogn,self.et)
	def presentati(self):
		print('Nome: {} Età: {}'.format(self.nom,self.et))
	def saluti(self):
		print('Benvenuto {}'.format(self))			#self riproporra tutti gli attributi che appartengono a quella classe

pers1=Persona("Mario","Rossi",22)
pers1.presentati()
pers1.saluti()
print("\n")

###################################################

class Numeri:
	def __init__(self,num1=1,num2=1):
		self.n1=num1
		self.n2=num2
	def __str__(self):
		return 'Num1: {}, Num2: {}'.format(self.n1,self.n2)
	def moltiplica(self):
		return self.n1*self.n2

coppia1=Numeri(6,2)
coppia2=Numeri()		#sarà composta da 1,1
coppia3=Numeri(5,8)
print(coppia1)			#posso farla perchè ho messo la str
print('Risultato moltiplicazione -->',coppia1.moltiplica())
print(coppia2)
print('Risultato moltiplicazione -->',coppia2.moltiplica())
print(coppia3)
print('Risultato moltiplicazione -->',coppia3.moltiplica())
print("\n")

###################################################

class Punto:
	def __init__(self,puntoX1=0,puntoY1=0,puntoX2=0,puntoY2=0):
		self.px=puntoX1
		self.py=puntoY1
		self.px2=puntoX2
		self.py2=puntoY2
	def __str__(self):
		return 'punto X: {}, punto Y: {}'.format(self.px,self.py)
	def stampa(self):
		print('\nIl valore dell oggetto Y è {}'.format(self.py))
		print('\nP1(Attributo X:{} , Attributo Y:{})'.format(self.px,self.py))
	def distanza(self):
		dx=l2X-l1X		
		dy=l2Y-l1Y
		dist=dx**2+dy**2
		ris=math.sqrt(dist)
		print('La distanza tra i 2 punti vale',ris)

class Rettangolo:
	def __init__(self,larghezza=0,altezza=0):
		self.lar=larghezza
		self.alt=altezza
	def __str__(self):
		return 'Larghezza: {}, altezza: {}'.format(self.lar,self.alt)	
	def stampa(self):
		print('Larghezza: {}, Altezza: {}'.format(self.lar,self.alt))		

class Cerchio:
	def __init__(self,puntoX=0,puntoY=0):
		self.px=puntoX
		self.py=puntoY
	def __str__(self):
		return 'punto X: {}, punto Y: {}, raggio: {}'.format(self.px,self.py,self.r)	
	def testaCerchio(self):
		R = int(input("\nInserisci il raggio"))
		dx=0-rX		
		dy=0-rY
		dist=dx**2+dy**2
		ris=math.sqrt(dist)			
		if ris <= R:
			print("\nL'origine degli assi cade nel cerchio\n")	
		else:	
			print("\nL'origine degli assi non cade nel cerchio\n")	

punto1=Punto(3,4)
punto1.stampa()
l1X=int(input("\nQuanto vale la X del primo lato:"))
l1Y=int(input("\nQuanto vale la Y del primo lato:"))
l2X=int(input("\nQuanto vale la X del secondo lato:"))
l2Y=int(input("\nQuanto vale la Y del secondo lato:"))
punto2=Punto(l1X,l1Y,l2X,l2Y)
punto1.distanza()
rett=Rettangolo(100,200)
rett.stampa()
rX = int(input("\nInserisci la coordinata x: "))
rY = int(input("\nInserisci la coordinata y: "))
punto3=Cerchio(rX,rY)
punto3.testaCerchio()

###################################################


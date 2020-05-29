import math

class Auto:
	pass

class Libro:
	#costruttore
	def __init__(self, titolo="non specificato", autore="non specificato", numeroPagine=0):
		self.tit=titolo
		self.aut=autore
		self.pag=numeroPagine
	
	def stampa(self):
		print('Titolo: {} Autore: {} Pagine: {}'.format(self.tit, self.aut, self.pag))
		
# creo istanza libro1
libro1=Libro(titolo="I Promessi Sposi", autore="Manzoni", numeroPagine=550)
libro1.stampa()

libro2=Libro()
libro2.stampa()

libro3=Libro("La Divina Commedia", "Dante", 784)
libro3.stampa()

libro4=Libro(titolo="Don Chisciotte",numeroPagine=854)
libro4.stampa()

##############################

class Persona:
	def __init__(self, nome="", cognome="", eta=0):
		self.nom=nome
		self.cog=cognome
		self.et=eta
	
	def __str__(self):
		return '{} {} {}'.format(self.nom, self.cog, self.et)
		
	def presentati(self):
		print('Nome: {} Eta {}'.format(self.nom,self.et))
		
	def saluti(self):
		print('Benvenuto {}'.format(self))

pers1=Persona("Mario", "Rossi", 22)
pers1.presentati()
pers1.saluti()
print(pers1)

#####################

class Numeri:
	def __init__(self, num1=1, num2=1):
		self.n1=num1
		self.n2=num2
	
	def __str__(self):
		return 'Num1: {}, Num2: {}'.format(self.n1,self.n2)
		
	def moltiplica(self):
		return self.n1*self.n2

coppia1=Numeri(6,2)
coppia2=Numeri()
coppia3=Numeri(5,8)
print(coppia1)
print('Risultato moltiplicazione --> ', coppia1.moltiplica())
print(coppia2)
print(coppia3)
#####################
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
	def calcolaPerimetro(self):
		perimetro=(self.lar+self.alt)*2
		print(perimetro)		
	def sonoQuadrato(self):
		if self.lar	== self.alt:
			print("\nIl rettangolo che hai inserito e' un quadrato\n")
			return True
		else:
			print("\nIl rettangolo che hai inserito non e' un quadrato\n")
			return False

class Cerchio:
	def __init__(self,puntoX=0,puntoY=0,raggio):
		self.px=puntoX
		self.py=puntoY
		self.r=ragggio
	def __str__(self):
		return 'punto X: {}, punto Y: {}, raggio: {}'.format(self.px,self.py,self.r)	
	def testaCerchio(self):
		dx=0-rX		
		dy=0-rY
		dist=dx**2+dy**2
		ris=math.sqrt(dist)			
		if ris <= raggio:
			print("\nL'origine degli assi cade nel cerchio\n")	
		else:	
			print("\nL'origine degli assi non cade nel cerchio\n")
	def calcolaArea(self):
		area=float(3.14*raggio**2)
		print("\nArera:",area)		
	def sovrapposto(self):
		l2X=int(input("\nQuanto vale la X del secondo cerchio:"))
		l2Y=int(input("\nQuanto vale la Y del secondo cerchio:"))
		dx=0-l2X		
		dy=0-l2Y
		dist=dx**2+dy**2	
		if 	dist<=R:
			print("\nIl cerchio e' sovrapposto ad un altro cerchio\n")
			return True	
		else:
			print("\nIl cerchio non e' sovrapposto ad un altro cerchio\n")
			return False
		X1=int(input("\nInserisci una coordinata X:"))	
		Y1=int(input("\nInserisci una coordinata Y:"))	
		X2=int(input("\nInserisci una coordinata X:"))	
		Y2=int(input("\nInserisci una coordinata Y:"))	
		if X1<raggio*2 and X2<raggio*2 and Y1<dy and Y2<dy			

class Triangolo:
	def __int__(self,base=0,altezza=0):
		self.b=base
		self.h=altezza
	def calcolaArea():
		area=float((b*h)/2)
		print("\nArea:",area)		
	def calcolaPerimetro():
		perimetro=b*3
		print("\nArea:",perimetro)		

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
rett.calcolaPerimetro()
rett.sonoQuadrato()
rX = int(input("\nInserisci la coordinata x: "))
rY = int(input("\nInserisci la coordinata y: "))
R = int(input("\nInserisci il raggio"))
punto3=Cerchio(rX,rY,R)
punto3.testaCerchio()
punto3.calcolaArea()
punto3.sovrapposto()
base=int(input("\nInserisci la base"))
altezza=int(input("\nInserisci l'altezza"))
punto6=Triangolo(base,altezza)
punto6.calcolaArea()
punto6.calcolaPerimetro()

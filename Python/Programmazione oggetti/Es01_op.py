#Esempio1 Op

import math

class Punto:
	pass			#Non fa niente ma non da errore nella classe

class Rettangolo():
	pass

class Cerchio():
	pass

def Distanza(l1,l2):
	dx = l2.x-l1.x
	dy = l2.y-l1.y
	dist=dx**2+dy**2
	ris=math.sqrt(dist)
	return ris


def TrovaCentro(objRett):
  P = Punto()
  P.x = objRett.AltoSinistra.x + objRett.Larghezza/2.0
  P.y = objRett.AltoSinistra.y - objRett.Altezza/2.0
  return P 


def StampaPunto(objPunto):
  print('(' + str(objPunto.x) + ', ' + str(objPunto.y) + ')')

def testacerchio(r):
        orig=Punto()
        orig.x=0
        orig.y=0
		dist=Distanza(r.centro,orig)	
		if dist<=r.raggio:
			print("L'origine degli assi cade nel cerchio")
			return True
		else:
			print("L'origine degli assi non cade nel cerchio")
			return False

P1 = Punto()		#Costruttore: punto() ; è un costruttore perchè ha costruito un nuovo oggetto nella memoria
P1.x = 3.0			#Diventano caratteristiche specifiche dell'istanza segnata, in questo caso P1
P1.y = 4.0			#Diventano caratteristiche specifiche dell'istanza segnata, in questo caso P1

P2 = Punto()

print("\nIl valore dell'attributo y dell'oggetto P1 è",P1.y)

x = P1.x
print(x)			#stampa la variabile x non l'attributo x di P1
x=x+2
print("\nVariabile X:",x,"\nAttributo X di P1:",P1.x)
print('P1'+'(' + 'Attributo X: '+ str(P1.x)+' , '+ 'Attributo Y: ' + str(P1.y)+')')

print(P1)		#Non posso farlo; mi da il punto in cui è definito punto

StampaPunto(P1)			#Passo P1 alla funzione StampaPunto che mi stampa gli attributi x e y ma solo se sono presenti nel punto (ad esempio con P2 da errore) 

lato1=punti()
lato1.x=int(input("\nQuanto vale la X del primo lato:"))
lato1.y=int(input("\nQuanto vale la Y del primo lato:"))

lato2=punti()
lato2.x=int(input("\nQuanto vale la X del secondo lato:"))
lato2.y=int(input("\nQuanto vale la Y del secondo lato:"))

print("\nLa distanza tra i 2 punti vale",Distanza(lato1,lato2))

Rett = Rettangolo()
Rett.larghezza = 100.0
Rett.altezza = 200.0

Rett.AltoSinistra = Punto()			#rappresenta il punto più in alto a sinistra	
Rett.AltoSinistra.x = 0.0
Rett.AltoSinistra.y = 0.0 

Centro = TrovaCentro(Rett) 
print("\nIl centro vale",Centro) 

ruota=cerchio()
ruota.centro = Punto()
ruota.centro.x = int(input("\nInserisci la coordinata x"))
ruota.centro.y = int(input("\nInserisci la coordinata y"))
ruota.raggio = int(input("\nInserisci il raggio"))
testacerchio(ruota)



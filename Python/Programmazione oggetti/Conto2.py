'''Esercizio2
Creare una classe Conto in grado di permettere versamenti, prelievi e restituire il saldo.
Fare la differenza tra due conti. Segnalare un conto in rosso.


Aggiungere opzione di versamento all'apertura del conto
'''

class Conto:
	def __init__(self,c=0):
		self.setSaldo(c)
	
	def setSaldo(self,valore):
		self.__saldo=valore
		if valore<0: print("Il conto è in rosso di",valore)
		
	def getSaldo(self): return self.__saldo	
	
	def prelievo(self,soldi): self.setSaldo(self.getSaldo()-soldi)
	
	def versamento(self,soldi): self.setSaldo(self.getSaldo()+soldi)
	
	def __sub__(self,c2): return self.getSaldo()-c2.getSaldo() 
	
	def __str__(self): return "{}".format(self.getSaldo())
	
c1=Conto()
c2=Conto()
c1.prelievo(int(input("Inserire i soldi da prelevare dal conto 1: ")))
c2.versamento(int(input("\nInserire i soldi da versare nel conto 2: ")))
c1.setSaldo(50)
print("\nIl saldo del conto 1 vale",c1)
print("\nLa differenza tra conto 1 e conto 2 vale",c1-c2)


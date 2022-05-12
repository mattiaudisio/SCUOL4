class Conto:
	def __init__(self,c=0):
		self.__saldo=0
		self.versamento(c)

	def getSaldo(self):
		if self.__saldo<0: print("Il conto è in rosso di",self.__saldo)	
		return self.__saldo	
	
	def prelievo(self,soldi):
		self.__saldo=self.getSaldo()-soldi
	
	def versamento(self,soldi):
		self.__saldo=self.getSaldo()-soldi
	
	def __sub__(self,c2): return self.getSaldo()-c2.getSaldo() 
	
	def __str__(self): return "{}".format(self.getSaldo())
	
c1=Conto()
scelta=input("Scegli un opzione [0:prelevare   1:versare]:")
if scelta==0:
	c1.prelievo(int(input("Inserire i soldi da prelevare dal conto 1: ")))
else: 
	c1.versamento(int(input("\nInserire i soldi da versare nel conto 1: ")))
c2=Conto()
scelta=input("Scegli un opzione [0:prelevare   1:versare]:")
if scelta==0:
	c2.prelievo(int(input("Inserire i soldi da prelevare dal conto 2: ")))
else:
	c2.versamento(int(input("\nInserire i soldi da versare nel conto 2: ")))

c1Saldo=int(input("\nInserisci il saldo del primo conto:"))
c2Saldo=int(input("\nInserisci il saldo del secondo conto:"))
print("\nIl saldo del conto 1 vale",c1)
print("\nIl saldo del conto 2 vale",c2)
print("\nLa differenza tra conto 1 e conto 2 vale",c1-c2)

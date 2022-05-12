import random

class Motorino:
	def __init__(self,colore="",targa=" ",serbatoio=0.0,residuo=0.0,velocita=0.0,tipo=""):
		self.col=colore
		self.setTarga(targa)
		self.serb=serbatoio
		self.getResiduo(residuo)
		self.getVelocita(velocita)
		self.tip=tipo
		self.getAntifurto(False)
		self.acc=False	

	def setTarga(self,valore):
		print("\nInserisci una targa formata da 2 lettere e 4 numeri\n")
		targaIns=str(valore[0]),str(valore[1]),int(valore[2]),int(valore[3]),int(valore[4]),int(valore[5])
		if len(valore)!=6:
			self.__tar=targaIns
		else:
			print("\ntarga non valida\n")
			self.setTarga(self)

	def Accendi(self,acc=False):
		if self.setAntifurto(self)==True:
			if 	acc==False:
				print("\nMi hai acceso\n")
			else:
				print("\nSono già acceso\n")
		else:
			print("\nHai fatto partire l'antifurto\n")		

	def Spegni(self,acc=False):
		valore=self.setVelocita(self)
		if float(valore)<=20.00:
			if acc==True:
				print("\nMi hai spento\n")
			else:
				print("Non posso spegnermi 2 volte!!")	
		else:
			print("\nNon posso spegnermi se sei ha questa velocità, rallenta ancora un pò")

	def getAntifurto(self,valore):
		self.__antif=valore

	def setAntifurto(self,valore):
		return self.__antif			

	def getVelocita(self,valore):
		self.__vel=valore
		print("\nStai andando a ",valore," km\h")
		return self.__vel	

	def setVelocita(self,valore):
		if self.__res<5:
			print("\nSei in riserva\n")		
		if self.__res<=1:
			print("\nSei a secco! Vai a piedi!")
			self.Spegni(True)
		return self.__vel	

	def getResiduo(self,valore):
		self.__res=valore
		return self.__res

	def setResiduo(self,valore):
		return self.__res

	def setRifornimento(self):
		rif=999
		while rif>self.serb:
			rif=int(input("\nDi quanto vuoi rifornire: "))
		print("\nHo rifornito il motorno\n")		
		return self.__res+rif
		
	def accellera(self):
		vel=float(input("\nIndica i km\h che vuoi aggiungere: "))
		if(self.getVelocita(vel)<200):
			veloc=self.addizione(vel)
			self.getVelocita(veloc)
			numdecr=random.randint(1,8)
			self.sottrazione(numdecr)
			self.getResiduo(numdecr)
			print("stai andando a",self.setVelocita(self),"km\h e hai un residuo che vale",self.setResiduo(self))
		else:
			print("\nHai raggiunto la velocità massima, rallenta!")
	
	def addizione(self,val1):
		return self.setVelocita(self)+val1

	def sottrazione(self,val1):
		return self.setResiduo(self)-val1

	def __ge__(self,veicolo):
		if self.setVelocita(self)>=veicolo.setVelocita(veicolo):
			return True
		else:
			return False

mot1=Motorino("Viola","",45.5,5,14.5,"Suzuki")
mot1.Accendi(True)
mot1.Spegni(True)
mot1.setRifornimento()
mot1.accellera()
mot2=Motorino("Verde",37.1,7,34.1,"ducati")
print("velocita mot1 > velocita mot2:",mot1>=mot2)

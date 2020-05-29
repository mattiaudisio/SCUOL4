class CD:
	def __init__(self,titolo="",autore="",numeroBrani=0,durata=0):
		self.setTitolo(titolo)
		self.setAutore(autore)
		self.setNbrani(numeroBrani)
		self.setDurata(durata)
	def __str__(self):
		return 'il cd {} di {} ha {} brani e dura {} secondi'.format(self.getTitolo(),self.getAutore(),self.getNbrani(),self.getDurata())
	def setTitolo(self,valore):
		self.__tit=valore
	def getTitolo(self):
		return self.__tit
	def setAutore(self,valore):
		self.__aut=valore
	def getAutore(self):
		return self.__aut
	def setNbrani(self,valore):
		try:
			isinstance(valore,int)
			self.__nbra=valore
		except:
			print("Devi darmi un numero intero")
	def getNbrani(self):
		return self.__nbra
	def setDurata(self,valore):
		try:
			isinstance(valore,int)
			self.__dur=valore
		except:
			print("Devi darmi un numero intero")
	def getDurata(self):
		return self.__dur
	def comparaDurata(self,cd):
		if self.getDurata()>cd.getDurata():
			strout=format(self.getTitolo())
		else:
			strout=format(cd.getTitolo())
		return 'il cd '+strout+' ha la durata maggiore'

cd1=CD()
cd1.setTitolo("Led Zeppelin IV")
cd1.setAutore("Led Zeppelin")
cd1.setNbrani(8)
cd1.setDurata(2554)
print(cd1)
cd2=CD()
cd2.setTitolo("Educazione Sabauda")
cd2.setAutore("Willie Peyote")
cd2.setNbrani(15)
cd2.setDurata(3105)
print(cd2)
print(cd1.comparaDurata(cd2))

#Mattia Audisio

class testataGiornalistica():
	def __init__(self):
		self.__Editori=[]
		self.__ReporterJunior=[]
		self.__ReporterSenior=[]
		self.__Fotografi=[]
		self.__coppie={}
		self.__riferimentoEditor={}

	def cercaFotografo(self,nome):
		for i in len(Fotografi):
			if nome==Fotografi[i]:
				qwerty=True
			else:
				qwerty=None
		return qwerty

	def cercaEditor(self,nome):
		for i in len(Editori):
			if nome==Editori[i]:
				qwerty=True
			else:
				qwerty=None
		return qwerty

class Dipendenti(testataGiornalistica):
	def __init__(self,nome="",salario=0.00,straordinario=0):
		super().__init__()
		self.setNome(nome)
		self.setSalario(salario)
		self.setStraordinario(straordinario)

	def __str__(self):
		return "Mi chiamo {} e ho un salario di {} euro con {} euro di straordinario".format(self.getNome(),self.getSalario(),self.getStraordinario())

	def setNome(self,valore):
		self.__n=valore

	def getNome(self):
		return self.__n

	def setSalario(self,valore):
		self.__s=valore

	def getSalario(self):
		return self.__s

	def setStraordinario(self,valore):
		self.__stra=valore

	def getStraordinario(self):
		return self.__stra

	def aggiungiEditori(self):
		self.__Editori.append(self)
		print(self)

	def aggiungiReporter(self):
		if Reporter.getBenefit()=="cellulare":
			testataGiornalistica.__ReporterJunior.append(self)
			print(self)
		else:
			testataGiornalistica.__ReporterSenior.append(self)
			print(self)	

	def aggiungiFotografi(self):
		self.__Fotografi.append(self)
		print(self)	

class Editori(Dipendenti):
	def __init__(self,nome="",salario=0.00,straordinario=0,benefit=""):
		super().__init__(nome,salario,straordinario)
		self.setBenefit(benefit)

	def __str__(self):
		return "{}. sono un editor e come benefit ho una {}".format(super().__str__(),self.getBenefit())

	def setBenefit(self,valore):
		self.__b=valore

	def getBenefit(self):
		return self.__b

class Fotografi(Dipendenti):
	def __init__(self,nome="",salario=0.00,straordinario=0,benefit=""):
		super().__init__(nome,salario,straordinario)
		self.setBenefit(benefit)

	def __str__(self):
		return "{}. sono un fotografo e come benefit ho una {}".format(super().__str__(),self.getBenefit())

	def setBenefit(self,valore):
		self.__b=valore

	def getBenefit(self):
		return self.__b

class Reporter(Dipendenti):
	def __init__(self,nome="",salario=0.00,straordinario=0,benefit=""):
		super().__init__(nome,salario,straordinario)
		self.setBenefit(benefit)

	def __str__(self):
		return "{}. sono un reporter e come benefit ho una {}".format(super().__str__(),self.getBenefit())

	def formaCoppia(self):
		nomeFotografo=input("Inserisci il nome del fotografo con cui vuoi accoppiare il reporter:")
		NomeFotografo=testataGiornalistica.cercaFotografo(nomeFotografo)
		if NomeFotografo!=None:
			testataGiornalistica.__coppie[self]=nomeFotografo
		else:
			print("\nNon abbiamo nessun fotografo che si chiama così\n")

	def setBenefit(self,valore):
		self.__b=valore

	def getBenefit(self):
		return self.__b

	def riferimento(self):
		nomeEditor=input("Inserisci il nome dell'editor a cui l'editor fa riferimento:")
		NomeEditor=testataGiornalistica.cercaEditor(nomeEditor)
		if NomeEditor!=None:
			testataGiornalistica.__riferimentoEditor[self]=nomeEditor
		else:
			print("\nNon abbiamo nessun editore che si chiama così\n")

ed1=Editori("Marc",1958.00,1567,"fotocamera")
Dipendenti.aggiungiEditori(ed1)
fot1=Fotografi("Charles",1005.00,1567,"Macchina fotografica")
Dipendenti.aggiungiFotografi(fot1)
rj1=Reporter("William",256.00,456,"Cellulare")
Dipendenti.aggiungiReporter(rj1)
rs1=Reporter("Stephen",1012.00,1487,"Palamare")
Dipendenti.aggiungiReporter(rs1)

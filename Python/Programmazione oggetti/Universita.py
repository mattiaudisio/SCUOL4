import random


facolta={}
facoltaProf={}

#######################################################################################################################################################################################
class Persona():
	def __init__(self,nome="",cognome="",email=""):
		self.setNome(nome)
		self.setCognome(cognome)
		self.setEmail(email)

	def __str__(self):
		return 'Nome: {} Cognome: {} Mail: {}'.format(self.getNome(),self.getCognome(),self.getEmail())

	def setNome(self,valore):
		self.__n=valore
	
	def getNome(self):
		return self.__n	

	def setCognome(self,valore):
		self.__c=valore
	
	def getCognome(self):
		return self.__c
	
	def setEmail(self,valore):
		try:
			assert('@' in valore)
			assert('.' in valore)
			self.__e=valore
		except:
			self.setEmail(input("\nInserisci una mail che abbia una @ e un punto:"))

	def getEmail(self):
		return self.__e
	
#######################################################################################################################################################################################
class Studente(Persona):
	def __init__(self,nome="",cognome="",email="",matricola=0):
		super().__init__(nome,cognome,email)
		self.matricola=Universita.setMatricola(matricola)
		self.__dict_esami={}

	def __str__(self):
		return '{} Matricola: {}'.format(super().__str__(),Universita.getMatricola())			#con super().__str__() stampo la __str__ di Persona

	def registraEsame(self,nome="",voto=0):
		i=0
		for x in facolta.getListaEsami():
			esami.append(x.getNome())
			while i==0:
				if nome in esami:
					self.__dict_esami[nome]=voto
					i=1
				else:			
					i=0
					nome=input("Esame non esistente. Reinserire: ")
		print("\nEsame registrato\n")

	def getListaEsami(self):
		return Facolta.getListaEsami()	
	
	def getEsamiSostenuti(self):
		print("Esami sostenuti:")
		for i in self.__dict_esami.keys():
			print(i)

	def getEsitoEsami(self):
		print("Esito esami:")
		if len(self.__dict_esami.keys())>0:
			for i in self.__dict_esami.keys():
				print(i,":",self.__dict_esami[i])
		else:
			print("\nNon hai sostenuto nessun esame\n")			

#######################################################################################################################################################################################
class Professore(Persona):
	def __init__(self,nome="",cognome="",email="",ufficio="",telefono=0):
		super().__init__(nome,cognome,mail)
		self.setUfficio(ufficio)
		self.setTelefono(telefono)

	def __str__(self):
		return '{} Ufficio: {} Telefono: {}'.format(super().__str__(),self.getUfficio(),self.getTelefono())	

	def setUfficio(self,valore):
		self.__uff=valore

	def getUfficio(self):
		return self.__uff

	def setTelefono(self,valore):
		self.__tel=valore

	def getTelefono(self,valore):
		return self.__tel		

#######################################################################################################################################################################################
class Esame():
	def __init__(self,nome="",crediti=0):
		self.setNome(nome)
		self.cr=crediti

	def setNome(self,valore):
		self.__nom=valore
		
	def getNome(self):
		return self.__nom

#######################################################################################################################################################################################
class Facolta():
	def __init__(nome="",crediti=0):
		super().__init__(nome,crediti)
		self.setNome(nome)
		self.__studenti=[]
		self.__professori=[]
		self.__esami=[]

	def __str__(self):
		return 'Facolta: {}'.format(self.getNome())

	def setNome(self,valore):
		self.__n=valore
	
	def getNome(self):
		return self.__n	
	
	def AggiungiStudente(self):
		self.__studenti.append(Studente(input("Inserisci il nome:"),input("Inserisci il cognome"),input("Inserisci l'email:"),input("Inserisci il numero di matricola:")))

	def AggiungiProfessore(self):
		self.__professori.append(Professore(input("Inserisci il nome:"),input("Inserisci il cognome"),input("Inserisci l'email:"),input("Inserisci l'ufficio:"),input("Inserisci il numero di telefono")))

	def getStudenti(self):
		return self.__studenti

	def getProfessori(self):
		return self.__professori

	def getListaEsami(self):
		return self.__esami

#######################################################################################################################################################################################		
class Universita():
	def __init__(nome="",luogo="",facolta,ultima_matricola=0):
		self.setNome(nome)
		self.setLuogo(luogo)
		self.setMatricola(ultima_matricola)

	def setNome(self,valore):
		self.__n=valore
	
	def getNome(self):
		return self.__n	

	def setluogo(self,valore):
		self.__l=valore
	
	def getLuogo(self):
		return self.__l

	def setMatricola(self,valore):
		self.__matr=valore

	def getMatricola(self):
		return self.__matr

	def getStudente(self,nome="",cognome=""):
		print(Studente(nome,cognome))

	def getFacolta(self):
		print(Facolta)

	def getNomiFacolta(self):
		for i in facolta.keys():
			print(i)		

	def getListaFacolta(self):
		return len(facolta.keys())

	def iscriviStudente(nome="",cognome="",nomeFacolta=""):
		nomeCognome=print(nome," ",cognome)
		facolta[nomeFacolta]=nomeCognome	
#######################################################################################################################################################################################		

Uni1=Universita("Universita_1","Torino",facolta["Matematica",esami["A",10]],1287)
facolt1=Facolta("Informatica",esami["BC",40])
facolt1=Facolta("Biologia",esami["AS",30])
prof1=Professore("Nome1","Cognome1","NC1@mail.com","Biologia",356874569)
prof2=Professore("Nome2","Cognome2","AAAAA@mail.com","Matematica",45415485)
stud1=Studente("QQQQ","WWWW","QQQ@gmail.com",1234)
stud1.registraEsame("A",13)


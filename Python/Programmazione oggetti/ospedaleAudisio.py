#Mattia Audisio 4C

import random

class Ospedale():
	def __init__(self,nome="",luogo="",reparto):
		self.setNome(nome)
		self.setLuogo(luogo)
		self.rep=[]
		self.listaMedici=[]

	def __str__(self):
		return "Ciao. Siamo l'ospedale {} di {}".format(self.getNome(),self.getLuogo())

	def setNome(self,valore):
		self.__n=valore

	def getNome(self):
		return self.__n	

	def setLuogo(self,valore):
		self.__l=valore

	def getLuogo(self):
		return self.__l	

	def getNomeReparto(self,nome):
		for i in len(rep[]):
			if i.getNome()==nome:
				reparto=i
		try:
			return reparto
		except: 
			return None
		
	def getListaReparti():
		return self.__r

	def stipendioAnnuale(self):
		nome=input("\nInserisci il nome del medico di cui vuoi sapere lo stipendio annuale: ")
		for i in range(len(listaMedici)):
			if nome==listaMedici[i]:
				nome=listaMedici[i]
			else:
				nome=None
		if nome!=None:
			stipAnn=nome.getStipendio*12
			print("\nIl dottor ",nome," guadagna ",stipAnn," euro all'anno\n")
		else:
			print("\nNon esiste nessun dottore con quel nome")

class Persona():
	def __init__(self,nome="",cognome="",codiceFiscale="",dataNascita=""):
		self.setNome(nome)
		self.setCognome(cognome)
		self.setCFiscale(codiceFiscale)
		self.setNascita(dataNascita)

	def __str__(self):
		return "Sono {} {}, il mio codice fiscale è {} e sono nato il {}".format(self.getNome(),self.getCognome(),self.getCFiscale(),self.getNascita())	

	def setNome(self,valore):
		self.__n=valore

	def getNome(self):
		return self.__n	

	def setCognome(self,valore):
		self.__c=valore

	def getCognome(self):
		return self.__c	

	def setCFiscale(self,valore):
		self.__cf=valore

	def getCFiscale(self):
		return self.__cf

	def setNascita(self,valore):
		self.__dn=valore

	def getNascita(self):
		return self.__dn

class Paziente(Persona):
	def __init__(self,nome="",cognome="",codiceFiscale="",dataNascita="",tipologiaRicovero="",dataRicovero="",dataEmissione=""):
		super().__init__(nome,cognome,codiceFiscale,dataNascita)
		self.setTipRic(tipologiaRicovero)		
		self.setDatRic(dataRicovero)
		self.setDatEmi(dataEmissione)
	
	def __str__(self):
		return "{}. Sono stato Ricoverato per {} il {} e mi hanno dimesso il {}".format(super().__str__(),self.getTipRic(),self.getDatRic(),self.getDatEmi())

	def setTipRic(self,valore):
		self.__tr=valore

	def getTipRic(self):
		return self.__tr

	def setDatRic(self,valore):
		self.__dr=valore

	def getDatRic(self):
		return self.__dr
	
	def setDatEmi(self,valore):
		self.__de=valore

	def getDatEmi(self):
		return self.__de

class Personale(Persona):
	def __init__(self,nome="",cognome="",codiceFiscale="",dataNascita="",matricola="",livelloQualifica=0):
		super().__init__(nome,cognome,codiceFiscale,dataNascita)
		self.setMatricola(matricola)
		self.livQual=livelloQualifica

	def __str__(self):
		return "{}. Il mio codice Matricola è {} e ho un livello di qualifica {}".format(super().__str__(),self.getMatricola(),self.livQual)
		
	def setMatricola(self,valore):
		self.__m=valore
	
	def getMatricola(self):
		return self.__m
	
class Medico(Personale):
	def __init__(self,nome="",cognome="",codiceFiscale="",dataNascita="",matricola="",livelloQualifica=0,stipendioMensile=0.00):
		super().__init__(nome,cognome,codiceFiscale,dataNascita,matricola,livelloQualifica)
		self.setStipendio(stipendioMensile)		
		
	def __str__(self):
		return "{}. Come stipendio prendo {} euro al mese".format(super().__str__(),self.stipendio)

	def setStipendio(self,valore):
		self.__st=valore

	def getStipendio(self):
		return self.__st



class Infermiere(Personale):
	def __init__(self,nome="",cognome="",codiceFiscale="",dataNascita="",matricola="",livelloQualifica=0,mansione=""):
		super().__init__(nome,cognome,codiceFiscale,dataNascita,matricola,livelloQualifica)
		self.mans=mansione

	def __str__(self):
		return "{}. la mia mansione è {}".format(super().__str__(),self.mans)

class Reparto():
	def __init__(self,nome="",nletti=0):
		self.setNome(nome)
		self.letti=nletti
		self.listaPersonale=[]
		self.listaPazienti=[]	

	def setNome(self,valore):
		self.__n=valore

	def getNome(self):
		return self.__n

	def registraPaziente(self):
		if letti!=0:
			Paz=Paziente(input("\nInserisci il nome del paziente:"),input("\nInserisci il cognome del paziente:"),input("\nInserisci il codice fiscale del paziente:"),input("\nInserisci la data di del paziente:"),input("\nInserisci la tipologia di recupero del paziente:"),input("\nInserisci la data di ricovero del paziente:"),input("\nInserisci la data di dimissione del paziente:"))
			listaPazienti.append(Paz)			
		else:
			print("\nI posti sono esauriti, devi aspettare per il ricovero\n")

	def registraPersonale(self,person):
		if medic.getMatricola()<=3:
			listaPersonale.append(person)
		else:
			reparto.registraPersonale(input("Inserisci un livello di qualifica valida:"))	
	
	def registraMedici(self,medic):
		if medic.getMatricola()<=3:
			listaMedici.append(medic)
		else:
			reparto.registraMedici(input("Inserisci un livello di qualifica valida:"))	

	def informazioniPazienti(self):
		for i in range(len(listaPazienti)):
			print("Paziente ",i,":")
			print(listaPazienti[i])
			print("\n")

	def elencoPersonale(self):
		for i in range(listaPersonale):
			print("Nome: ",listaPersonale[i].getNome(),"\tCognome:",listaPersonale[i].getCognome(),"\tMatricola:",listaPersonale[i].getMatricola())

	def stipendioMensReparto(self):
		stipRep=0
		for i in range(len(listaMedici)):		
			stipRep=stipRep+listaMedici[i].getStipendio()
		stipRep=StipRep/len(listaMedici)
		print(StipRep)

#MAIN
osp1=Ospedale("San Carlo","Torino",[Reparto("Medicina",random.randint(25)),Reparto("Chirurgia",random.randint(25)),Reparto("Ostetricia",random.randint(25)),Reparto("Ortopedia",random.randint(25))])
scelta=1
while scelta!=0:
	scelta=int(input("0. Esci\n1. Assegnia un paziente a un reparto\n2. Assegnia un medico\n3. Assegnia un infermiere\n4. operazioni in reparto\nScelta:"))
	if scelta==0:
		print("\nProgramma terminato\n")
	elif scelta==1:
		paz1=Paziente(input("\nInserisci il nome del paziente:"),input("\nInserisci il cognome del paziente:"),input("\nInserisci il codice fiscale del paziente:"),input("\nInserisci la data di del paziente:"),input("\nInserisci la tipologia di recupero del paziente:"),input("\nInserisci la data di ricovero del paziente:"),input("\nInserisci la data di dimissione del paziente:"))
		reparto=Ospedale.getNomeReparto(input("Reparto:"))
		if reparto!=None:
			reparto.registraPaziente(paz1)
		else:
			print("\nReparto non esistente")
	elif scelta==2: 
		med1=Medico(input("\nInserisci il nome del Medico:"),input("\nInserisci il cognome del Medico:"),input("\nInserisci il codice fiscale del Medico:"),input("\nInserisci la data  del Medico:"),input("\nInserisci la matricola del Medico:"),input("\nInserisci la qualifica professionale del Medico [Le qualifiche vanno da 0 a 3]:"),input("\nInserisci lo stipendio mensile del Medico:"))
		reparto=Ospedale.getNomeReparto(input("Reparto:"))
		if reparto!=None:
			reparto.registraPersonale(med1)
			Ospedale.registraMedici(med1)					#Metto medici in due liste così mi è più facile calcolare lo stipendio annuale e lo stipendio mensile del reparto
		else:
			print("\nReparto non esistente")
	elif scelta==3:
		inf1=Infermiere(input("\nInserisci il nome dell'infermiere:"),input("\nInserisci il cognome dell'infermiere:"),input("\nInserisci il codice fiscale dell'infermiere:"),input("\nInserisci la data di nascita dell'infermiere:"),input("\nInserisci la matricola dell'infermiere:"),input("\nInserisci la qualifica professionale dell'infermiere [Le qualifiche vanno da 0 a 3]:"),input("\nInserisci la mansione dell'infermiere:"))
		reparto=Ospedale.getNomeReparto(input("Reparto:"))
		if reparto!=None:
			reparto.registraPersonale(inf1)
		else:
			print("\nReparto non esistente")
	elif scelta==4:
		sceltamenu2=1
		while sceltamenu2!=0:
			sceltamenu2=int(input("\n0.Esci\n1. Registra un nuovo paziente\n2.Visualizza la lista del personale che lavora al suo interno\n3. Visualizza le informazioni dei pazienti ricoverati\n4.calcola lo stipendio annuale di un medico\n5.Calcola lo stipendio medio di un reparto\nScelta:"))
			if scelta==0:			
				print("\nSei ritornato al menu principale\n")
			elif scelta==1:
				reparto=Ospedale.getNomeReparto(input("Reparto:"))
				if reparto!=None:
					reparto.registraPaziente()
				else:
					print("\nReparto non esistente")				
			elif scelta==2:
				reparto=Ospedale.getNomeReparto(input("Reparto:"))
				if reparto!=None:
					reparto.elencoPersonale()				
				else:
					print("\nReparto non esistente")
			elif scelta==3:
				reparto=Ospedale.getNomeReparto(input("Reparto:"))
				if reparto!=None:
					reparto.informazioniPazienti()				
				else:
					print("\nReparto non esistente")
			elif scelta==4:
				Ospedale.stipendioAnnuale()				
			elif scelta==5:
				reparto=Ospedale.getNomeReparto(input("Reparto:"))
				if reparto!=None:
					reparto.stipendioMensReparto()				
				else:
					print("\nReparto non esistente")
			else:
				print("\nInserimento errato\n")	
	else:
		print("\nInserimento errato\n")

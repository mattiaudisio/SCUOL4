#Matteo Fasano 4C

def tryIntero(a,s):
	esci=1
	while esci==1:
		try: 
			n=int(a)
			esci=0
		except:
			esci=1
			a=input("Errore. Reinserire %s: " %s)		
	return n

class Persona():

	def __init__(self, nome, cognome, mail):
		self.setNome(nome)
		self.setCognome(cognome)
		self.setMail(mail)
	
	def __str__(self): return "%s, %s, %s" %(self.getNome(),self.getCognome(),self.getMail())	
		
	def setNome(self,v): self.__nome=v	
	
	def getNome(self): return self.__nome
	
	def setCognome(self,v): self.__cognome=v	
	
	def getCognome(self): return self.__cognome
	
	def setMail(self,v): 
		try:
			assert('@' in v)
			assert('.' in v)
			self.__mail=v
		except: self.setMail(input("Inserire mail valida: "))
		
	def getMail(self): return self.__mail	
	
class Studente(Persona):

	def __init__(self,nome,cognome,mail,matricola):
		super().__init__(nome,cognome,mail)
		self.setMatricola(matricola)
		self.__dict_esami={}
			
	def __str__(self): return "{} {}" .format(super().__str__(),self.getMatricola())	
			
	def setMatricola(self,v): self.__matricola=v
	
	def getMatricola(self): return self.__matricola		
	
	def registraEsame(self,nome,voto,facolta): 
		voto=tryIntero(voto,"voto")
		esci=0
		esami=[]
		for x in facolta.getListaEsami(): esami.append(x.getNome())
		while esci==0:
			if nome in esami:	
				self.__dict_esami[nome]=voto
				esci=1
			else: 
				esci=0
				nome=input("Esame non esitente. Reinserire: ")
	
	def getListaEsami(self,facolta): return facolta.getListaEsami()
	
	def getEsitoEsami(self): 
		esito=""
		for x in self.__dict_esami.keys(): esito+=str(x)+" "+str(self.__dict_esami[x])+", "
		if len(esito)>0: return "Gli esiti degli esami sono: %s\n" % esito[:len(esito)-2]
		else: return "Non ci sono esiti\n"
		
	def getEsamiSostenuti(self): 
		esami=""
		for x in self.__dict_esami.keys(): esami+=str(x)+", "
		if len(esami)>0: return "Gli esami sostenuti sono: %s\n" % esami[:len(esami)-2]
		else: return "Non ci sono esami sostenuti\n"
	
class Professore(Persona):
	
	def __init__(self,nome,cognome,mail,ufficio,telefono):
		super().__init__(nome,cognome,mail)
		self.setUfficio(ufficio)
		self.setTelefono(telefono)
		
	def __str__(self): return "{} {} {}" .format(super().__str__(),self.getUfficio(),self.getTelefono())		
		
	def setUfficio(self,v): self.__ufficio=v	
	
	def getUfficio(self): return self.__ufficio
	
	def setTelefono(self,v): self.__telefono=v	
	
	def getTelefono(self): return self.__telefono	
	
class Facolta():
	
	def __init__(self,nome,esami): 
		self.setNome(nome)
		self.__studenti=[]
		self.__professori=[]
		self.setEsami(esami)
		
	def __str__(self): return "%s, Esami: \n%s" %(self.getNome(),self.getStrEsami())
		
	def setNome(self,v): self.__nome=v
	
	def getNome(self): return self.__nome	
	
	def setEsami(self,v): self.__esami=v
	
	def getListaEsami(self): return self.__esami
	
	def getStrEsami(self):
		esami=self.getListaEsami()
		stringa=""
		for x in esami:	stringa+=str(x)+"\n"
		return stringa
	
	def aggiungiStudente(self,nome,cognome,mail,matricola): self.__studenti.append(Studente(nome,cognome,mail,matricola))
	
	def aggiungiProfessore(self,nome,cognome,mail,ufficio,telefono): self.__professori.append(Professore(nome,cognome,mail,ufficio,telefono)) 
	
	def getStudenti(self): return self.__studenti
	
	def getProfessori(self): return self.__professori
	
class Universita():
	
	def __init__(self,nome,luogo,facolta,ultimaMatricola=0):
		self.setNome(nome)
		self.setLuogo(luogo)
		self.setUltimaMatricola(ultimaMatricola)
		self.setFacolta(facolta)
	
	def __str__(self): return "%s, %s, Ultima Matricola: %s, Facolta:\n\n%s " %(self.getNome(),self.getLuogo(),self.getUltimaMatricola(),self.getStrFacolta())
	
	def setFacolta(self,v): self.__facolta=v
	
	def getStudente(self,nome,cognome):
		for x in self.getListaFacolta():
			for a in x.getStudenti(): 
				if a.getNome()==nome and a.getCognome()==cognome: studente=a
		try: return studente
		except: return None
					
	def getStrFacolta(self):
		esami=self.getListaFacolta()
		stringa=""
		for x in esami:	stringa+=str(x)+"\n"
		return stringa[:len(stringa)-2]
	
	def getFacolta(self,nome):
		for x in self.getListaFacolta():
			if x.getNome()==nome: facolta=x
		try: return facolta
		except: return None
			
	def getListaFacolta(self): return self.__facolta	
	
	def getNomiFacolta(self):
		facolta=""
		for x in self.getListaFacolta(): facolta+=str(x.getNome())+", "
		return "Facolta: %s" % facolta[:len(facolta)-2]		
		
	def iscriviStudente(self,nome,cognome,nomeFacolta):
		if nomeFacolta in self.getNomiFacolta(): 
			for x in self.getListaFacolta(): 
				if x.getNome()==nomeFacolta: x.aggiungiStudente(nome,cognome,input("Mail: "),input("Matricola: ")) 
		else: self.iscriviStudente(nome,cognome,input("Facolta non esistente. Reinserire: "))	
		
	def setNome(self,v): self.__nome=v
	
	def getNome(self): return self.__nome		
	
	def setLuogo(self,v): self.__luogo=v
	
	def getLuogo(self): return self.__luogo
	
	def setUltimaMatricola(self,v): self.__ultimaMatricola=v
	
	def getUltimaMatricola(self): return self.__ultimaMatricola

class Esame():
	
	def __init__(self,nome,crediti):
		self.setNome(nome)
		self.setCrediti(crediti)
		
	def __str__(self): return "%s, Crediti: %d" %(self.getNome(),self.getCrediti())
		
	def setNome(self,v): self.__nome=v
	
	def getNome(self): return self.__nome
	
	def setCrediti(self,v): 
		self.__crediti=tryIntero(v,"crediti")
	
	def getCrediti(self): return self.__crediti	
		
universita=Universita("Uni1","Torino",[Facolta("Chimica",[Esame("A",30),Esame("B",30)]),Facolta("Fisica",[Esame("C",30),Esame("D",30)]),Facolta("Design",[Esame("E",30),Esame("F",30)])])
op=1
while op!='0':
	op=input("0. Esci\n1. getStudente\n2. getFacolta\n3. getNomiFacolta\n4. getListaFacolta\n5. IscriviStudente\n6. metodi facolta\n7. metodi studenti\nInserisci opzione:")
	if op=='0': print("\nFine")
	elif op=='1': 
		print("\nStudente da cercare:")
		studente=universita.getStudente(input("Nome: "),input("Cognome: "))
		if studente==None: print("\nStudente non esistente\n")	
		else: print("Studente: ",studente,"\n")
	elif op=='2':	
		print("\nFacolta da cercare:")
		facolta=universita.getFacolta(input("Nome: "))
		if facolta==None: print("\nFacolta non esistente\n")
		else: print(facolta)
	elif op=='3': print("\n"+universita.getNomiFacolta()+"\n")
	elif op=='4': 
		print("")
		for x in universita.getListaFacolta(): print(x)
	elif op=='5':
		print("\nStudente da iscrivere:")
		universita.iscriviStudente(input("Nome: "),input("Cognome: "),input("Nome Facolta: "))
		print("")
	elif op=='6':
		print("")
		op2=1
		facolta=universita.getFacolta(input("\nFacolta: "))
		if facolta==None: print("\nFacolta non esistente\n")
		else:
			while op2!='0': 
				op2=input("0. Esci\n1. aggiungiStudente\n2. aggiungiProfessore\n3. getStudenti\n4. getProfessori\n5. getListaEsami\nInserisci opzione:")
				if op2=='0': print("\nFine\n")
				elif op2=='1': 
					print("\nStudente da aggiungere: ")
					facolta.aggiungiStudente(input("Nome: "),input("Cognome: "),input("Mail: "),input("Matricola: "))
					print("")
				elif op2=='2':	
					print("\nProfessore da aggiungere: ")
					facolta.aggiungiProfessore(input("Nome: "),input("Cognome: "),input("Mail: "),input("Ufficio: "),input("Telefono: "))
					print("")
				elif op2=='3':
					print("")
					if facolta.getStudenti()!=[]: 
						for x in facolta.getStudenti(): print(x)
					else: print("Non ci sono studenti")
					print("")
				elif op2=='4': 
					print("")
					if facolta.getProfessori()!=[]:
						for x in facolta.getProfessori(): print(x)
					print("")
				elif op2=='5':
					print("")
					if facolta.getListaEsami()!=[]:
						for x in facolta.getListaEsami(): print(x)
					print("")
				else: print("Opzione non valida\n")	
	elif op=='7':
		print("\nStudente: ")
		op2=1
		studente=universita.getStudente(input("Nome: "),input("Cognome: "))
		facolta=universita.getFacolta(input("Nome Facolta: "))
		if studente==None or facolta==None: print("\nStudente o Facolta non valida\n")
		else:
			while op2!='0': 
				op2=input("0. Esci\n1. registraEsame\n2. getListaEsami\n3. getEsamiSostenuti\n4. getEsitoEsami\nInserisci opzione: ")
				if op2=='0': print("\nFine\n")
				elif op2=='1': 
					print("\nEsame")
					studente.registraEsame(input("Nome: "),input("Voto: "),facolta)
					print("")
				elif op2=='2':	
					print("")
					if facolta.getListaEsami()!=[]:
						for x in studente.getListaEsami(facolta): print(x)
					print("")
				elif op2=='3': print("\n"+studente.getEsamiSostenuti())
				elif op2=='4': print("\n"+studente.getEsitoEsami())
				else: print("Opzione non valida\n")
	else: print("Opzione non valida\n")

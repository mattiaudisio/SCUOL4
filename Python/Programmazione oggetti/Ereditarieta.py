class Felino:
	def __init__(self):
		print("Sono un felino")

	def comeTichiami(self):
		print("Sono un felino e mi chiamo Gnappy")

	def graffia(self):
		print("Ti graffio!")

class Gatto(Felino):		#questa classe gatto eredita il costruttore e i metodi di felino perchè è un figlio di Felino
	def __init__(self):
		super().__init__()			#con super() eredito dalla classe padre --> OVERRIDE
		print("Sono un gatto")

	def comeTichiami(self):
		print("Mi chiamo Felix")

	def scappa(self):
		print("Che paura, scappo!")
	
micio=Gatto()
micio.comeTichiami()
micio.graffia()	
micio.scappa()

print("____________________________________________________________________________")

class Persona:
	def __init__(self,nome,cognome,eta,residenza):
		self.n=nome
		self.c=cognome
		self.e=eta
		self.r=residenza

	def schedaPersonale(self):				
		scheda=f"""												
Nome:{self.n}
Cognome:{self.c}
Eta:{self.e}
Residenza:{self.r}"""				#mi da in output quello che scrivo così come l'ho scritto
#la f""" """ posso anche metterla contro il bordo perchè non mi da errore
		return scheda

class Studente(Persona):
	def __init__(self,nome,cognome,eta,residenza, matricola):	
		super().__init__(nome,cognome,eta,residenza)
		self.mat=matricola
	
	def schedaPersonale(self):
		scheda=f"""
Matricola:{self.mat}\n"""
		return super().schedaPersonale()+scheda				#prende la scheda personale del madre e gli aggiunge scheda che ha matricola
	

pers=Persona('aaa','bbb','25','Verzuolo')
print(pers.schedaPersonale())
stud1=Studente("qqq","yyy","30","Cuneo","qwerty")
print(stud1.schedaPersonale())

print("____________________________________________________________________________\n")

class Persona:
	def __init__(self,nome,cognome,eta,residenza):
		self.n=nome
		self.c=cognome
		self.e=eta
		self.r=residenza

	def __str__(self):				
		return f"""Nome:{self.n}\nCognome:{self.c}\nEta:{self.e}\nResidenza:{self.r}"""

class Studente(Persona):
	def __init__(self,nome,cognome,eta,residenza, matricola):	
		super().__init__(nome,cognome,eta,residenza)
		self.mat=matricola
	
	def __str__(self):
		return super().__str__()+f"""\nMatricola:{self.mat}\n"""

pers=Persona('aaa','bbb','25','Verzuolo')
print(pers)
stud1=Studente("qqq","yyy","30","Cuneo","qwerty")
print(stud1)

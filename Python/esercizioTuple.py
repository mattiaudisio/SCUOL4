#Mattia Audisio 4C
giorni={1:'primo',2:'secondo',3:'terzo',4:'quarto',5:'quinto',6:'sesto',7:'settimo',8:'ottavo',9:'nono',10:'decimo',11:'undicesimo','12':'dodicesimo',13:'tredicesimo',14:'quattordicesimo',15:'quindicesimo',16:'sedicesimo',17:'diciassettesimo',18:'diciottesimo',19:'diciannovesimo','20':'ventesimo',21:'ventunesimo',22:'ventiduesimo',23:'ventitreesimo',24:'ventiquattresimo',25:'venticinquesimo',26:'ventiseiesimo',27:'ventisettesimo',28:'ventottesimo',29:'ventinovesimo',30:'trentesimo',31:'trentunesimo'}
mesi={1: 'gennaio',2: 'febbraio',3: 'marzo',4: 'aprile',5: 'maggio',6: 'giugno',7: 'luglio',8: 'agosto',9: 'settembre',10: 'ottobre',11: 'novembre',12: 'dicembre'}
date=[]
dateout=[]

def inserisci():
	data='ciao'
	while data=='stop':
		data=input("Inserisci una data (giorno/mese/anno o giorno-mese-anno) [stop per uscire]:")
		if data!='stop': 
			date.append(data)	

def trasforma():
	for i in range(len(date)):
		if '/' in date[i]:
			giorno,mese,anno=date[i].split('/')
		else:
			giorno,mese,anno=date[i].split('-')
		dateout.append((giorni[int(giorno)],mesi[int(mese)],int(anno)))

inserisci()
trasforma()
print(dateout)

import json

data = json.load(open("dati.json")) #caricamento

print(data["mappe"])                     	#ritorna una lista contenente due dizionari
print(data["mappe"][0]["id"])            	#ritorna la stringa "01"
data["mappe"][1]["cognome"]= "provacogn"	#setto un nuovo attributo 'cognome' al secondo elemento (dizionario) della lista 'mappe'
print(data["dispositivo"]["parametri"])  	#ritorna un dizionario contenente le chiavi p1, p2 e p3

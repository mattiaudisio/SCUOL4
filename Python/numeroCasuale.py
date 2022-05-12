#Mattia Audisio

import random								#importa la funzione random
random.seed(

tentativi=0

print("Pensa ad un numero ed io dovro' indovinarlo\n")
print("Scrivi indovinato se ho indovinato, scrivi grande se il tentativo e' troppo grande, scrivi piccolo se il tentativo e' troppo piccolo\n")
numero=random.randint(1, 100)
print("Il numero da te pensato e'",numero)
parere=str(parere)
tentativi=tentativi+1
while parere!= 'indovinato':
			if parere == grande:
					numero=random.randint(1, (numero-4))
					print("Il numero da te pensato e'",numero)
					parere=str(parere)
			elif parere == piccolo:					
					numero=random.randint(1, (numero+4))
					print("Il numero da te pensato e'",numero)
					parere=str(parere)
			else:
					print("Ho impiegato",tentativi," per indovinare il numero")
					

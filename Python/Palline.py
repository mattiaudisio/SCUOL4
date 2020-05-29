#Mattia Audisio 4C

import random								#importa la funzione random
random.seed()

a=0
cont1=("")
cont2=("")
cont3=("")
cont4=("")
cont5=("")
estrazioni=int(input("Inserisci il numero di estrazioni che vuoi fare:"))
while a!=estrazioni:
	numero=random.randint(1, 5)
	if numero==1:
		cont1=cont1+"*"
	elif numero==2:		
		cont2=cont2+"*"
	elif numero==3:		
		cont3=cont3+"*"
	elif numero==4:		
		cont4=cont4+"*"
	else:
		cont5=cont5+"*"
	a=a+1
print("\n")
print("Numero di estrazioni:",estrazioni)
print("Numero 1 --> ",cont1,"\nNumero 2 --> ",cont2,"\nNumero 3 --> ",cont3,"\nNumero 4 --> ",cont4,"\nNumero 5 --> ",cont5)	

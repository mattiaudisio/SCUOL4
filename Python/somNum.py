#somma dei numeri dall'utente finchè non scrive 0

somma=0
num=1
while num != 0:
	print("valore somma:",somma)
	num=int(input("Inserisci un numero [0 per uscire]-->"))		#trasformo in intero il valore inserito
	somma=somma+num
print("La somma finale vale",somma)

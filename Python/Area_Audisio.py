#Mattia Audisio

def quadrato(Lunghezza):
	Area=Lunghezza*4
	print("Area:",Area)

def rettangolo(Lunghezza,Altezza):
	Area=(Lunghezza*Altezza)
	print("Area:",Area)

def	cerchio(Lunghezza):
	Area=((3.14*Lunghezza)*(3.14*Lunghezza))/2
	print("Area:",Area)

Lunghezza = float(input("Lunghezza:"))
Altezza = float(input("ALtezza:"))
print("- Premi 1 per calcolare l'area del quadrato")
print("- Premi 2 per calcolare l'area del rettangolo")
print("- Premi 3 per calcolare l'area del cerchio")
print("- Premi 0 per uscire")
scelta=input("Scelta--> ")
while scelta!='0':	
	if scelta=='1':
		quadrato(Lunghezza)
	elif scelta=='2':
		rettangolo(Lunghezza,Altezza)
	elif scelta=='3':
		cerchio(Lunghezza)
	else: 
		print("\nNumero non valido\n")
	scelta=input("Scelta--> ")

#richiesti 20 numeri all'utente, contare e sommare i numeri pari,contare e moltiplicare i numeri dispari.
#Visualizzare a video i due totali e dire se e' maggiore la presenza di numeri pari,dispari o se sono stati inseriti in quantita' uguale

a=0
numpari=0
numdisp=0
somma=0
molt=1
while a!=20:
	num=input("Inserisci un numero: ")
	num=int(num)
	if (num%2)==0:
		numpari=numpari+1				
		somma= somma+num
	else:
		numdisp=numdisp+1				
		molt= molt*num
	a=a+1
print("Numeri pari:",numpari,"\nNumeri dispari:",numdisp,"\nSomma numeri pari:",somma,"\nMoltiplicazione numeri dispari:",molt)
if numpari > numdisp:
	print("\nCi sono più pari che dispari")		
else:
	print("\nCi sono più dispari che pari")		
if numpari==numdisp:
	print("\nI numeri pari e i numeri dispari sono stati inseriti in quantità uguale")

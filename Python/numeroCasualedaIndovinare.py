print("Caro utente, pensa un numero da 1 a 100, e io provo a indovinarlo")

indovinato = False
tentativi = 0

i = 1
f = 100

while not indovinato:

tentativo = (i+f)//2
tentativi += 1
r = input("E' "+ str(tentativo) +"?: ")
if 'piccolo' in r:
	i = tentativo +1
elif 'grande' in r:
	f = tentativo -1
elif 'indovinato' in r:
	indovinato = True
	print("Indovinato in", tentativi, "tentativi")
else:
	r = input("E' "+ str(tentativo) +"?: ")
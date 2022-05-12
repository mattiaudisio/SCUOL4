#!/usr/bin/env python3

#Questo e' un commento
#scrivere nome utente ed eta'
#chiedere un numero e moltiplicarlo per 6

nome=input("Come ti chiami?")
print(nome)
eta=input("Dimmi la tua eta'")
print(eta)
eta=int(eta)
if eta>=18:
	print("Sei maggiorenne")
else:
	print("Sei minorenne")
	

num1=input("Inserisci un numero")
num1=int(num1)
num1=num1*6
print(num1)
num2=input("Inserisci un altro numero")
num2=int(num2)
num2*=5
print(num2)


print("Finito\n")

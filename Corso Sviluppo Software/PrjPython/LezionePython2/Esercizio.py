import random


def stringaDizionari(stringa):
    dizionario = {}
    for var in range(0, len(stringa)):
        if var in dizionario.keys():
            dizionario[var] = dizionario[var] + 1
        else:
            dizionario[var] = 1
    for var in dizionario.keys():
        print("Lettera: ", var, "\tNumero: ", dizionario[var])


listaNum = []
i = 0
somma = 0
while i < 100:
    listaNum.append(i + 1)
    i = i + 1
for num in listaNum:
    somma = somma + num
print(somma)
##########################################
maggiore = 0
for num in listaNum:
    if num > maggiore:
        maggiore = num

print("Numero maggiore:", maggiore)
##########################################
for num in listaNum:
    if num % 2 == 0:
        print(num)
##########################################
listaNum.reverse()
for num in listaNum:
    print(num)
##########################################
listaAsterischi = [2, 4, 6, 8, 10]
for n in listaAsterischi:
    print('*' * n)
##########################################
listaString = []
numeroStringhe = input('Quante stringhe vuoi inserire: ')
i = 0
while i < int(numeroStringhe):
    string = input('inserisci una stringa: ')
    listaString.append(str(string))
    i = i + 1
for string in listaString:
    print(len(string))
##########################################
stringaDizionari(str(input("Inserisci una frase per il dizionario: ")))
##########################################
stop = True
while stop:
    dado1 = random.randrange(1, 6)
    dado2 = random.randrange(1, 6)
    print("Dado 1:", dado1)
    print("Dado 2:", dado2)
    if dado1 == dado2:
        print("Sono usciti due numeri uguali")
        stop = False
##########################################
i = 0
a = " *"
while i < 10:
    print(a)
    a = a + '*'
    i = i + 1

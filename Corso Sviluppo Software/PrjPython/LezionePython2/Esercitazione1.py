nome = 'Mattia'
Nome = 'Mattia'

if nome == 'Mattia':
    print('Nome: '+nome)
#   print('Quasi Fine if')

    print('Fine if')

print('il programma continua')
######################################################################
print('il mio programma')
print(4)
print(4*2)
operatore1 = input('Inserisci valore 1: ')
if int(operatore1) > 10:
    print(operatore1 + ' è maggiore di 10')
elif int(operatore1) < 5:
    print(operatore1 + ' è minore di 5')
else:
    print(operatore1 + ' è minore di 10')

operatore2 = input('Inserisci valore 2: ')
print(operatore1 + operatore2)
print(int(operatore1) + int(operatore2))
######################################################################
listAnimali = ['Cane', 'Gatto', 'Pesce']
print(listAnimali)
print(listAnimali[0])
print(listAnimali[1])
print(listAnimali[2])
listAnimali.append('Topo')  #Aggiunge alla lista
print(listAnimali)
print(listAnimali[0])
print(listAnimali[1])
print(listAnimali[2])
print(listAnimali[3])
listAnimali.pop(0)          #Elimina dalla lista
print(listAnimali[0])
print(listAnimali[1])
print(listAnimali[2])

for animale in listAnimali:
    print(animale)

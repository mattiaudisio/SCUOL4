stringa = input('inserisci numero: ')
try:
    numero = int(stringa)
except ValueError:
    print('errore di conversione!')

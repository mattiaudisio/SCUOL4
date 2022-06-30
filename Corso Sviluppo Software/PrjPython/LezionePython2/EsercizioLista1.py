# inserisce una lista di 5 nomi e li stampa in output

cnt = 0
listaNomi = []
fineCiclo = True
numeroNomi = input('Quanti nomi vuoi inserire: ')
while cnt < int(numeroNomi) and fineCiclo:
    nome = str(input("Inserisci un nome: "))
    if nome != " ":
        fineCiclo = False
    else:
        listaNomi.append(nome)
        cnt = cnt + 1

print("\nEcco l'elenco dei nomi che hai inserito:")
for nomi in listaNomi:
    print(nomi)

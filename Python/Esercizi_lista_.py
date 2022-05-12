# Mattia Audisio
# 1) Generare una lista contenente 5 volte la parola "ciao"															
# 2) Stamparla																										
# 3) Sostituie il valore di mezzo della lista con "centro"															
# 4) Estrarre la sottolista che inizia con l'elemento "centro" fino all'ultimo della lista
# 5) Duplicare la lista e modificare il penultimo elemento con il numero 3
# 6) Stampare entrambe le liste per assicurarsi che la lista originale non contenga il numero 3



lista=["ciao"]*5
print(lista)
lista[len(lista)//2]="centro"
print(lista)
print(lista[lista.index("centro"):])						# variabile.index prende la metà della variabile
lista1=lista[:]
lista1[-2]=3
print("lista =",lista)
print("lista1 =",lista1)

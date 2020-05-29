#Mattia Audisio 4C

lista=[]
scelta=1
print("\n1. Stampa la lista\n2. Aggiungi un elemento alla lista\n3. Cancella un elemento dalla lista\n4. Modifica un elemento dalla lista\n5. Ordina la lista facendo scegliere all'utente se in modo crescente o decrescente\n6. Stampa il grafico oppure Stampa la lista al contrario usando gli indici negativi\n7. Inserisci un elemento nella lista in una posizione scelta dall'utente\n8. Conta le occorrenze di un elemento della lista\n0. Ripulisci la lista\n9. Esci")
while scelta!="9":
	scelta=input("Scelta -->")
	if scelta=='1':
		print(lista)
	elif scelta=='2':
		elemento=input("Cosa vuoi inserire nella lista -->")
		lista[-1]=elemento
		print(lista)
	elif scelta=='3':
		 print(lista)
		 elemento=input("Quale elemento vuoi eliminare dalla lista-->");			
		 print lista.remove('elemento')		
	elif scelta=='4':
		var=input("\nInserisci l'elemento da modificare-->")
		num=lista.count(var)
		for i=0; i<range(0,num):
				lista[lista.index(dato)]=var				
	elif scelta=='5':
			metodo=input("Vuoi ordinare la lista in modo crescente o in modo decrescete -->")
			if metodo==crescente
					print list.sort()
			else:
					print list.sort(::-1)
	elif scelta=='6':
		print("")
	elif scelta=='7':
		valore=input("Che valore vuoi inserire-->")
		posizione=input("in che posizione")
		risultato = lista.insert(posizione, valore)
	elif scelta=='7':
		dato=lista.count(input("\nQuale elemento vuoi contare-->"))
		print("\nL'elemento e' ripetuto",dato,"volte")	
	elif scelta=='0':
		 lista.clear()
		 print("\nLista ripristinata\n")	
	else:
		 print("\nInserimento errato\n")
print("\nSei uscito dal programma");	

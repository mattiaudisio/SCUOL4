nome=input("Inserisci il nome del prodotto --> ")
print(nome)
prezzo=input("Inserisci il prezzo del prodotto --> ")
prezzo=float(prezzo)
if prezzo>3000:
	prezzo=prezzo-((prezzo/100)*6)
pagamento=input("Il pagamento avviene in contanti [S per si', N per no] --> ") 		
if pagamento=='S':
	prezzo=prezzo-((prezzo/100)*2)
prezzo=str(prezzo)+"€"
print("Per il prodotto",nome,"devi pagare",prezzo)

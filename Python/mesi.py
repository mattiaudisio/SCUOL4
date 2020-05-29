scelta=int(input("Che mese(1-12)? "))
mesi=['gennaio','febbraio','marzo','aprile','maggio','giugno','luglio','agosto','settembre','ottobre','novembre','dicembre']
if 1 <= scelta <= 12:
	print("Il mese e'",mesi[scelta-1])

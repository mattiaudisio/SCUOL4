#Mattia Audisio 4C

def frequenza(stringa):
	caratteri={}
	for carattere in stringa:
		if carattere in caratteri: caratteri[carattere]+=1
		else: caratteri[carattere]=1
	return caratteri
	
stringa=str(input("\nInserisci una stringa:"))
c=frequenza(stringa)
print(c)

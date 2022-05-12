import random
campo=[]

def Crea():
	dim=6
	mine=0
	a=0
	b=0
	while dim!=0:
		dim=int(input("Inserisci la dimensione:"))
	while mine!=dim:
		mine=int(input("Inserisci il numero di mine:"))
	for i in range(0,dim):
		campo.append((a,b))
		dizioPos[campo[(i-1)]]='#'
		b=b+1
		if(i%dim==0): 
			a=a+1
		if(b%(dim+1)==0):
			b=1				
	
	
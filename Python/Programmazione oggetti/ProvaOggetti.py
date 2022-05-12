#Mattia Audisio 4C

def input_number(message,massimo,accept_float=False):		#VUOLE accept_float=False ALLA FINE	
		while(True):
			if massimo==0:
				massimo=int(input("\nInserisci il numero massimo: "))
			v=int(input(message))
			try:
				if accept_float:
					n=float(v)
				else:
					if v>massimo:
						n=10/0
					return n					
			except ZeroDivisionError as err:
				print("\nSembra che tu non abbia inserito un numero valido...")

k=input_number("\nInserisci un numero [se non devi dichiarare il massimo, il massimo vale 20]: ",20,True)
print("\n",k, type(k))

print("\nCaso con solo message\n")
k=input_number("\nInserisci un numero[se non devi dichiarare il massimo, il massimo vale 20]: ",0)
print("\n",k, type(k))

print("\nCaso senza True message\n")
k=input_number("\nInserisci un numero [se non devi dichiarare il massimo, il massimo vale 20]: ",20)
print("\n",k, type(k))

print("\nCaso senza massimo\n")
k=input_number("\nInserisci un numero [se non devi dichiarare il massimo, il massimo vale 20]: ",True)
print("\n",k, type(k))

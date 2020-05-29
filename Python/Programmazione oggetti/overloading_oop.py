class Acquisto:
	def __init__(self, basket, buyer):
		self.carrello = list(basket)
		self.__buyer = buyer

	def __len__(self):
		return len(self.carrello)

	def getBuyer(self,aut=False):
		if aut:
			return self.__buyer
		else:
			return "<segreto>"

	def getCarrello(self):
		return self.carrello

acq1 = Acquisto(['penna', 'libro', 'matita','gomma','calcolatrice','quaderni'], 'Mattia')
#da il numero di oggetti presenti nella lista (penna,libro,matita)
print("Acquirente:",acq1.getBuyer(True),"\nElementi presenti nel carrello:",len(acq1),"\nOggetti Acquistati:",acq1.getCarrello())

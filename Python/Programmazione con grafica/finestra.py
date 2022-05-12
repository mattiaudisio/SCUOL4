#finestra.py: contenitore grafico con etichetta e pulsante

#from tkinter import *

import tkinter as tk

class Finestra(tk.Frame):

	#costruttore
	def __init__(self, master=None):
		super().__init__(master)
		self.master.title("Finestra grafica")
		self.master.geometry("400x200")
		self.master.resizable(0,0)
		self.grid()
		self.crea_widgets()
	
	#inserimento dei widget 
	def crea_widgets(self):
		self.lbl1 = tk.Label(self, text = "Etichetta")
		self.lbl1.grid(row = 0, column = 0)
		self.btn1 = tk.Button(self, text = "Pulsante")
		self.btn1.grid(row = 0, column = 1)


def main():
	f = Finestra()
	f.mainloop() 

main()


'''
root = Tk()
b = 0
for r in range(6):
   for c in range(6):
      b = b + 1
      Button(root, text = str(b), borderwidth = 1 ).grid(row = r,column = c)

root.mainloop()
'''

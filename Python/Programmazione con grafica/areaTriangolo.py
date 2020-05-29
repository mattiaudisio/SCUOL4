import tkinter as tk

class Triangolo(tk.Frame):

	def __init__(self, master=None):
		super().__init__(master)
		self.master.title("Area del triangolo")
		self.master.geometry("400x200")
		self.master.resizable(1,0)
		self.grid()
		self.crea_widgets()

	def crea_widgets(self):
		self.lblBase = tk.Label(self, text = "Base")
		self.lblBase.grid(row = 0, column = 0)
		self.vBase = tk.IntVar()
		self.txtBase = tk.Entry(self, textvariable = self.vBase)
		self.txtBase.grid(row = 0, column = 1)

		self.lblAltezza = tk.Label(self, text = "Altezza")
		self.lblAltezza.grid(row = 1, column = 0)
		self.vAltezza = tk.IntVar()
		self.txtAltezza = tk.Entry(self, textvariable = self.vAltezza)
		self.txtAltezza.grid(row = 1, column = 1)

		self.btnCalcolo = tk.Button(self, text = "Calcolo area", command = self.calcolo_area)
		self.btnCalcolo.grid(row = 2, column = 1, columnspan = 2)

		self.lblArea = tk.Label(self, text = "Area")
		self.lblArea.grid(row = 3, column = 0)
		self.vArea = tk.DoubleVar()
		self.txtArea = tk.Entry(self, textvariable = self.vArea)
		self.txtArea.grid(row = 3, column = 1)

		self.btnEsci = tk.Button(self, text = "Esci", command = self.master.destroy)
		self.btnEsci.grid(row = 4, column = 1, columnspan = 2)

	def calcolo_area(self):
		b = self.vBase.get()
		h = self.vAltezza.get()
		a = b * h / 2
		self.vArea.set(a)


def main():
	f = Triangolo()
	f.mainloop()

main()

import tkinter as tk
from tkinter import filedialog


class Esercizio(tk.Frame):
    def __init__(self,master=None):
        super().__init__(master)
        self.master.title("Esercizio")
        self.master.geometry("600x400")
        self.master.resizable(1,0)
        self.grid()
        self.crea_widgets()

    def crea_widgets(self):
        tk.file = filedialog.askopenfilename(initialdir = "/",title = "Select file",filetypes = (("Text files","*.txt"),("all files","*.*")))
#		self.btnCerca=tk.Button(self,text="Cerca",command=self.cerca)
#		self.btnStampa=tk.Button(self,text="Stampa",command=self.stampa)

#	def cerca(self):
#        tk.file = filedialog.askopenfilename(initialdir = "/",title = "Select file",filetypes = (("Text files","*.txt"),("all files","*.*")))
#		self.percorso=tk.file

#	def stampa(self):
#		print(self.percorso)

def main():
    a=Esercizio()
    a.mainloop()

main()

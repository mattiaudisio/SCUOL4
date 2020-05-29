import tkinter as tk
import locale
from tkinter import messagebox
locale.setlocale(locale.LC_ALL,'')

class Saldo(tk.Frame):
    def __init__(self,master=None):
        super().__init__(master)
        self.master.title("Saldo")
        self.master.geometry("600x400")
        self.master.resizable(1,0)
        self.grid()
        self.crea_widgets()

    def crea_widgets(self):
        self.lEntrate=tk.Label(self,text="Entrate",font=("Arial",14)).grid(row=0,column=0,sticky=tk.NW)
        self.vEntrate=tk.StringVar()
        self.txtEntrate=tk.Entry(self,textvariable=self.vEntrate).grid(row=0,column=1,sticky=tk.N)

        self.lUscite=tk.Label(self,text="Uscite",font=("Arial",14)).grid(row=1,column=0,sticky=tk.NW)
        self.vUscite=tk.StringVar()
        self.txtUscite=tk.Entry(self,textvariable=self.vUscite).grid(row=1,column=1,sticky=tk.N)

        self.btnCalcola=tk.Button(self,text="Calcolo Saldo",command=self.calcola).grid(row=3,column=0,columnspan=2)
        self.btnAnnulla=tk.Button(self,text="Annulla",command=self.resetta).grid(row=3,column=2,columnspan=2)

        self.lSaldo=tk.Label(self,text="Entrate",font=("Arial",14)).grid(row=4,column=0,sticky=tk.NW)
        self.vSaldo=tk.StringVar()
        tk.txtSaldo=tk.Entry(self,textvariable=self.vSaldo).grid(row=4,column=1,sticky=tk.N)

        self.btnEsci=tk.Button(self,text="Esci",command=self.master.destroy).grid(row=5,column=1,columnspan=2)


    def calcola(self):
        e=locale.atof(self.vEntrate.get())
        self.vEntrate.set(locale.currency(e))
        u=locale.atof(self.vUscite.get())
        self.vUscite.set(locale.currency(u))
        saldo= e - u
        if saldo<0:
            tk.txtSaldo.configure(fg="red")
        else:
            tk.txtSaldo.configure(fg="green")
        self.vSaldo.set(locale.currency(saldo))

    def resetta(self):
        self.vEntrate.set(0)
        self.vUscite.set(0)

def main():
    a=Saldo()
    a.mainloop()

main()

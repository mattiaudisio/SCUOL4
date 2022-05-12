#Mattia Audisio 4C
import tkinter as tk
from tkinter import messagebox

class Calcolatrice(tk.Frame):
    def __init__(self,master=None):
        super().__init__(master)
        self.master.title("Calcolatrice")
        self.master.geometry("500x500")
        self.master.resizable(1,0)
        self.grid()
        self.crea_widgets()

    def crea_widgets(self):
        self.Titolo=tk.Label(self,text="CALCOLATRICE",font=("Arial Bold",30)).grid(row=0,column=2,sticky=tk.S)

        self.lNumero1=tk.Label(self,text="numero 1",font=("Arial Bold",10)).grid(row=1,column=1,sticky=tk.NW)
        self.vNumero1=tk.IntVar()
        self.txtNumero1=tk.Entry(self,textvariable=self.vNumero1,justify=tk.LEFT).grid(row=1,column=2)

        self.lNumero2=tk.Label(self,text="numero 2",font=("Arial Bold",10)).grid(row=2,column=1,sticky=tk.NW)
        self.vNumero2=tk.IntVar()
        self.txtNumero2=tk.Entry(self,textvariable=self.vNumero2,justify=tk.LEFT).grid(row=2,column=2)

        self.scelta=tk.Label(self,text="operazioni",font=("Arial Bolf",9)).grid(row=3,column=1,sticky=tk.NW)
        self.btnAddizione=tk.Button(self,text="Addizione",command=self.addizione).grid(row=4,column=2)
        self.btnSottrazione=tk.Button(self,text="Sottrazione",command=self.sottrazione).grid(row=5,column=2)
        self.btnMoltiplicazione=tk.Button(self,text="Moltiplicazione",command=self.moltiplicazione).grid(row=6,column=2)
        self.btnDivisione=tk.Button(self,text="Divisione",command=self.divisione).grid(row=7,column=2)

        self.separatore=tk.Label(self,text="__________________________",font=("Arial Bold",10)).grid(row=8,column=2)

        self.lRisultato=tk.Label(self,text="Risultato",font=("Arial Bold",10)).grid(row=9,column=1,sticky=tk.NW)
        self.vRisultato=tk.IntVar()
        self.txtRisultato=tk.Entry(self,textvariable=self.vRisultato,justify=tk.LEFT).grid(row=9,column=2)

        self.btnResetta=tk.Button(self,text="Resetta",command=self.resetta).grid(row=10,column=2)
        self.btnEsci=tk.Button(self,text="Esci",command=self.master.destroy).grid(row=11,column=3,columnspan=2)

    def addizione(self):
        sommaNum=self.vNumero1.get()+self.vNumero2.get()
        if sommaNum<0:
            self.txtRisultato.configure(bg="red")
        else:
            self.txtRisultato.config(bg="green")
        self.vRisultato.set(sommaNum)

    def sottrazione(self):
        sottrNum=self.vNumero1.get()-self.vNumero2.get()
        if sottrNum<0:
            self.txtRisultato.configure(bg="red")
        else:
            self.txtRisultato.configure(bg="green")
        self.vRisultato.set(sottrNum)

    def moltiplicazione(self):
        moltNum=self.vNumero1.get()*self.vNumero2.get()
        if moltNum<0:
            self.txtRisultato.configure(bg="red")
        else:
            self.txtRisultato.configure(bg="green")
        self.vRisultato.set(moltNum)

    def divisione(self):
        if self.vNumero2.get()==0:
            #Faccio un controllo e guardo se, a numero 2, ha lasciato zero, se ha lasciato zero faccio uscire un messaggio
            messagebox.showinfo('ERRORE','se il secondo numero ha valore 0 non si può completare il calcolo, inserisci un altro numero')
        else:
            divNum=self.vNumero1.get()/self.vNumero2.get()
            if divNum<0:
                self.txtRisultato.configure(bg="red")
            else:
               self.txtRisultato.configure(bg="green")
            self.vRisultato.set(divNum)

    def resetta(self):
        n1=self.vNumero1.set(0)
        n2=self.vNumero2.set(0)
        nris=self.vRisultato.set(0)

def main():
    f=Calcolatrice()
    f.mainloop()


main()

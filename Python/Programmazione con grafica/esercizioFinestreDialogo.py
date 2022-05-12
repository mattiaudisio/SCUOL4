import tkinter as tk
from tkinter import messagebox
import datetime

class Persona(tk.Frame):
    def __init__(self,master=None):
        super().__init__(master)
        self.master.title("Esercizio finestre di dialogo")
        self.master.geometry("600x400")
        self.master.resizable(1,0)
        self.grid()
        self.crea_widgets()

    def crea_widgets(self):
        rettangolo=tk.Canvas(self,width=600,height=400)

        self.lNome=tk.Label(self,text="Nome",font=("Arial",14)).grid(row=0,column=0,sticky=tk.NW)
        self.vNome=tk.StringVar()
        self.txtNome=tk.Entry(self,textvariable=self.vNome).grid(row=0,column=1,sticky=tk.N)

        self.lCognome=tk.Label(self,text="Cognome",font=("Arial",14)).grid(row=1,column=0,sticky=tk.NW)
        self.vCognome=tk.StringVar()
        self.txtCognome=tk.Entry(self,textvariable=self.vCognome).grid(row=1,column=1,sticky=tk.N)

        self.lAnni=tk.Label(self,text="data di nascita",font=("Arial",14)).grid(row=2,column=0,sticky=tk.NW)
        self.spinGiorno=tk.Spinbox(self,from_=0,to=100,width=5).grid(row=2,column=1)
        self.vSpinGiorno=tk.StringVar()
        self.spinMese=tk.Spinbox(self,from_=0,to=100,width=5).grid(row=2,column=2)
        self.vSpinMese=tk.StringVar()
        self.spinAnno=tk.Spinbox(self,from_=0,to=100,width=5).grid(row=2,column=3,sticky=tk.E)
        self.vSpinAnno=tk.StringVar()

        self.btnConferma=tk.Button(self,text="Conferma",command=self.controllo).grid(row=3,column=1,columnspan=2)
        self.btnConferma=tk.Button(self,text="Resetta",command=self.resetta).grid(row=3,column=3,columnspan=2)

    def controllo(self):
        if self.vNome.get()==" ":
            messagebox.showinfo('ERRORE', 'Non hai inserito il nome, allora inserisco in automatico il nome MARIO come nome')
            self.vNome.set("Mario")
        elif self.vNome.get()==" " and self.vCognome.get()==" ":
            messagebox.showinfo('ERRORE','Devi inserire il nome e il cognome')
        elif self.vCognome.get()==" ":
            messagebox.showinfo('ERRORE','Non hai inserito il cognome, allora inserisco in automatico il nome ROSSI come cognome')
            self.vCognome.set("Rossi")
        else:
            dataCorrente=datetime.datetime.now()
            if dataCorrente.strftime("%m")>int(self.vSpinMese.get()) and dataCorrente.strftime("%A")>int(self.vSpinGiorno.get())	:
                eta=(dataCorrente.strftime("%Y")-int(self.vSpinAnno.get()))-1
            else:
                eta=dataCorrente.strftime("%Y")-int(self.vSpinAnno.get())
            if eta<18:
                self.master.configure(bg="red")
                self.lNome.configure(bg="red")
                self.lCognome.configure(bg="red")
            else:                                           
                self.master.configure(bg="green")
                self.lNome.configure(bg="green")
                self.lCognome.configure(bg="green")
                messagebox.showinfo('Finestra','Ti chiami ',self.vNome.get(),' ',self.vCognome.get(),' e hai ',eta,' anni')

    def resetta(self):
        self.vNome.set(" ")
        self.vCognome.set(" ")

def main():
    a=Persona()
    a.mainloop()

main()

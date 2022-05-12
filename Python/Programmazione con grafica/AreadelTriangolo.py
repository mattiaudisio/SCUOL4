#Mattia Audisio 4C
import tkinter as tk

class Triangolo(tk.Frame):
    def __init__(self,master=None):
        super().__init__(master)
        self.master.title("Area del triangolo")
        self.master.geometry("500x300")
        self.master.resizable(1,0)
        self.grid()
        self.crea_widgets()

    def crea_widgets(self):
        self.lBase=tk.Label(self,text="Base",font=("Arial Bold",15)).grid(row=0,column=0,sticky=tk.NW)
        self.vBase=tk.IntVar()
        self.txtBase=tk.Entry(self,textvariable=self.vBase,justify=tk.LEFT).grid(row=0,column=1)

        self.lAltezza=tk.Label(self,text="Altezza",font=("Arial Bold",15)).grid(row=1,column=0,sticky=tk.W)
        self.vAltezza=tk.IntVar()
        self.txtAltezza=tk.Entry(self,textvariable=self.vAltezza,justify=tk.LEFT).grid(row=1,column=1)

        self.btnCalcolo=tk.Button(self,text="Calcolo area",background="green",command=self.calcoloArea).grid(row=2,column=1,columnspan=2)

        self.lArea=tk.Label(self,text="Area",font=("Arial Bold",15)).grid(row=3,column=0,sticky=tk.SW)
        self.vArea=tk.DoubleVar()
        self.txtArea=tk.Entry(self,textvariable=self.vArea,fg="green",justify=tk.LEFT).grid(row=3,column=1)

        self.btnEsci=tk.Button(self,text="Esci",background="red",command=self.master.destroy).grid(row=4,column=1,columnspan=2)
        self.btnResetta=tk.Button(self,text="Resetta",background="yellow",command=self.resetta).grid(row=4,column=2,columnspan=2)

    def calcoloArea(self):
        if self.vBase.get()==0 or self.vAltezza.get()==0:
            self.vArea.configure(text="Non puà esistere un triangolo con altezza o base uguale a 0",fg="red")
        else:
            self.vArea.set(self.vBase.get()*self.vAltezza.get()/2)

    def resetta(self):
        b=self.vBase.set(0)
        h=self.vAltezza.set(0)

def main():
    f=Triangolo()
    f.mainloop()

#Main
main()

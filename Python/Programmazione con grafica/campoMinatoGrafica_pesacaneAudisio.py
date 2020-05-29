import tkinter as tk
from functools import partial
from tkinter import messagebox

class FinestraIniziale(tk.Frame): #finestra iniziale dove viene chiesto in input le dimensioni del campo e numero mine

    def __init__(self,master=None):
        super().__init__(master)
        self.master.title("Campo minato")

        larghezzaFinestra=400
        altezzaFinestra=200
        self.master.geometry('{}x{}'.format(larghezzaFinestra, altezzaFinestra))

        self.master.columnconfigure(0, weight=1) #centra le colonne
        self.master.rowconfigure(0, weight=1) # centra le righe

        self.grid()
        self.creaWidgets()

    def creaWidgets(self):

        #scritta dimensioni
        self.labelDim=tk.Label(self,text="Dimensioni")
        self.labelDim.grid(row = 0, column = 0,padx=10,pady=5)

        #input dimensioni
        self.varDim=tk.IntVar()
        self.inputDim=tk.Entry(self, textvariable=self.varDim,highlightbackground="red")
        self.inputDim.grid(row=0,column=1,padx=10,pady=5)

        #bottone info sulle dimensioni
        self.btnInfoDim=tk.Button(self,text="?", bg="lightblue",command=partial(self.testo,0))
        self.btnInfoDim.grid(row = 0, column = 2,padx=10,pady=5)

        #scritta mine
        self.labelMine=tk.Label(self,text="Mine")
        self.labelMine.grid(row = 1, column = 0,padx=10,pady=5)

        #input delle mine
        self.varMine=tk.IntVar()
        self.inputMine=tk.Entry(self, textvariable=self.varMine,highlightbackground="red")
        self.inputMine.grid(row=1,column=1,padx=10,pady=5)

        self.btnIstruzioni=tk.Button(self,text="Istruzioni", bg="lightblue",command=partial(self.testo,1))
        self.btnIstruzioni.grid(row = 2, column = 0,padx=10,pady=5)

        self.btnGioca=tk.Button(self,text="GIOCA!", bg="lightblue",command=gioco)
        self.btnGioca.grid(row = 2, column = 2,padx=10,pady=5)

    def testo(self,variabile): #funzione utilizzata per piu bottoni , in base al bottone premuto si visualizza un testo diverso
        if variabile==0:
            print("testo punto interrogativo")
        if variabile==1:
            print("testo istruzioni")

    def getVarDim(self):
        return self.varDim.get()

    def getVarMine(self):
        return self.varMine.get()

class FinestraGioco(tk.Frame):

    def __init__(self,master=None,dim=0,mine=0):
        super().__init__(master)

        self.dimFinestra=dim
        self.numMine=mine

        self.master.title("Campo minato")

        larghezzaFinestra=800
        altezzaFinestra=600
        self.master.geometry('{}x{}'.format(larghezzaFinestra, altezzaFinestra))

        self.master.columnconfigure(0, weight=1) #centra le colonne
        self.master.rowconfigure(0, weight=1) # centra le righe

        self.grid()
        self.creaWidgets()
        self.disseminaMine()

    def creaWidgets(self):
        listBottoni=[]
        dizPosizioni={}
        for i in range(0,self.dimFinestra):
            for j in range(0,self.dimFinestra):
                dizPosizioni[i+j]=(i,j)
                listBottoni.append(tk.Button())
                listBottoni[i]=tk.Button(self,text="X", bg="red")
                listBottoni[i].grid(row = i, column = j,padx=10,pady=10)

    def disseminaMine(self):
        print(dizPosizioni)

    def gioca1(self):
        posvicine=[]
        finito=0
        while len(posvicine)!=self.dimFinestra**2 and finito==0
    		riga=9999999
    		colonna=9999999
            while riga>self.dimFinestra or colonna>self.dimFinestra:
                self.labelRig=tk.Label(self,text="Inserisci la riga")
                self.labelRig.grid(row = len(self.dimFinestra)+1, column = 0,padx=10,pady=5)
                self.varRig=tk.IntVar()
                self.inputRig=tk.Entry(self, textvariable=self.varRig,highlightbackground="red")
                self.inputRig.grid(row=len(self.dimFinestra)+1,column=1,padx=10,pady=5)
                self.labelColl=tk.Label(self,text="Inserisci la colonna")
                self.labelColl.grid(row =  len(self.dimFinestra)+3, column = 0,padx=10,pady=5)
                self.varColl=tk.IntVar()
                self.inputColl=tk.Entry(self, textvariable=self.varColl,highlightbackground="red")
                self.inputColl.grid(row=len(self.dimFinestra)+3,column=1,padx=10,pady=5)
                self.btnGioca=tk.Button(self,text="VAI!", bg="lightblue",command=gioca2(len(self.varRig.get()),len(self.varColl.get())),posvicine)
                self.btnGioca.grid(row = len(self.dimFinestra)+2, column = 2,padx=10,pady=5)
        finestra2.destroy()
        finestra1.mainloop()


    def gioca2(self,rig,coll,pos):
        cordinateangoli=[(1,1),(1,self.dimFinestra),(self.dimFinestra,1),(self.dimFinestra,self.dimFinestra)]
        posizione=(rig,coll)
        posizioneEtic=list(dizPosizioni.keys())
		contamosse=contamosse+1
        if pos in posizioneEtic:
            if matrice[pos]=='*':
                finito=1
                if contamosse==1:
                    messagebox.showinfo('GAME OVER', 'HAI PERSO CON ',contamosse,' MOSSA!')
                else:
                    messagebox.showinfo('GAME OVER', 'HAI PERSO CON ',contamosse,' MOSSE!')
        elif posizione in cordinatebordi:           #cordinatebordi da mettere a posto
            if posizione[0]==1:
                if posizione not in  pos:
                    pos.append(posizione)
                if (posizione[0],posizione[1]+1) not in pos:
                    pos.append(posizione[0],posizione[1]+1)
                if (posizione[0],posizione[1]-1) not in pos:
                    pos.append(posizione[0],posizione[1]-1)
                if (posizione[0]+1,posizione[1]-1) not in pos:
                    pos.append(posizione[0]+1,posizione[1]-1)
                if (posizione[0]+1,posizione[1]) not in pos:
                    pos.append(posizione[0]+1,posizione[1])
                if (posizione[0]+1,posizione[1]+1) not in pos:
                    pos.append(posizione[0]+1,posizione[1]+1)
				for i in range(len(posizione)):
					if posizione[i] not in posEtic:
						listBottoni[posizione[i]]=tk.Button(self,text="O", bg="red")
					else:
						listBottoni[posizione[i]]=tk.Button(self,text="X", bg="red")
            if posizione[1]==1:
                if posizione not in  pos:
                    pos.append(posizione)
                if (posizione[0]-1,posizione[1]) not in pos:
                    pos.append(posizione[0]-1,posizione[1])
                if (posizione[0]+1,posizione[1]) not in pos:
                    pos.append(posizione[0]+1,posizione[1])
                if (posizione[0]-1,posizione[1]+1) not in pos:
                    pos.append(posizione[0]-1,posizione[1]+1)
                if (posizione[0],posizione[1]+1) not in pos:
                    pos.append(posizione[0],posizione[1]+1)
                if (posizione[0]+1,posizione[1]+1) not in pos:
                    pos.append(posizione[0]+1,posizione[1]+1)
				for i in range(len(posizione)):
					if posizione[i] not in posEtic:
						listBottoni[posizione[i]]=tk.Button(self,text="O", bg="red")
					else:
						listBottoni[posizione[i]]=tk.Button(self,text="X", bg="red")
            if posizione[0]==self.dimFinestra:
                if posizione not in  pos:                       pos.append(posizione)
                if (posizione[0],posizione[1]-1) not in pos:    pos.append(posizione[0],posizione[1]-1)
                if (posizione[0],posizione[1]+1) not in pos:    pos.append(posizione[0],posizione[1]+1)
                if (posizione[0]-1,posizione[1]+1) not in pos:  pos.append(posizione[0]-1,posizione[1]+1)
                if (posizione[0]-1,posizione[1]) not in pos:    pos.append(posizione[0]+1,posizione[1])
                if (posizione[0]-1,posizione[1]-1) not in pos:  pos.append(posizione[0]-1,posizione[1]-1)
				for i in range(len(posizione)):
					if posizione[i] not in posEtic:
						listBottoni[posizione[i]]=tk.Button(self,text="O", bg="red")
					else:
						listBottoni[posizione[i]]=tk.Button(self,text="X", bg="red")
        elif posizione in cordinateangoli:
            if posizione[0]==1 and pos[1]==1:
                if posizione not in pos:    pos.append(posizione)
				if (posizione[0],posizione[1]+1) not in pos: pos.append((pos[0],pos[1]+1))
				if (posizione[0]+1,posizione[1]) not in pos: pos.append((pos[0]+1,pos[1]))
				if (posizione[0]+1,posizione[1]+1) not in pos: pos.append((pos[0]+1,pos[1]+1))
				for i in range(len(posizione)):
					if posizione[i] not in posEtic:
						listBottoni[posizione[i]]=tk.Button(self,text="O", bg="red")
					else:
						listBottoni[posizione[i]]=tk.Button(self,text="X", bg="red")
            if posizione[0]==self.dimFinestra and pos[1]==1:
                if posizione not in pos:    pos.append(posizione)
				if (posizione[0]-1,posizione[1]) not in pos: pos.append((posizione[0]-1,posizione[1]))
				if (posizione[0]-1,posizione[1]+1) not in pos: pos.append((posizione[0]-1,posizione[1]+1))
				if (posizione[0],posizione[1]+1) not in pos: pos.append((posizione[0],posizione[1]+1))
				for i in range(len(posizione)):
					if posizione[i] not in posEtic:
						listBottoni[posizione[i]]=tk.Button(self,text="O", bg="red")
					else:
						listBottoni[posizione[i]]=tk.Button(self,text="X", bg="red")
            if posizione[0]==1 and pos[1]==self.dimFinestra
                if posizione not in pos:    pos.append(posizione)
				if (posizione[0]+1,posizione[1]) not in pos: pos.append((pos[0],pos[1]+1))
				if (posizione[0]+1,posizione[1]-1) not in pos: pos.append((pos[0]+1,pos[1]))
				if (posizione[0],posizione[1]-1) not in pos: pos.append((pos[0]+1,pos[1]+1))
				for i in range(len(posizione)):
					if posizione[i] not in posEtic:
						listBottoni[posizione[i]]=tk.Button(self,text="O", bg="red")
					else:
						listBottoni[posizione[i]]=tk.Button(self,text="X", bg="red")
            if posizione[0]==self.dimFinestra and pos[1]==self.dimFinestra:
                if posizione not in pos:    pos.append(posizione)
				if (posizione[0],posizione[1]-1) not in pos: pos.append((pos[0],pos[1]+1))
				if (posizione[0]-1,posizione[1]-1) not in pos: pos.append((pos[0]+1,pos[1]))
				if (posizione[0]-1,posizione[1]) not in pos: pos.append((pos[0]+1,pos[1]+1))
				for i in range(len(posizione)):
					if posizione[i] not in posEtic:
						listBottoni[posizione[i]]=tk.Button(self,text="O", bg="red")
					else:
						listBottoni[posizione[i]]=tk.Button(self,text="X", bg="red")
        else:
            if posizione not in pos:    pos.append(posizione)
			if (posizione[0]-1,posizione[1]) not in posvicine: pos.append((pos[0]-1,pos[1]))
			if (posizione[0]-1,posizione[1]-1) not in posvicine: pos.append((pos[0]-1,pos[1]-1))
			if (posizione[0]-1,posizione[1]+1) not in posvicine: pos.append((pos[0]-1,pos[1]+1))
			if (posizione[0],posizione[1]-1) not in posvicine: pos.append((pos[0],pos[1]-1))
			if (posizione[0],posizione[1]+1) not in posvicine: pos.append((pos[0],pos[1]+1))
			if (posizione[0]+1,posizione[1]) not in posvicine: pos.append((pos[0]+1,pos[1]))
			if (posizione[0]+1,posizione[1]-1) not in posvicine: pos.append((pos[0]+1,pos[1]-1))
			if (posizione[0]+1,posiziones[1]+1) not in posvicine: pos.append((pos[0]+1,pos[1]+1))
            for i in range(len(posizione)):
                if posizione[i] not in posEtic:
                    listBottoni[posizione[i]]=tk.Button(self,text="O", bg="red")
                else:
					listBottoni[posizione[i]]=tk.Button(self,text="X", bg="red")
        return finito
                    
def gioco():
    dimensioni=int(finestra1.getVarDim()) #salva i parametri immessi dall utente
    mine=int(finestra1.getVarMine())

    #distruggo la finestra iniziale
    finestra1.destroy()

    #crea la finestra del gioco
    finestra2=FinestraGioco(None,dimensioni,mine)
    finestra2.mainloop()


finestra1=FinestraIniziale()
finestra1.mainloop()

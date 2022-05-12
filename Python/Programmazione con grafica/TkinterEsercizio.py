import tkinter as tk

class finestra(tk.Frame):
    def __init__(self, master=None):
        super().__init__(master)
        self.master.title("Finestra grafica")
        self.master.geometry("300x200")
        self.grid()
        self.crea_widgets()

    def crea_widgets(self):
        self.lbl1=tk.Label(self, text="Etichetta")
        self.lbl1.grid(row=0,column=0)
        self.btn1=tk.Button(self,text="Pulsante")
        self.btn1.grid(row=0,column=1)


def main():
    f= finestra()
    f.mainloop()

main()

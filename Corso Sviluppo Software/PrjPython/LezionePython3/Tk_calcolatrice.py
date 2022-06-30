import tkinter as tk

window = tk.Tk()

# dimensioni
window.geometry('200x300')
window.title('Calcolatrice')
window.resizable(False, False)


def Addizione():
    valore1 = int(vNumero1.get("1.0", 'end-1c'))
    valore2 = int(vNumero2.get("1.0", 'end-1c'))
    somma = valore1+valore2
    txtRisultato.configure(text=somma)


def Sottrazione():
    valore1 = int(vNumero1.get("1.0", 'end-1c'))
    valore2 = int(vNumero2.get("1.0", 'end-1c'))
    somma = valore1-valore2
    txtRisultato.configure(text=somma)


def Moltiplicazione():
    valore1 = int(vNumero1.get("1.0", 'end-1c'))
    valore2 = int(vNumero2.get("1.0", 'end-1c'))
    somma = valore1*valore2
    txtRisultato.configure(text=somma)


def Divisione():
    valore1 = int(vNumero1.get("1.0", 'end-1c'))
    valore2 = int(vNumero2.get("1.0", 'end-1c'))
    somma = valore1//valore2
    txtRisultato.configure(text=somma)


lNumero1 = tk.Label(text="numero 1", font=("Arial Bold", 10)).grid(row=1, column=1, sticky=tk.NW)
vNumero1 = tk.Text(width=10, height=1)
vNumero1.grid(row=1, column=2, sticky=tk.NE)

lNumero2 = tk.Label(text="numero 2", font=("Arial Bold", 10)).grid(row=2, column=1, sticky=tk.NW)
vNumero2 = tk.Text(width=10, height=1)
vNumero2.grid(row=2, column=2, sticky=tk.NE)

lRisultato = tk.Label(text="Risultato", font=("Arial Bold", 10)).grid(row=3, column=1, sticky=tk.NW)
txtRisultato = tk.Label()
txtRisultato.grid(row=3, column=2, sticky=tk.NE)

button1 = tk.Button(text='+', command=Addizione, height=2, width=4)
button1.grid(row=4, column=1, padx=10, pady=10)
button2 = tk.Button(text='-', command=Sottrazione, height=2, width=4)
button2.grid(row=4, column=2, padx=10, pady=10)
button3 = tk.Button(text='*', command=Moltiplicazione, height=2, width=4)
button3.grid(row=4, column=3, padx=10, pady=10)
button4 = tk.Button(text='/', command=Divisione, height=2, width=4)
button4.grid(row=4, column=4, padx=10, pady=10)

# visualizzazione
if __name__ == '__main__':
    window.mainloop()

exit(0)

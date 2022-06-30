import tkinter as tk

# 1. creo la finestra
window = tk.Tk()

# dimensioni
window.geometry('600x600')
window.title('Ciao')
window.resizable(False, False)

# visualizzazione
if __name__ == '__main__':
    window.mainloop()

exit(0)

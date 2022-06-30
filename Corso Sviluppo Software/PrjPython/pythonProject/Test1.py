operando = 0
opernado1 = int(input("Inserisci valore 1: "))
opernado2 = int(input("Inserisci valore 2: "))
tipoCalcolo = input("Inserisci un calcolo [inserisci +, -, *, /]: ")

if tipoCalcolo == "+":
    operando = opernado1 + opernado2
    print("Risultato:", operando)
elif tipoCalcolo == "-":
    operando = opernado1 - opernado2
    print("Risultato:", operando)
elif tipoCalcolo == "*":
    operando = opernado1 * opernado2
    print("Risultato:", operando)
elif tipoCalcolo == "/":
    operando = opernado1 // opernado2
    print("Risultato:", operando)
else:
    print("Comando non riconosciuto")

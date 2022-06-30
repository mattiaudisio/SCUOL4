# Appunti Python

Python è un linguaggio interpretato. É possibile utilizzare l'interprete in 2 modalità:
- Modalità interattiva (l'interprete attende che l'utente digiti l'istruzione)
- Modalità script (l'interprete riceve un file contente codice da eseguire)

Inserimento del codice -> Compilazione -> *Fase di test (debug)*

*print()* -> viene richiamato dall'esterno, non fa parte delle keyword di python. É una funzione

__*keyword*__: parole interne di un linguaggio 

__*operatori*__: possono essere matematici (+, -, *, /, % per sapere il resto, // per avere come risultato della divisione un numero senza decimali) oppure di confronto (True, False che li ricavo da >, <, <=, >=) oppure logici (and or not)

__*script*__ (Python, no Java): viene eseguita l'istruzione così come la vedo

__*moduli*__:  un modulo è generalmente un file o porzione di codice sorgente che contiene istruzioni scritte per essere riutilizzate più volte nello stesso programma o in più programmi diversi: la modularizzazione di un programma permette al programmatore di avere una visione completa del programma stesso.

__*libreria/package*__: insieme di più moduli specializzati

![f0706480abd9f8402d9a44c29343d94f](https://user-images.githubusercontent.com/57859960/118338863-867ac480-b517-11eb-8e06-5019abb078f7.png)


__*funzione/procedure*__: una serie di istruzioni che io ho fatto per una determinata azione e posso richiamarla in ogni momento


__*metodo*__: É un termine che viene usato principalmente nel contesto della programmazione orientata agli oggetti per indicare un sottoprogramma associato in modo esclusivo ad una classe e che rappresenta un'operazione eseguibile sugli oggetti e istanze di quella classe.

__*stringa*__: "scuola","guido" viene messa tra doppi apici

__*variabili*__: è un "contenitore" in cui vengono inseiriti i dati

in programmazione __*=*__ equivale all'operatore di assegnazione

__N.B.__: il nome della variabile non può iniziare con una lettera, non può avere caratteri particolari (l'unico è " _ "), sono sconsigliate le lettere accentate

- Python è case-sensitive

**Operatori Booleani**

-AND<br />
-OR<br />
-NOT<br />

![b603e195b753d9b8c3a0b8f29c39bc20](https://user-images.githubusercontent.com/57859960/118338909-a611ed00-b517-11eb-9a48-2966382161ee.png)

con la funzione *type()* vieni a conoscenza del tipo dato di una variabile

Uno dei problemi di Python è che non è tipicizzato

Nella divisione:
- con / viene un float
- con // viene un int
- se di mezzo c'è un float, il risultato sarà sempre float

![f881d2a2a19eb23020a7c58f27e5cb71](https://user-images.githubusercontent.com/57859960/118338938-b7f39000-b517-11eb-89a9-cf700549dd70.png)

__*casting*__: conversione da un tipo all'altro

**Esempio flowchat**<br />
![0ea564357147e968a836bd2522660c61](https://user-images.githubusercontent.com/57859960/118338985-d5285e80-b517-11eb-8c2d-1a936d9f1093.png)


**Operatori Operazionali**

-b += a   ->  b = b + a<br />
-b -= a   ->  b = b - a<br />
-b *= a   ->  b = b * a<br />
-b /= a   ->  b = b / a (_sempre Float_)<br />
-b //= a  ->  b = b // a<br />
-b %= a   ->  b = b % a<br />

_**N.B**_.
se anche un solo numero è float il risultato e SEMPRE float

# Definizioni

*Identificatori*: i nomi utilizzati per identificare le variabili, funzioni, classi e moduli devono iniziare con una lettere o un trattino basso

*Indentazione*: in Python la forma è così importante che per delimitare i blocchi di codice, al posto di utilizzare negli agli linguaggi le parentesi, si utilizza l'indentazione

Le *virgolette* servono per definire stringhe di caratteri

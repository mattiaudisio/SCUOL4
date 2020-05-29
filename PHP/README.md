#PHP

Per creare una cartella:<br />
		- sudo chmod 777: da i permessi
		- sudo mkdir nomeCartella: crea la cartella		
<br />
$_POST: La variabile $_POST è "collegata" a un form fisico html, serve a ricavare
				__un dato inserito in un campo di un form html; le informazioni sono nascoste__	
<br />				
$_GET: 	i dati si vedono nella barra di ricerca; le informazioni sono nascoste
<br />
name è importante perchè è il nome della variabile
<br />
empty serve a controllare se la variabile è vuota mentre isset serve a
controllare se la variaibile esiste
isset serve a controllare se la variabile richiesta è settata
<br />
send è il pass per andare nel file php
<br />
C'è anche da dire che per controllare se una variabile è vuota è possibile anche
non usare alcuna funzione, ma metterla normalmente in una parentesi.
<br />
Una variabile di sessione si definisce con:
	__$_SESSION[nomesessione] = "valore";__
<br />		
__$_SESSION['username'] = "Matteo"; //Stabiliamo la  variabile sessione di nome username__
<br />
se faccio session_start() in un altro file e questa session vede che c'è un'altra session attiva, questa session si collega a quella creata in precedenza

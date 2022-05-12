# SCUOLA-PHP

Per creare una cartella:<br />
	-sudo chmod 777: da i permessi
 	-sudo mkdir nomeCartella: crea la cartella		
 
  $_POST: La variabile $_POST è "collegata" a un form fisico html, serve a ricavare un dato inserito in un campo di un form html; le informazioni sono nascoste<br />
  $_GET: 	i dati si vedono nella barra di ricerca; le informazioni sono nascoste

name è importante perchè è il nome della variabile<br />
empty serve a controllare se la variabile è vuota mentre isset serve a controllare se la variaibile esiste <br />
isset serve a controllare se la variabile richiesta è settata <br />


send è il pass per andare nel file php

C'è anche da dire che per controllare se una variabile è vuota è possibile anche
non usare alcuna funzione, ma metterla normalmente in una parentesi.

Una variabile di sessione si definisce con:
  
	$_SESSION[nomesessione] = "valore";
	$_SESSION['username'] = "Matteo"; //Stabiliamo la  variabile sessione di nome username


se faccio session_start() in un altro file e questa session vede che c'è un'altra session attiva, questa session si collega a quella creata in precedenza

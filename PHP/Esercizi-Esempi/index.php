<?php   
	echo "<h1><b>Ciao Mondo!</b></h1>"; 
	//Commento in PHP
	$testo = "Ciao ragazzi"; //OSSERVATE E MEMORIZZATE, ECCO COME SI DEFINISCE UNA VARIABILE !!
	echo $testo;
	echo "<p>$testo sono Mattia";  
	define("CHEDIRE", "Viva la vita");  
	echo ";".CHEDIRE."</p>";  //Apparira'  la scritta "Viva la vita"  

	$eta= 14; //QUI DEFINIAMO BANALMENTE UNA VARIABILE NUMERICA
	if ($eta == 18){ //LEGGETE E MEMORIZZATE, ECCO COME SI CREA UN CONTROLLO IF
		echo "<p>Hai 18 anni tondi tondi!</p>"; //MOSTRIAMO UN BANALISSIMO TESTO
	}else{ //altrimenti
		echo "<h2>Sei minorenne</h2>";
	}
	
	echo "<br>".$_SERVER['HTTP_COOKIE']; //Mostra il valore di tutti i cookie		--> ES: 
	echo "<br>".$_SERVER['HTTP_HOST']; // Mostra il nome dell'host su quale risiede il server web		--> ES: localhost 
	echo "<br>".$_SERVER['REMOTE_ADDR']; // Mostra l'indirizzo ip dell'utente		--> ES: 127.0.0.1 
	echo "<br>".$_SERVER['PHP_SELF']; // Mostra il nome file della pagina corrente		--> ES: /Mattia/index.php    
	echo "<br>".$_SERVER['SCRIPT_FILENAME']; //Mostra il nome e il percorso completo dello script corrente		--> ES: /opt/lampp/htdocs/Mattia/index.php 
	echo "<br>".$_SERVER['SERVER_NAME']; //Mostrail nome del server web		--> ES: localhost
	echo "<br>".$_SERVER['HTTP_USER_AGENT']; //Mostra il nome univoco del browser utilizzato dall'utente		--> ES: Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:69.0) Gecko/20100101 Firefox/69.0 	

	$nomearray = array ("giorgio","nicola","filippo");
	echo "<br>".$nomearray[0]; 
	echo "<br>".$nomearray[1];
	echo "<br>".$nomearray[2];
	
	require("index.html"); 	//richiama il contenuto del file che richiamiamo
	$variabile="Mi chiamo Matteo"; 
	echo $variabile;
	$variabile_nuova = str_replace("Matteo", "Giovanni", $variabile); //Significa sostituisci Matteo con Giovanni nella varaibile di nome $variabile) 
	echo "<br>".$variabile_nuova; //IL testo che apparirà sarà Mi chiamo Giovanni,perchè abbiamo sostituito Matteo con Giovanni 
?>  
<p>
	Secondo paragrafo [Scritto in HTML]
</p>

<?php
  session_start();
  /*
  Nel caso in cui il massimo numero di persone disponibili non coincida con il totale dei partecipanti (la lista dei partecipanti coincide con l’insieme dei nomi inseriti col form), per ogni opzione si stampano le persone che non hanno dato disponibilità.
  */
?>
<html>
  <body>
    <?php      
      
		if (empty($_POST['nome']))	echo "<h1>Manca il nome</h1>";  	  	
      	else {		
      		$nome 		= $_POST['nome'];
		  	$giorno 	= $_POST['giorni'];
		  	$ore		= $_POST['ore'];
		  	$_SESSION["nomi"][] = $_POST['nome'];
			$_SESSION['disponibilita'][$ore][$giorno][$nome]=1;
			$_SESSION['disponibilita'][$ore][$giorno][$nome]=$_POST['nome'];
			print($ore);
			print($giorno);
			echo "<h1>Disponibiltà di $nome salvate</h1>";
      }
   ?>
   	<button name="riepilogo" onclick="location.href='form.php'">Nuova Disponibilità</button>
	<button name="index" onclick="location.href='resoconto.php'">Resoconto</button>
  
  </body>
 </html>  

<?php
  session_start();
?>
<html>
  <body>
    <?php      
      
		if (empty($_POST['nome']))	echo "<h1>Manca il nome</h1>";  	  	
      	else {		
      	$nome 	= $_POST['nome'];
		  	$giorno 	= $_POST['giorni'];
		  	$ore		= $_POST['ore'];
		  	$_SESSION["nome"]	= $_POST['nome'];
			$_SESSION['disponibilita'][$ore][$giorno][$nome]=1;
            $_SESSION ['valoreControllo ']= count($_SESSION ['valoreControllo '])+1;
			print($ore);
			print($giorno);
			echo "<h1>Disponibiltà di $nome salvate</h1>";
      }
   ?>
   <button name="riepilogo" onclick="location.href='form.php'">Nuova Disponibilità</button>
	<button name="index" onclick="location.href='resoconto.php'">Resoconto</button>
  
  </body>
 </html>  

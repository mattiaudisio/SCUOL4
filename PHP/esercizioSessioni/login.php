<?php
	$NomeUtenti = array("aaa","bbb","ccc");
	$cognomeUtenti = array("Rosso","Bianco","Giallo");
	if(isset($_POST['send'])){
		if(!empty($_POST['nome']) && !empty($_POST['cognome'])){
			if(in_array($_POST['nome'],$NomeUtenti) && in_array($_POST['cognome'],$cognomeUtenti)){
				session_start();
				echo "Ciao ".$_POST['nome']."  ".$_POST['cognome']."<br />";	
				echo '<a href="login1.php"> <input type="submit" name="send" value="Invia">	</a>';		
			}else{
				echo "Utente non registrato";
			}
		}else{
			echo "Inserisci tutti e due i valori";
			echo '<br / ><a href="javascript:history.go(-1)">Torna indietro</a>';
		}
	}
?>

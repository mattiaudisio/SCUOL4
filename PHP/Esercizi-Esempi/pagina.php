<?php
	if (isset($_POST['send'])){ //isset serve a controllare se la variabile richiesta è settata
		if (!empty($_POST['eta'])){
			echo "<p>".$_POST['eta']."</p>";
			//Qui verrà mostrato ciò che ha inserito l'utente nel campo di nome eta.
		} else {
			echo "Hai lasciato vuoto il campo età";
		}
		if (empty($_POST['nome'])){
			echo "Il campo nome è vuoto!";
		} else {
			echo "<p>".$_POST['nome']."</p>";
			//Qui verrà mostrato ciò che ha inserito l'utente nel campo nome
		}
	}
?>

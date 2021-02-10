<?php
	if (isset($_GET['send'])){ //isset serve a controllare se la variabile richiesta è settata
		if (!empty($_GET['eta'])){
			echo "<p>".$_GET['eta']."</p>";
			//Qui verrà mostrato ciò che ha inserito l'utente nel campo di nome eta.
		} else {
			echo "Hai lasciato vuoto il campo età";
		}
		if (empty($_GET['nome'])){
			echo "Il campo nome è vuoto!";
		} else {
			echo "<p>".$_GET['nome']."</p>";
			//Qui verrà mostrato ciò che ha inserito l'utente nel campo nome
		}
	}
?>

<?php
	$prezzoStandard = 430;
	$prezzo = 0;
	$prezzoUltimo = 0;

	
	if(isset($_POST['send'])){
		if(!empty($_POST['nome']) && !empty($_POST['cognome']) && !empty($_POST['indirizzo']) && !empty($_POST['numSettimane']) && !empty($_POST['numPersone'])){
			if($_POST['numSettimane'] > 2 && $_POST['numPersone'] > 2){	
				$prezzo = (15*$prezzoStandard)/100;			
				$prezzoUltimo = $prezzoStandard - $prezzo;			
			}else{
			$prezzo = (5*$prezzoStandard)/100;
			$prezzoUltimo = $prezzoStandard - $prezzo;			
			}
			echo " ".$_POST['nome']." ".$_POST['cognome']." la crociera che hai ordinato per ".$_POST['numSettimane']." settimane per ".$_POST['numPersone']." persone costa $prezzoUltimo €";
		}else{
			echo "Compila tutti i campi richiesti";
		}
	}
?>

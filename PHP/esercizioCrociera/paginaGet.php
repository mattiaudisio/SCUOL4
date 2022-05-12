<?php
	$prezzoStandard = 430;
	$prezzo = 0;
	$prezzoUltimo = 0;
	
	if(isset($_GET['send'])){
		if(!empty($_GET['nome']) && !empty($_GET['cognome']) && !empty($_GET['indirizzo']) && !empty($_GET['numSettimane']) && !empty($_GET['numPersone'])){
			if($_GET['numSettimane'] > 2 && $_GET['numPersone'] > 2){	
				$prezzo = (15*$prezzoStandard)/100;	ù
				$prezzoUltimo = $prezzoStandard - $prezzo;									
			}else{
			$prezzo = (5*$prezzoStandard)/100;
			$prezzoUltimo = $prezzoStandard - $prezzo;
			}
			echo " ".$_GET['nome']." ".$_GET['cognome']." la crociera che hai ordinato per ".$_GET['numSettimane']." settimane per ".$_GET['numPersone']." persone costa $prezzoUltimo €";
		}else{
			echo "Compila tutti i campi richiesti";
		}
	}
?>

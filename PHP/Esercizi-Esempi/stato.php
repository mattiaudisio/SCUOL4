<?php
	if(isset($_GET['stato'])){
		switch($_GET['stato']){
			case "usa":
				echo "Washigton";
				break;
			case "italia":
				echo "Roma";
				break;
			case "francia":
				echo "Parigi";
				break;
			default:
				echo "Stato non definito!";
				break;
		}
	}else{
		echo "<p>Variabile stato non definita</p>";
	}		
?>

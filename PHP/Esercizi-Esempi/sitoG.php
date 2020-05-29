<?php
	echo "<a href='sitoG.php?page='>Home</a> | <a href='sitoG.php?page=contatti'>Contatti</a> | <a href='sitoG.php?page=bio'>Biografia</a> | <a href='sitoG.php?page=links'>Links</a>";
	echo "<p></p>";
	if(isset($_GET['page'])){
		switch($_GET['page']){
			case "bio":
				echo "Contenuto della pagina biografia";
				break;
			case "links":
				echo "contenuto della pagina links";
				break;
			case "contatti":?>
				<p>Contenuto della pagina contatti(IN HTML, chiudendo i tags php qui posso usare normale html!!!)</p>
				<?php
				break;
			default:
				echo "Contenuto della home page, cioè di quando il get page è vuoto!";
				break;
		}	
	}
?>

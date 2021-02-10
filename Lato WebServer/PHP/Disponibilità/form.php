<?php 
	$giorni = array("Lunedì","Martedì","Mercoledì","Giovedì","Venerdì");
  	$ore = array("9-11","11-13","14-16","16-18");
?>

<html>
	
	<body>
		<form action="disponibilita.php" method="post">
			<select name="giorni" multiple="multiple">
				<?php				
				for ($i = 0; $i < 5; $i++) {
					echo "<option>$giorni[$i]</option>\n";
				}
				?>
			</select>
			<select name="ore" multiple="multiple">
				<?php
				  for ($i = 0; $i < 4; $i++) {
					echo "<option>$ore[$i]</option>\n";
				}
				?>
			</select><br />
			Nome <input type="text" name="nome" /><br />
			<input type="submit" value="Invia" />
		</form>
	</body>
</html>

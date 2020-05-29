<?php
	session_start();
	$giorni = array("Lunedì","Martedì","Mercoledì","Giovedì","Venerdì");
	$ore = array("9-11","11-13","14-16","16-18");
	$arrayDisp = $_SESSION['disponibilita'];
	$arrayNomi=$_SESSION["nomi"];
	$max=0;
	
?>

<html>
	<style>
		table, td, th{border:1px solid #EEE;border-collapse:collapse}
		td,th{padding:3px 5px}
		td{text-align:right}
		th{text-align:left}  		
	</style>
	

  <body>
  	<h2>Disponibilità</h2>
  	<table >
    <?php
   		
		
		
		
		echo "<tr><th></th>";
		for ($i = 0; $i < 5; $i++) {
			 echo "<th> $giorni[$i] </th>";
		}
		 echo "</tr>";
		 
		 
		for ($i = 0; $i < 4; $i++) {//ore
			 echo "<tr> <th> $ore[$i] </th>";			 
			 for ($a = 0; $a < 5; $a++) {//giorni		 
			 	
			 	if(isset($arrayDisp[$ore[$i]][$giorni[$a]])){
			 		$valore=count($arrayDisp[$ore[$i]][$giorni[$a]]);
			 		echo"<td>$valore</td>";
			 		if($valore>$max){
			 			$max = $valore;
			 		}
			 		
			 	}else{
			 		echo"<td>0</td>";
			 	}		 		
			 
				
			}
			 echo "</tr>";	
		}
			
			 
			
				
		 
    ?>
    </table>
    <?php
   		
    
    foreach($ore as $ora) {
  		foreach($giorni as $giorno){		  			
  			if(isset($arrayDisp[$ora][$giorno])){
  				$prova=$arrayDisp[$ora][$giorno];  				
  				
  				if($max == count($prova)){
  					echo"<h2> Il giorno con massima disponibilità è: "." "."$giorno"." "."$ora"."<br></h2>";
  				
  					foreach($arrayNomi as $nome){
  						if ( !in_array ($nome,$prova))		echo "<b>".$nome."</b>"." Non ha dato disponibilita' per questo giorno-ora<br>"; 
  						
  					
  					}
  				}	
  			}
  		}		  
	}
    
    ?>
    <button name="riepilogo" onclick="location.href='form.php'">Nuova Disponibilità</button>
	
	
	<?php
		session_destroy();
	?>
	
  </body>
 </html>  
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 

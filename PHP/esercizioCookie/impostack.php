<?php
	$nome = "";
	$eta = 0;

	if(isset($_POST["send"])) {
		if(!empty($_POST["nome"]) && !empty($_POST["eta"])){
			session_start();
			setcookie("nome",$nome,time()+3600);
			setcookie("eta",$eta,time()+3600);
		}else{
			echo '<html>
							<head>
							</head>
							<body>
							<h1> ESERCIZIO </h1>
							<form>
								<fieldset action="impostack.php" method="post">
									Nome: <input type="text" name="'.$nome.'"/><br>
									eta: <input type="number" min="1" max="100" name="'.$eta.'"/><br> <br/>
											<input type="reset" value="Reset">
								</fieldset>
							<form>
							</body>
						</html>';
		}
	}
?>

<?php
    if(isset($_POST['send'])){
        if(!empty($_POST['id']) && !empty($_POST['cognome']) && !empty($_POST['nome']) && !empty($_POST['mail']) && !empty($_POST['tipologia'])){
        
            $id = $_POST['id'];
            $cognome = $_POST['cognome'];
            $nome = $_POST['nome'];
            $mail = $_POST['mail'];
            
            $connessione = new mysqli('localhost','root','','5C_Convention');
            if($connessione->connection_error){
                die('Errore di connessione ('.$connessione->connect_errno.')'. $connessione->connect_error);
            }
            $connessione->query("SET NAMES 'utf8'");
            
	        if(!empty($_POST['studente']) && !empty($_POST['professore'])){
                $temp_str = "INSERT INTO Partecipante(idPart, cognomePart, nomePart, mailPart, tipologiaPart) VALUES
	            ('".$id."', '".$cognome."', '".$nome."', '".$mail."','Libero Professionista')";	            
	        }
	        if(!empty($_POST['liberoProfessionista']) && !empty($_POST['professore'])){
                $temp_str = "INSERT INTO Partecipante(idPart, cognomePart, nomePart, mailPart, tipologiaPart) VALUES
	            ('".$id."', '".$cognome."', '".$nome."', '".$mail."','Studente')";	            
	        }
	        if(!empty($_POST['studente']) && !empty($_POST['liberoProfessionista'])){
                $temp_str = "INSERT INTO Partecipante(idPart, cognomePart, nomePart, mailPart, tipologiaPart) VALUES
	            ('".$id."', '".$cognome."', '".$nome."', '".$mail."','Professore')";	            
	        }
	        if (!$connessione->query($temp_str)) {
		        die("Errore nell'inserimento del cliente "+$connessione->error);
	        }
            echo '<html><head><title>Utente inserito con successo</title><body id="tabelle"><h3>Utente inserito con successo!</h3><br><a href="../index.php">Torna alla home page</a></body></html>';
        }else{
            echo '<html><h1 align="center"WARNING></h1><br><h3>riempi tutti i campi</h3><br><a href="../paginaIscrizione.html">Torna alla pagina iscrizione</a></html>';        
        }
    }
?>

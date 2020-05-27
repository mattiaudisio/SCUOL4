<?php
      include_once(__DIR__.'/Funzioni_PHP/connessione.php');
      $connessione = Connessione::apriConnessione();

      session_start();

      $errore = "";

          $mail = $_SESSION['mail_user'];
          $queryLogin = $connessione->query("SELECT Partecipante.passwordPart, Partecipante.idPart, Speech.titolo FROM Partecipante, Speech WHERE mailPart='".$mail."'");
          while($row = $queryLogin->fetch_assoc()){
                  $checkbox = $_POST['interessi'];
                  if($connessione->query($dml1) === TRUE){
                    for($i = 0; $i < sizeof($checkbox); $i++){
                      $query = "INSERT INTO Composto(idPart, idProgramma, nPartecipanti) VALUES  ('".$row[1]."','".$checkbox[$i]."','".$persone."');";
                      $connessione->query($query);
                      $quey2 = "SELECT Speech.numPosti FROM Speech";
                      while($var = $quey2->fetch_assoc()){
                        $posti = $var[0] - 1;
                        $query3 = "UPDATE Speech SET numPosti = ".$posti."  WHERE titolo = '".$row[3]."'";
                        $connessione->query($query3);
                      }
                    }
                  }
                  $queryEliminazionePosti = $connessione->query("SELECT ");
                  header("location: ../Sito/profilo.php");
        }
?>

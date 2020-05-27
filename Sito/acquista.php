<?php
      include_once(__DIR__.'/Funzioni_PHP/connessione.php');
      $connessione = Connessione::apriConnessione();

      session_start();

      $errore = "";

      if(isset($_POST['acquista'])){
        $mail = $_SESSION['mail_user'];
        $checkbox = $_POST['interessi'];

        $query0 = "SELECT Partecipante.passwordPart, Partecipante.idPart FROM Partecipante WHERE mailPart='".$mail."';";
        $queryLogin = $connessione->query($query0);
        if($row = $queryLogin->fetch_assoc()){
          for($i = 0; $i < sizeof($checkbox); $i++){
            $queryNum = "SELECT Composto.nPartecipanti FROM Composto WHERE idPart='".$row["idPart"]."';";
            $queryNumero = $connessione->query($queryNum);
            if($var = $queryNumero->fetch_assoc()){
              $persone = $var['nPartecipanti'] + 1;
            }
            $query = "INSERT INTO Composto(idPart, idProgramma, nPartecipanti) VALUES  ('".$row["idPart"]."','".$checkbox[$i]."','".$persone."');";
            if($connessione->query($query) === TRUE){
              for($i = 0; $i < sizeof($checkbox); $i++){
                $query2 = "SELECT Speech.numPosti FROM Speech";
                while($var = $query2->fetch_assoc()){
                  $posti = $var[0] - 1;
                  $query3 = "UPDATE Speech SET numPosti = ".$posti."  WHERE titolo = '".$row[3]."'";
                  $connessione->query($query3);
                }
              }
              header("location: ../Sito/profilo.php");
            }
          }
        }
      }
?>

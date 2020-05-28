<?php
      include_once(__DIR__.'/Funzioni_PHP/connessione.php');
      $connessione = Connessione::apriConnessione();

      session_start();

      $errore = "";

      if(isset($_POST['acquista'])){

        $checkbox = $_POST['interessi'];

        $query0 = "SELECT Partecipante.passwordPart, Partecipante.idPart FROM Partecipante WHERE Partecipante.idPart='".$_SESSION["idPart"]."';";
        $queryLogin = $connessione->query($query0);
        if($row = $queryLogin->fetch_assoc()){
          for($i = 0; $i < sizeof($checkbox); $i++){
            $queryNum = "SELECT Composto.nPartecipanti FROM Composto WHERE idPart='".$row["idPart"]."';";
            $queryNumero = $connessione->query($queryNum);
            if($var = $queryNumero->fetch_assoc()){
              $persone = $var['nPartecipanti'] - 1;
            }
            $query = "DELETE FROM Compsoto WHERE idPart = $row['idPart']";
            $connessione->query($query);
            for($i = 0; $i < sizeof($checkbox); $i++){
              $query2 = "SELECT Speech.numPosti, Speech.titolo FROM Speech";
              $querySpeech = $connessione->query($query2);
              while($var  = $querySpeech->fetch_assoc()){
                $posti = $var['numPosti'] + 1;
                $titolo = $var['titolo'];
                $connessione->query("UPDATE Speech SET numPosti = $posti  WHERE titolo = '$titolo'");
              }
            }
            header("location: ../Sito/profilo.php");
          }
        }
      }
?>

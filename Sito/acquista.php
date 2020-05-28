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
              $persone = $var['nPartecipanti'] + 1;
            }
            $query = "INSERT INTO Composto(idPart, idProgramma, nPartecipanti) VALUES  ('".$row["idPart"]."','".$checkbox[$i]."','".$persone."');";
            $connessione->query($query);
              $query2 = "SELECT Speech.numPosti, Speech.titolo FROM Speech";
              $querySpeech = $connessione->query($query2);
              while($var  = $querySpeech->fetch_assoc()){
                $posti = $var['numPosti'] - 1;
                $titolo = $var['titolo'];
                $connessione->query("UPDATE Speech SET numPosti = $posti  WHERE titolo = '$titolo'");
              }
            header("location: ../Sito/profilo.php");
          }
        }
      }

      if(isset($_POST['elimina'])){
          $checkbox = $_POST['interessi'];
          /*$queryLogin = $connessione->query("SELECT Partecipante.passwordPart, Partecipante.idPart, Programma.idProgramma FROM Partecipante, Programma, Composto WHERE Partecipante.idPart='".$_SESSION["idPart"]."' AND Partecipante.idPart = Composto.idPart AND Composto.idProgramma = Programma.idProgramma");
          if($row = $queryLogin->fetch_assoc()){
            if($row == TRUE){
                $idPart = $row['idPart'];
                $idProgramma = $row['idProgramma'];
                $querySpeech = $connessione->query("SELECT Speech.numPosti, Speech.titolo, Sala.nPostiSala FROM Speech,Sala");
                while($var  = $querySpeech->fetch_assoc()){
                    $posti = $var['numPosti'] + 1;
                    $titolo = $var['titolo'];
                    $connessione->query("UPDATE Speech SET numPosti = $posti  WHERE titolo = '$titolo'");
                 }
                 header("location: ../Sito/profilo.php");
            }
          }*/
          for($i = 0; $i < sizeof($checkbox); $i++){
            $idPart = $_SESSION['idPart'];
            $queryEliminazione = $connessione->query("DELETE FROM Compsoto WHERE Composto.idPart = $idPart AND Composto.idProgramma = $checkbox[$i]");
            /*while($var  = $queryEliminazione->fetch_row()){
                if($var == TRUE){
                  $posti = $var['numPosti'] + 1;
                  $titolo = $var['titolo'];
                  $connessione->query("UPDATE Speech SET numPosti = $posti  WHERE titolo = '$titolo'");
                }
             }*/
             header("location: ../Sito/profilo.php");
          }
        }
?>

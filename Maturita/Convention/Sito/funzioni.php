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
    $query0 = "SELECT Partecipante.passwordPart, Partecipante.idPart FROM Partecipante WHERE Partecipante.idPart='".$_SESSION["idPart"]."';";
    $queryLogin = $connessione->query($query0);
    if($row = $queryLogin->fetch_assoc()){
      for($i = 0; $i < sizeof($checkbox); $i++){
        $queryEliminazione = $connessione->query("DELETE FROM Composto WHERE Composto.idPart = '".$row["idPart"]."' AND Composto.idProgramma = '".$checkbox[$i]."';");
        header("location: ../Sito/profilo.php");
      }
    }
  }

  if(isset($_POST['login'])){
    if(!empty($_POST['mail'])|| !empty($_POST['password'])){
      $mail = $_POST['mail'];
      $password = hash('sha256',$_POST['password']);
      $queryLogin = $connessione->query("SELECT Partecipante.idPart FROM Partecipante WHERE Partecipante.mailPart='$mail' AND Partecipante.passwordPart='$password';");
      if($queryLogin -> num_rows){
        while ($riga = $queryLogin -> fetch_assoc()){
          session_start();
          $_SESSION['idPart'] = $riga['idPart'];
          header('location:profilo.php');
        }
      }else{
        echo "<script type='text/javascript'>alert('I dati inseriti sono errati, correggili per accedere');</script>";
        header('location: index.php#login');
      }
    }else{
      echo "<script type='text/javascript'>alert('I Inserisci tutti i dati');</script>";
      header('location: index.php#login');
    }
  }
?>


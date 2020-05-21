<?php
  class Acquista{

    static function aquistaSpeech(){
      include_once(__DIR__.'/connesione.php');
      $connessione = Connessione::apriConnessione();

      $errore = "";

      if(isset($_POST['acqusita'])){
        if(!empty($_POST['mail']) || !empty($_POST['password'])){
          $errore = "Errore durante l'acquisto";
          header("location: ../Sito/profilo.php");
        }else{
          $mail = $_POST['mail'];
          $password = $_POST['password'];
          $queryLogin = $connessione->query("SELECT Partecipante.mailPart, Partecipante.passwordPart, Partecipante.idPart, Speech.titolo FROM Partecipante, Speech WHERE mailPart='".$mail."'");
          while($row = $queryLogin->fetch_assoc()){
              if(password_verify($password,$row[1])){
                  $passwordCifrata = hash('sha256',$_POST['password']);
                  $checkbox = $_POST['interessi'];
                  if($connessione->query($dml1) === TRUE){
                    for($i = 0; $i < sizeof($checkbox); $i++){
                      $query = "INSERT INTO Composto(idPart, idProgramma, nPartecipanti) VALUES  ('".$row[2]."','".$checkbox[$i]."','".$persone."');";
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
              }else{
                $errore = "Errore durante l'acquisto";
                header("location: ../Sito/profilo.php");
              }
          }
        }
      }else{
        $errore = "Errore durante l'acquisto";
        header("location: ../Sito/profilo.php");
      }
    }
  }
?>

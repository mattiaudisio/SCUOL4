<?php
  class Acquista{

    static function aquistaSpeech(){
      include_once(__DIR__.'/connesione.php');
      $connessione = Connessione::apriConnessione();

      $errore = "";

      if(isset($_POST['acqusita'])){
        if(!empty($_POST['mail']) || !empty($_POST['password'])){
          $errore = "Errore durante l'acquisto"
          header("location: profilo.php");
        }else{
          $mail = $_POST['mail'];
          $password = $_POST['password'];
          $queryLogin = $connessione->query("SELECT Partecipante.mailPart, Partecipante.passwordPart, Partecipante.idPart FROM Partecipante WHERE mailPart='".$mail."'");
          while($row = $queryLogin->fetch_assoc()){
              if(password_verify($password,$row[1])){
                  $passwordCifrata = hash('sha256',$_POST['password']);
                  $checkbox = $_POST['interessi'];
                  if($connessione->query($dml1) === TRUE){
                    for($i = 0; $i < sizeof($checkbox); $i++){
                      $query = "INSERT INTO Composto(idPart, idProgramma, nPartecipanti) VALUES  ('".$row[2]."','".$checkbox[$i]."','".$persone."');";
                      $connessione->query($query);
                    }
                  }
                  $queryEliminazionePosti = $connessione->query("SELECT ");
                  header("location: profilo.php");
              }else{
                $errore = "Errore durante l'acquisto"
                header("location: profilo.php");
              }
          }else{
              $errore = "Errore durante l'acquisto"
              header("location: profilo.php");
          }
        }
      }else{
        $errore = "Errore durante l'acquisto"
        header("location: profilo.php");
      }
    }
  }
?>

<?php
  class Acquista{

    static function aquistaSpeech(){
      include_once(__DIR__.'/connesione.php');
      $connesione = Connesione::apriConnessione();

      $errore = "";

      if(isset($_POST['acqusita'])){
        if(!empty($_POST['mail']) || !empty($_POST['password'])){
          $errore = "Errore durante l'acquisto"
          header("location: profilo.php");
        }else{
          $mail = $_POST['mail'];
          $password = $_POST['password'];
          $queryLogin = $connesione->query("SELECT Partecipante.mailPart, Partecipante.passwordPart FROM Partecipante WHERE mailPart='".$mail."'");
          if($row = $queryLogin->fetch_row()){
              if(password_verify($password,$row[1])){
                  $passwordCifrata = hash('sha256',$_POST['password']);
                  $checkbox = $_POST['interessi'];
                  $string = count($arrayID) + 1;
                  $totPersone = count($arrayComposto);
                  $dml1 = "INSERT INTO Partecipante(idPart, cognomePart, nomePart, mailPart, tipologiaPart,passwordPart) VALUES ('".$string."','".$_POST["cognome"]."','".$_POST["nome"]."','".$_POST["mail"]."','".$_POST["tipologia"]."','".$passwordCifrata."');";
                  if($connessione->query($dml1) === TRUE){
                    for($i = 0; $i < sizeof($checkbox); $i++){
                      $persone = $totPersone + 1;
                      $query = "INSERT INTO Composto(idPart, idProgramma, nPartecipanti) VALUES  ('".$string."','".$checkbox[$i]."','".$persone."');";
                      $connessione->query($query);
                    }
                  }
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

<?php
  include_once(__DIR__.'/connessione.php');
  $connessione = Connessione::apriConnessione();

  session_start();

  $errore = "";

  if(isset($_POST['accedi'])){
    if(empty($_POST['mail']) || empty($_POST['password']) ){
      $errore = "Mail o password non valida";
      header("location: ../login.php");
    }else{
      $mail = $_POST['mail'];
      $password = hash('sha256',$_POST['password']);

      $queryLogin = $connessione->query("SELECT Partecipante.mailPart, Partecipante.passwordPart FROM Partecipante WHERE Partecipante.mailPart='".$mail."';");
      if($row = $queryLogin->fetch_row()){
        if(password_verify($password,$row[1])){
          $errore = "Mail o password non corrette";
          header("location: ../index.php");
        }else{
          $_SESSION['mail_user'] = $mail;
          header("location: ../profilo.php");
        }
      }
    }
    $connessione->close();
  }else{
    $errore = "Mail o password non corrette";
    header("location: ../Sito/index.php");
  }
?>

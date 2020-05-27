<?php
  include_once(__DIR__.'/Funzioni_PHP/connessione.php');
  $connessione = Connessione::apriConnessione();

  session_start();

  $errore = '';
  if (isset($_POST['submit'])) {
    if (empty($_POST['mail']) || empty($_POST['password'])) {
      $error = "Mail o password non valida";
      header("location: login.php");
    }else{
      $mail = $_POST['mail'];
      $password = hash('sha256',$_POST['password']);
      //$password = $_POST['password'];

      $queryLogin = $connessione->query("SELECT Partecipante.passwordPart FROM Partecipante WHERE Partecipante.mailPart='".$mail."';");

      if($row = $queryLogin->fetch_assoc()){
        if(password_verify($password, $row['passwordPart'])){
          $_SESSION['mail_user'] = $mail;
          header("location: ../Sito/profilo.php");
        }else {
          $errore = "Mail o password non corrette";
          header("location: ../Sito/index.php");
        }
      }else{
        $errore = "Mail o password non corrette";
        header("location: ../Sito/login.php");
      }
    }
    $connessione->close();
  }else{
    $errore = "Mail o password non corrette";
    header("location: ../Sito/login.php");
  }
?>

<?php
  include_once(__DIR__.'/Funzioni_PHP/connessione.php');
  include_once(__DIR__.'/Funzioni_PHP/connessione.php');
  include_once(__DIR__.'/Funzioni_PHP/programma.php');
  include_once(__DIR__.'/Funzioni_PHP/composto.php');
  include_once(__DIR__.'/Funzioni_PHP/partecipante.php');
  include_once(__DIR__.'/header_autenticazione.php');
  
  $connessione = Connessione::apriConnessione();

  session_start();

  $errore = "";

  if(isset($_POST['accedi'])){
    if(empty($_POST['mail']) || empty($_POST['password']) ){
      $errore = "Mail o password non valida";
      header("location: ../Sito/login.php");
    }else{
      $mail = $_POST['mail'];
      $password = hash('sha256',$_POST['password']);

      $queryLogin = $connessione->query("SELECT Partecipante.mailPart, Partecipante.passwordPart FROM Partecipante WHERE Partecipante.mailPart='".$mail."';");
      if($row = $queryLogin->fetch_row()){
        if(password_verify($password,$row[1])){
          $errore = "Mail o password non corrette";
          header("location: ../Sito/login.php");
        }else{
          $_SESSION['mail_user'] = $mail;
          header("location: ../Sito/profilo.php");
        }
      }
    }
    $connessione->close();
  }else{
    $errore = "Mail o password non corrette";
    header("location: ../Sito/index.php");
  }
?>

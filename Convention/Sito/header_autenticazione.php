<?php
include_once(__DIR__.'/Funzioni_PHP/connessione.php');
include_once(__DIR__.'/Funzioni_PHP/funzioni.php');

$connessione = Connessione::apriConnessione();

session_start();
session_destroy();

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
      }
    }
  }
?>

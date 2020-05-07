<?php
  session_start();
  if(!isset($_POST['mail']) || !isset($_POST['password'])){
    header('location: Funzioni_PHP/login_failed.php');
    exit;
  }else{
    $mail = $_POST['mail'];
    $password = $_POST['password'];

    $_SESSION['mail'] = $mail;
    $_SESSION['password'] = $password;
  }
?>

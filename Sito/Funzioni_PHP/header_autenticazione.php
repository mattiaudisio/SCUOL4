<?php
  session_start();
  if(!isset($_SESSION['mail']) || !isset($_SESSION['password'])){
    header('location: Funzioni_PHP/login_failed.php');
    exit;
  }
?>

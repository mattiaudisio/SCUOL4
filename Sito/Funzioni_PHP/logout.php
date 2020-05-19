<?php
  if(isset($_POST["logout"])){
    session_start();
    session_destroy();
    header('location: /Mattia/ProgettoSQL_Convention/Sito/login.php');
  }
?>

<?php
    session_start();
    session_destroy();
    header('location: /Mattia/Convention/Sito/login.php');
?>

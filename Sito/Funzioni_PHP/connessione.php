<?php
    $connessione = new mysqli("localhost", "root", "", "5C_Convention");

    if ($connessione->connect_errno) {
            echo "Connessione fallita: ". $connessione->connect_error . ".";
    }

    $connessione->query("SET NAMES 'utf8'");
?>

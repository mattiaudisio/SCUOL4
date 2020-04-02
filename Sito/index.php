<?php
    $connessione = new mysqli('localhost','root','','5C_Convention');
    if($connessione->connection_error){
        die('Errore di connessione ('.$connessione->connect_errno.')'. $connessione->connect_error);
    }else{
        echo 'Connesso. ' . $connessione->host_info . "\n";
    }
    $connessione -> query("SET NAMES 'utf8'");
?>

<html>
    <head>
        <title>Convention Audisio</title>  
    </head>
    <body>
        <div align="center">
            <h1> <b>Convention Audisio</b> </h1>
        </div>
        <div align="center">
            <h3> <a href="../Sito/paginaIscrizione.html">Iscrizione</a> <br> </h3>
            <h3> <a href="../Sito/paginaRiepilogo.php">Riepilogo</a> </h3>
        </div>
    </body>
    <footer>
    </footer>
</html>

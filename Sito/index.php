<?php
    $connessione = new msqli('localhost','root','','5C_Convention');
    if($connessione->connection_error){
        die('Errore di connessione ('.$connessione->connect_errno.')'. $connessione->connect_error);
    }
    $connessione -> query("SET NAMES 'utf8'");
?>

<html>
    <head>
        <title>Convention Audisio</title>  
    </head>
    <body>
        <div align="center">Convention Audisio</div>
        <?php
            $risultato = $connessione->("SELECT * FROM Azienda");
            while($tabella = $risultato->fetch_assoc()){
                echo $tabella['idAzienda'];
                echo "<br />";
            }
        ?>
    </body>
    <footer>
    </footer>
</html>

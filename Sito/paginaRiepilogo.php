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
        <div align="center"><h1>Riepilogo</h1></div><br>
        <p>Nome Evento - Numero Partecipanti</p>
        <?php
            $risultato = $connessione->("SELECT Speech.titolo, Composto.nPartecipanti FROM Speech, Programma, Composto WHERE Programma.idSpeech = Speech.idSpeech, AND Programma.idProgramma = Composto.idProgramma, ORDER BY Speech.titolo");
            while($tabella = $risultato->fetch_assoc()){
                echo "<ul>".$tabella['titolo']." - ".$tabella['nPartecipanti']."</ul><br>";
                echo "<br />";
            }
        ?>
    </body>
    <footer>
    </footer>
</html>

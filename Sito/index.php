<html>

    <head>
        <?php
            $connessione = new msqli('localhost','root','','5C_Convention');
            if($connessione->connection_error){
                die('Errore di connessione ('.$connessione->connect_errno.')'. $connessione->connect_error);
            }
        ?>
    </head>

    <body>

    </body>

    <footer>

    </footer>

</html>

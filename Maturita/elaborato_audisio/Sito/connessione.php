<?php
    Class Connessione{
        static function apriConnessione(){
          $connessione = new mysqli("localhost", "root", "", "parchi_audisio");

          if ($connessione->connect_errno) {
            echo "Connessione fallita: ". $connessione->connect_error . ".";
          }

          $connessione->query("SET NAMES 'utf8'");

          return $connessione;
        }
    }
?>

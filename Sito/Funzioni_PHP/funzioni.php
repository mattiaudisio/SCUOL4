<?php
  include_once(__DIR__.'/connessione.php');
  $connessione = Connessione::apriConnessione();



  function apriSessione($idPart){
    session_start();
    $_SESSION['idPart'] = $idPart;
    header('lcoation:profilo.php');
  }

?>

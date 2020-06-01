<?
  include_once(__DIR__.'/Funzioni_PHP/connessione.php');
  include_once(__DIR__.'/Funzioni_PHP/programma.php');
  include_once(__DIR__.'/Funzioni_PHP/composto.php');

  $prova = 0;
  $arrayID = array();
  $arrayProvaPresenza = array();
  $arrayProgramma = array();
  $arrayComposto = array();

  $connessione = Connessione::apriConnessione();

  session_start();

  $queryPartecipante = "SELECT Partecipante.idPart FROM Partecipante;";
  $risultatoPartecipante = $connessione->query($queryPartecipante);
  while($ris = $risultatoPartecipante->fetch_assoc()){
    $risId = $ris["idPart"];
    array_push($arrayID,$risId);
  }

  $queryComposto = "SELECT * FROM Composto;";
  $risultatoComposto = $connessione->query($queryComposto);
  while($ris = $risultatoComposto->fetch_assoc()){
    $risPart = $ris["idPart"];
    $risProg = $ris["idProgramma"];
    $risNPart = $ris["nPartecipanti"];
    $nuovoOggetto = new Composto($risPart,$risProg,$risNPart);
    array_push($arrayComposto,$nuovoOggetto);
  }

  $queryPartecipante = "SELECT Partecipante.nomePart, Partecipante.cognomePart, Partecipante.mailPart FROM Partecipante;";
  $risultatoPartecipante = $connessione->query($queryPartecipante);
  while($ris = $risultatoPartecipante->fetch_assoc()){
    $risNome = $ris["nomePart"];
    $risCognome = $ris["cognomePart"];
    $risMail = $ris["mailPart"];
    if($_POST['cognome'] == $risCognome && $_POST['nome'] == $risNome && $_POST['mail'] == $risMail){
        header("location:iscriviti.php");
    }
  }

  $contaPresenza = 0;
  for ($i=0; $i < count($arrayProvaPresenza); $i++) {
    if($arrayProvaPresenza[$i] == "true"){
        $contaPresenza = $contaPresenza + 1;
    }
  }

  if($contaPresenza == 0){
    if(isset($_POST['iscriviti'])){
      if(!empty($_POST['cognome']) && !empty($_POST['nome']) && !empty($_POST['mail']) && !empty($_POST['tipologia']) && !empty($_POST['password'])){
        $passwordCifrata = hash('sha256',$_POST['password']);
        $checkbox = $_POST['interessi'];
        $_SESSION['mail_user'] = $_POST['mail'];
        $string = count($arrayID) + 1;
        $totPersone = count($arrayComposto);
        $dml1 = "INSERT INTO Partecipante(idPart, cognomePart, nomePart, mailPart, tipologiaPart,passwordPart) VALUES ('".$string."','".$_POST["cognome"]."','".$_POST["nome"]."','".$_POST["mail"]."','".$_POST["tipologia"]."','".$passwordCifrata."');";
        if($connessione->query($dml1) === TRUE){
          for($i = 0; $i < sizeof($checkbox); $i++){
            $persone = $totPersone + 1;
            $query = "INSERT INTO Composto(idPart, idProgramma, nPartecipanti) VALUES  ('".$string."','".$checkbox[$i]."','".$persone."');";
            $connessione->query($query);
          }
          $queryProgramma = "SELECT * FROM Programma,Speech,Sala WHERE Programma.idSpeech = Speech.idSpeech AND Programma.idSala = Sala.idSala;";
          $risQuery = $connessione->query($queryProgramma);
          while($ris = $risQuery->fetch_assoc()){
            $risIdProgr = $ris["idProgramma"];
            $risFascia = $ris["fasciaOraria"];
            $risTitolo = $ris["titolo"];
            $risPosti = $ris["numPosti"];
            $risIdSala = $ris["idSala"];
            $risImmagine = $ris["immagine"];
            $nuovoOggetto = new Programma($risFascia,$risTitolo,$risPosti,$risIdProgr,$risIdSala,$risImmagine);
            array_push($arrayProgramma,$nuovoOggetto);
          }
          $posti = $arrayProgramma[$i]->getNPosti() - 1;
          $titolo = $arrayProgramma[$i]->getTitolo();
          $query = "UPDATE Speech SET numPosti = ".$posti."  WHERE titolo = '".$titolo."'";
          $connessione->query($query);
          header("location:profilo.php");
        }
      }else{
        header("location:iscriviti.php");
      }
    }
  }
  $connessione->close();
?>


<?
  include_once(__DIR__.'/connessione.php');

  $connessione = Connessione::apriConnessione();

  if(isset($_POST['login'])){
    if(!empty($_POST['mailGuardia']) || !empty($_POST['passwordGuardia'])){
      $mail = $_POST['mailGuardia'];
      $password = hash('sha256',$_POST['passwordGuardia']);
      $queryLogin = $connessione->query("SELECT GuardiaParco.codGuardia FROM GuardiaParco WHERE GuardiaParco.mailGuardia='$mail' AND GuardiaParco.passwordGuardia='$password'");
      if($queryLogin -> num_rows){
        while ($riga = $queryLogin -> fetch_assoc()){
          session_start();
          $_SESSION['codFiscaleGuardia'] = $riga['codGuardia'];
          header('location:profilo.php');
        }
      }else{
        header('location: login.php');
      }
    }else{
      header('location: login.php');
    }
  }
?>

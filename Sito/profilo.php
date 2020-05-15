<!DOCTYPE html>
<html>

<head>
  <meta charset="utf-8">
  <meta content="width=device-width, initial-scale=1.0" name="viewport">
  <title>Convito | Convention Torinese</title>
  <meta content="" name="descriptison">
  <meta content="" name="keywords">
  <!-- Favicons -->
  <link href="/Mattia/ProgettoSQL_Convention/Sito/assets/img/favicon.png" rel="icon">
  <link href="/Mattia/ProgettoSQL_Convention/Sito/assets/img/apple-touch-icon.png" rel="apple-touch-icon">
  <!-- Google Fonts -->
  <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Muli:300,300i,400,400i,500,500i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i" rel="stylesheet">
  <!-- Vendor CSS Files -->
  <link href="/Mattia/ProgettoSQL_Convention/Sito/assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link href="/Mattia/ProgettoSQL_Convention/Sito/assets/vendor/icofont/icofont.min.css" rel="stylesheet">
  <link href="/Mattia/ProgettoSQL_Convention/Sito/assets/vendor/boxicons/css/boxicons.min.css" rel="stylesheet">
  <link href="/Mattia/ProgettoSQL_Convention/Sito/assets/vendor/animate.css/animate.min.css" rel="stylesheet">
  <link href="/Mattia/ProgettoSQL_Convention/Sito/assets/vendor/venobox/venobox.css" rel="stylesheet">
  <link href="/Mattia/ProgettoSQL_Convention/Sito/assets/vendor/owl.carousel/assets/owl.carousel.min.css" rel="stylesheet">
  <link href="/Mattia/ProgettoSQL_Convention/Sito/assets/vendor/aos/aos.css" rel="stylesheet">
  <!-- Template Main CSS File -->
  <link href="/Mattia/ProgettoSQL_Convention/Sito/assets/css/style.css" rel="stylesheet">
  <!-- =======================================================
  * Template Name: Flattern - v2.0.0
  * Template URL: https://bootstrapmade.com/flattern-multipurpose-bootstrap-template/
  * Author: BootstrapMade.com
  * License: https://bootstrapmade.com/license/
  ======================================================== -->
</head>
  <body>
    <!-- ======= Header ======= -->
    <header id="header">
      <div class="container d-flex">
        <div class="logo mr-auto">
          <h1 class="text-light"><a href="index.php">convito</a></h1>
          <!-- Uncomment below if you prefer to use an image logo -->
          <!-- <a href="index.html"><img src="assets/img/logo.png" alt="" class="img-fluid"></a>-->
        </div>
        <nav class="nav-menu d-none d-lg-block">
          <ul>
            <li><a href="index.php">Home</a></li>
            <li><a href="index.php#speaker">Speaker</a></li>
            <li><a href="index.php#programma">Programma</a></li>
            <li><a href="iscriviti.php">Iscriviti</a></li>
            <li class="active"><a href="login.php">Accedi</a></li>
          </ul>
        </nav><!-- .nav-menu -->
      </div>
    </header><!-- End Header -->
    <!-- ======= Hero Section ======= -->
    <section id="hero">
      <div id="heroCarousel" class="carousel slide carousel-fade" data-ride="carousel">
          <div class="carousel-item active" style="background-image: url(/Mattia/ProgettoSQL_Convention/Sito/assets/img/wallpaper.jpeg);">
            <div class="container">
              <div class="carousel-content animated fadeInUp">
                <h2 align="center"> <span>CONVITO</span></h2>
                <p align="center">12 settembre 2020, Lingotto Fiere Torino, Torino</p>
              </div>
            </div>
          </div>
      </div>
    </section><!-- End Hero -->
    <main id="main">
      <?php
        include 'Funzioni_PHP/connessione.php';
        include 'Funzioni_PHP/programma.php';
        include 'Funzioni_PHP/composto.php';
        include 'Funzioni_PHP/partecipante.php';
        include 'Funzioni_PHP/header_autenticazione.php';

        $arrayPartecipante = array();
        $arrayComposto = array();
        $arrayProgramma = array();
        $arrayProgrammaTemporaneo = array();
        $arrayID = array();


        $nomeUtente = "";
        $cognomeUtente = "";
        $mailUtente = "";

        $queryPartecipante = "SELECT * FROM Partecipante;";
        $risultatoPartecipante = $connessione->query($queryPartecipante);
        while($ris = $risultatoPartecipante->fetch_assoc()){
          $risId = $ris["idPart"];
          $risCognome = $ris["cognomePart"];
          $risNome =  $ris["nomePart"];
          $risMail =  $ris["mailPart"];
          $risTipologia =  $ris["tipologiaPart"];
          $risPassword = $ris["passwordPart"];
          $nuovoOggetto = new Partecipante($risId,$risCognome,$risNome,$risMail,$risTipologia,$risPassword);
          array_push($arrayPartecipante,$nuovoOggetto);
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

        $queryProgramma = "SELECT * FROM Programma,Speech,Sala WHERE Programma.idSpeech = Speech.idSpeech AND Programma.idSala = Sala.idSala;";
        $risultatoProgramma = $connessione->query($queryProgramma);
        while($ris = $risultatoProgramma->fetch_assoc()){
          $risIdProgr = $ris["idProgramma"];
          $risFascia = $ris["fasciaOraria"];
          $risTitolo = $ris["titolo"];
          $risPosti = $ris["nPostiSala"];
          $risIdSala = $ris["idSala"];
          $nuovoOggetto = new Programma($risFascia,$risTitolo,$risPosti,$risIdProgr,$risIdSala);
          array_push($arrayProgramma,$nuovoOggetto);
        }

        $queryProgramma = "SELECT * FROM Programma,Speech,Sala WHERE Programma.idSpeech = Speech.idSpeech AND Programma.idSala = Sala.idSala;";
        $risultatoProgramma = $connessione->query($queryProgramma);
        while($ris = $risultatoProgramma->fetch_assoc()){
          $risIdProgr = $ris["idProgramma"];
          $risFascia = $ris["fasciaOraria"];
          $risTitolo = $ris["titolo"];
          $risPosti = $ris["nPostiSala"];
          $risIdSala = $ris["idSala"];
          $nuovoOggetto = new Programma($risFascia,$risTitolo,$risPosti,$risIdProgr,$risIdSala);
          array_push($arrayProgrammaTemporaneo,$nuovoOggetto);
        }

        $queryPartecipante = "SELECT Partecipante.idPart FROM Partecipante;";
        $risultatoPartecipante = $connessione->query($queryPartecipante);
        while($ris = $risultatoPartecipante->fetch_assoc()){
          $risId = $ris["idPart"];
          array_push($arrayID,$risId);
        }

        if(isset($_POST['accedi']) || isset($_POST['acquista'])){
          if(isset($_POST['acquista'])){
              $string = count($arrayID) + 1;
              $totPersone = count($arrayComposto);
              $checkbox = $_POST['interessi'];
              for($i = 0; $i < sizeof($checkbox); $i++){
                $persone = $totPersone + 1;
                $query = "INSERT INTO Composto(idPart, idProgramma, nPartecipanti) VALUES  ('".$string."','".$checkbox[$i]."','".$persone."');";
                $connessione->query($query);
                if(isset($_POST['acquista'])){
                  $posti = $arrayProgramma[$i]->getNPosti() - 1;
                  $nome = $arrayProgramma[$i]->getIdSala();
                  $query = "UPDATE Sala SET nPostiSala = ".$posti." , WHERE idProgramma = '".$nome."'";
                  $connessione->query($query);
                }
              }
          }
          if(!empty($_POST['mail']) && !empty($_POST['password']) ){
            $mailUtente = $_SESSION['mail'];
            $passwordUtente = $_SESSION['password'];
            $passwordCifrata = hash('sha256',$passwordUtente); ?>
            <section id="about-us" class="about-us">
              <div class="container">
                <div class="row no-gutters">
                  <div class="image col-xl-5 d-flex align-items-stretch justify-content-center justify-content-lg-start" data-aos="fade-right" style="background-image: url(/Mattia/ProgettoSQL_Convention/Sito/assets/img/riepilogo.jpg);"></div>
                    <div class="col-xl-7 pl-0 pl-lg-5 pr-lg-1 d-flex align-items-stretch">
                          <?php
                                for($i = 0; $i < count($arrayPartecipante); $i++){
                                  $MailUtenteFor = $arrayPartecipante[$i]->getMailPart();
                                  $passwordUtente = $arrayPartecipante[$i]->getPasswordPart();
                                      if($MailUtenteFor == $mailUtente  || $passwordUtente == $passwordCifrata){
                                        $nomeUtente = $arrayPartecipante[$i]->getIdPart();
                                        $cognomeUtente = $arrayPartecipante[$i]->getCognomePart();
                                        $mailUtente = $arrayPartecipante[$i]->getMailPart(); ?>
                                        <div class="content d-flex flex-column justify-content-center">
                                            <h3 data-aos="fade-up"> <?php echo $arrayPartecipante[$i]->getNomePart(); ?> <?php echo $cognomeUtente;?></h3>
                                            <p data-aos="fade-up"> <?php echo $mailUtente; ?>, <?php echo $arrayPartecipante[$i]->getTipologiaPart();?></p>
                                            <div class="row">
                                              <div class="col-md-6 icon-box" data-aos="fade-up">
                                                <h2>SPEECH</h2>
                                                <?php
                                                 for($j = 0; $j < count($arrayComposto); $j++){
                                                  for($z = 0; $z < count($arrayProgramma); $z++){
                                                    $composto = $arrayComposto[$j]->getIdProgramma();
                                                    $programma = $arrayProgramma[$z]->getIdProgramma();
                                                    $composto2 = $arrayComposto[$j]->getIdPart();
                                                    if($composto == $programma && $nomeUtente == $composto2){
                                                      echo '<h4>'.$arrayProgramma[$z]->getTitolo().'</h4>';
                                                      unset($arrayProgrammaTemporaneo[$z]);
                                                    }
                                                  }
                                                }
                                                $tipologia = $arrayPartecipante[$i]->getTipologiaPart();
                                                if($tipologia == "docente" || $tipologia == "liberoProfessionista" ){
                                                     echo '<div class="col-md-6 icon-box" data-aos="fade-up">
                                                             <h4>Speech Premiazione</h4>
                                                             <p>Ordinato</p>
                                                          </div>';
                                               }
                                      }
                                } ?>
                                  </div>
                                </div>
                              </div><!-- End .content-->
                            </div>
                          </div>
                          <br>
                          <section id="contact" class="contact">
                          <div class="row mt-5 justify-content-center" data-aos="fade-up">
                            <div class="col-lg-10">
                              <div class="section-title" data-aos="fade-up">
                                <h2>Acquista altri<strong>Biglietti</strong></h2>
                              </div>
                              <form action="profilo.php" method="post">
                                <div class="container" >
                                    <p>Mail:</p>
                                    <input type="email" name="mail"  class="form-control" id="email" placeholder="Inserisci la tua mail" data-rule="minlen:4" data-msg="Inserisci la tua mail" />
                                    <br>
                                    <p>Password:</p>
                                    <input type="password" name="password"  class="form-control" id="password" placeholder="Inserisci una password" data-rule="minlen:4" data-msg="Inserisci una password" />
                                    <br>
                                    <p>Programmi:</p>
                                    <?php
                                      $arrayCompostoTemp = array();
                                      $queryCompostoTemp = "SELECT * FROM Composto WHERE idPart = '".$nomeUtente."';";
                                      $risultato = $connessione->query($queryCompostoTemp);
                                      while($news2 = $risultato->fetch_array(MYSQLI_NUM)){
                                        array_push($arrayCompostoTemp,$news2[1]);
                                      }

                                      $queryProgramma = "SELECT * FROM Programma,Speech,Sala WHERE Programma.idSpeech = Speech.idSpeech AND Programma.idSala = Sala.idSala;";
                                      $risultato = $connessione->query($queryProgramma);
                                      while($whileProgramma = $risultato->fetch_array(MYSQLI_NUM)){
                                        if(!in_array($whileProgramma[0],$arrayCompostoTemp)){
                                          echo '<input type="checkbox" name="interessi[]" value="'.$whileProgramma[0].'">'.$whileProgramma[5].'<br>';
                                        }
                                      }
                                    ?>
                                    <div class="text-center" ><input type="submit" value="acquista" name="acquista"></div>
                                </div>
                              </form>
                              <br>
                            </div>
                          </div>
                          </section>
                          <form action="Funzioni_PHP/logout.php" method="post">
                            <input id="button" type="submit" name="logout" value="logout">
                          </form>
                        </div>
                      </section>
                    <?php }
          $connessione->close();
          }
          ?>

    </main><!-- End #main -->
    <!-- ======= Footer ======= -->
    <footer id="footer">
      <div class="footer-top">
        <div class="container">
          <div class="row">

            <div class="col-lg-3 col-md-6 footer-contact">
              <h3>convito</h3>
              <p>
                 Via Nizza, 294 <br>
                10126 Torino TO<br>
                Italia <br><br>
              </p>
            </div>
          </div>
        </div>
      </div>
    </footer><!-- End Footer -->
    <a href="#" class="back-to-top"><i class="icofont-simple-up"></i></a>
    <!-- Vendor JS Files -->
    <script src="assets/vendor/jquery/jquery.min.js"></script>
    <script src="assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
    <script src="assets/vendor/jquery.easing/jquery.easing.min.js"></script>
    <script src="assets/vendor/php-email-form/validate.js"></script>
    <script src="assets/vendor/jquery-sticky/jquery.sticky.js"></script>
    <script src="assets/vendor/isotope-layout/isotope.pkgd.min.js"></script>
    <script src="assets/vendor/venobox/venobox.min.js"></script>
    <script src="assets/vendor/waypoints/jquery.waypoints.min.js"></script>
    <script src="assets/vendor/owl.carousel/owl.carousel.min.js"></script>
    <script src="assets/vendor/aos/aos.js"></script>
    <!-- Template Main JS File -->
    <script src="assets/js/main.js"></script>
  </body>
</html>

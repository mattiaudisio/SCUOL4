<?php
  include 'Funzioni_PHP/connessione.php';
  include 'Funzioni_PHP/relatore.php';
  include 'Funzioni_PHP/speech.php';
  include 'Funzioni_PHP/programma.php';


  $arraySpeech = array();
  $arrayRelatore = array();
  $arrayProgramma = array();

  $querySpeech = "SELECT Speech.titolo, Speech.argomento FROM Speech;";
  $queryRelatori = "SELECT Relatore.cognomeRel, Relatore.nomeRel, Relatore.idAzienda FROM Relatore;";
  $queryProgramma = "SELECT * FROM Programma,Speech,Sala WHERE Programma.idSpeech = Speech.idSpeech AND Programma.idSala = Sala.idSala;";

  $risultatoSpeech = $connessione->query($querySpeech);
  $risultatoRelatori = $connessione->query($queryRelatori);
  $risultatoProgramma = $connessione->query($queryProgramma);

  while($ris = $risultatoSpeech->fetch_assoc()){
    $risTitolo = $ris["titolo"];
    $risArgomento = $ris["argomento"];
    $nuovoOggetto = new Speech($risTitolo,$risArgomento);
    array_push($arraySpeech,$nuovoOggetto);
  }
  while($ris = $risultatoRelatori->fetch_assoc()){
      $risCognome = $ris["cognomeRel"];
      $risNome = $ris["nomeRel"];
      $risAzienda = $ris["idAzienda"];
      $nuovoOggetto = new Relatore($risCognome,$risNome,$risAzienda);
      array_push($arrayRelatore,$nuovoOggetto);
  }
  while($ris = $risultatoProgramma->fetch_assoc()){
    $risIdProgr = $ris["idProgramma"];
    $risFascia = $ris["fasciaOraria"];
    $risTitolo = $ris["titolo"];
    $risPosti = $ris["nPostiSala"];
    $risIdSala = $ris["idSala"];
    $nuovoOggetto = new Programma($risFascia,$risTitolo,$risPosti,$risIdProgr,$risIdSala);
    array_push($arrayProgramma,$nuovoOggetto);
  }
?>
<!DOCTYPE html>
<html>

<head>
  <meta charset="utf-8">
  <meta content="width=device-width, initial-scale=1.0" name="viewport">
  <title>Convito | Convention Torinese</title>
  <meta content="" name="descriptison">
  <meta content="" name="keywords">
  <!-- Favicons -->
  <link href="assets/img/favicon.png" rel="icon">
  <link href="assets/img/apple-touch-icon.png" rel="apple-touch-icon">
  <!-- Google Fonts -->
  <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Muli:300,300i,400,400i,500,500i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i" rel="stylesheet">
  <!-- Vendor CSS Files -->
  <link href="assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link href="assets/vendor/icofont/icofont.min.css" rel="stylesheet">
  <link href="assets/vendor/boxicons/css/boxicons.min.css" rel="stylesheet">
  <link href="assets/vendor/animate.css/animate.min.css" rel="stylesheet">
  <link href="assets/vendor/venobox/venobox.css" rel="stylesheet">
  <link href="assets/vendor/owl.carousel/assets/owl.carousel.min.css" rel="stylesheet">
  <link href="assets/vendor/aos/aos.css" rel="stylesheet">
  <!-- Template Main CSS File -->
  <link href="assets/css/style.css" rel="stylesheet">
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
          <li class="active"><a href="index.php">Home</a></li>
          <li><a href="#speaker">Speaker</a></li>
          <li><a href="#programma">Programma</a></li>
          <li><a href="iscriviti.php">Iscriviti</a></li>
          <li><a href="login.php">Accedi</a></li>
        </ul>
      </nav><!-- .nav-menu -->

    </div>
  </header><!-- End Header -->

  <!-- ======= Hero Section ======= -->
  <section id="hero">
    <div id="heroCarousel" class="carousel slide carousel-fade" data-ride="carousel">
        <div class="carousel-item active" style="background-image: url(assets/img/wallpaper.jpeg);">
          <div class="container">
            <div class="carousel-content animated fadeInUp">
              <h2 align="center"> <span>CONVITO</span></h2>
              <p align="center">12 settembre 2020, Lingotto Fiere Torino, Torino</p>
              <div class="text-center"><a href="#programma" class="btn-get-started">Read More</a></div>
            </div>
          </div>
        </div>
    </div>
  </section><!-- End Hero -->

  <main id="main">
    <!-- ======= SEZIONE SPEAKER ======= -->
    <section id="speaker" class="team section-bg">
      <div class="container">
        <div class="section-title" data-aos="fade-up">
          <h2>I nostri <strong>speaker</strong></h2>
        </div>
        <div class="row">
          <?php for($i = 0; $i < count($arrayRelatore); $i++){?>
            <div class="col-lg-3 col-md-6 d-flex align-items-stretch">
              <div class="member" data-aos="fade-up">
                <div class="member-img">
                  <img src="assets/img/speaker.jpg" class="img-fluid" alt="">
                </div>
                <div class="member-info">
                  <h4><?php echo $arrayRelatore[$i]->getNome();?> <?php echo $arrayRelatore[$i]->getCognome();?></h4>
                  <span><?php echo $arrayRelatore[$i]->getAzienda();?></span>
                </div>
              </div>
            </div>
          <?php }?>
        </div>
      </div>
    </section>
    <!-- ======= SEZIONE PROGRAMMA ======= -->
    <section id="programma" class="portfolio">
      <div class="container">
        <div class="section-title" data-aos="fade-up">
          <h2>Il nostro <strong>Programma</strong></h2>
        </div>
        <div class="row portfolio-container" data-aos="fade-up">
          <?php for($i = 0; $i < count($arraySpeech); $i++){?>
            <div class="col-lg-4 col-md-6 portfolio-item filter-app">
              <img src="assets/img/programma.jpeg" class="img-fluid" alt="">
              <div class="portfolio-info">
                <h3><?php echo $arrayProgramma[$i]->getTitolo();?></h3>
                <h6>Fascia Oraria: <?php echo $arrayProgramma[$i]->getFasciaOraria();?></h6>
                <p><?php echo $arraySpeech[$i]->getArgomento();?></p>
                <? $numPosti = $arrayProgramma[$i]->getNPosti();
                  if($numPosti == 0){
                    echo "<p><b>POSTI ESAURITI</b></p>";
                  }else{
                    echo "<p>Numero di posti disponibili: ".$numPosti."</p>";
                  }?>
              </div>
            </div>
          <?php }?>
          <div class="col-lg-4 col-md-6 portfolio-item filter-app">
            <img src="assets/img/programma.jpeg" class="img-fluid" alt="">
            <div class="portfolio-info">
              <h3>Speech premiazione</h3>
              <p><b>Possono partecipare solo professori o liberi professionisti</b></p>
            </div>
          </div>
        </div>
        <?php $connessione->close(); ?>
      </div>
    </section>
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

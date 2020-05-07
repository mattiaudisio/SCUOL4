<?php
  include 'Funzioni_PHP/connessione.php';
  include 'Funzioni_PHP/relatore.php';
  include 'Funzioni_PHP/speech.php';
  include 'Funzioni_PHP/programma.php';

  $arrayProgramma = array();

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
          <li><a href="index.php">Home</a></li>
          <li><a href="index.php#speaker">Speaker</a></li>
          <li><a href="index.php#programma">Programma</a></li>
          <li class="active"><a href="iscriviti.php">Iscriviti</a></li>
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
            </div>
          </div>
        </div>
    </div>
  </section><!-- End Hero -->

  <main id="main">
        <!-- ======= SEZIONE ISCRIVITI ======= -->
    <section id="contact" class="contact">
    <div class="row mt-5 justify-content-center" data-aos="fade-up">
      <div class="col-lg-10">
        <div class="section-title" data-aos="fade-up">
          <h2>Iscriviti qua per preordinare<br> il tuo <strong>Biglietto</strong></h2>
        </div>
        <form action="form.php" method="post">
          <div class="container" >
              <p>Cognome:</p>
              <input type="text" name="cognome"  class="form-control" id="cognome" placeholder="Inserisci il tuo cognome" data-rule="minlen:4" data-msg="Inserisci il tuo cognome" />
              <br>
              <p>Nome:</p>
              <input type="text" name="nome"  class="form-control" id="nome" placeholder="Inserisci il tuo nome" data-rule="minlen:4" data-msg="Inserisci il tuo nome" />
              <br>
              <p>Mail:</p>
              <input type="email" name="mail"  class="form-control" id="email" placeholder="Inserisci la tua mail" data-rule="minlen:4" data-msg="Inserisci la tua mail" />
              <br>
              <p>Password:</p>
              <input type="password" name="password"  class="form-control" id="password" placeholder="Inserisci una password" data-rule="minlen:4" data-msg="Inserisci una password" />
              <br>
              <p>Tipologia:</p>
              <select name="tipologia" class="form-control" method="post">
                <option value="studente">Studente</option>
                <option value="docente">Docente</option>
                <option value="liberoProfessionista">Libero Professionista</option>
              </select><br>
              <p>Programmi:</p>
              <?php for($i = 0; $i < count($arrayProgramma); $i++){
                    if($arrayProgramma[$i]->getNPosti() > 0){
                        echo '<input type="checkbox" name="interessi[]" value="'.$arrayProgramma[$i]->getIdProgramma().'">'.$arrayProgramma[$i]->getTitolo().'<br>';
                    }
                  }?>
              <div class="text-center" ><input type="submit" value="iscriviti" name="iscriviti"></div>
          </div>
        </form>
        <br>
      </div>
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

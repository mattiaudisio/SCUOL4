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
          <li><a href="/Mattia/ProgettoSQL_Convention/Sito/index.php">Home</a></li>
          <li><a href="/Mattia/ProgettoSQL_Convention/Sito/index.php#speaker">Speaker</a></li>
          <li><a href="/Mattia/ProgettoSQL_Convention/Sito/index.php#programma">Programma</a></li>
          <li class="active"><a href="/Mattia/ProgettoSQL_Convention/Sito/iscriviti.html">Iscriviti</a></li>
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
          include 'Funzioni_PHP/relatore.php';
          include 'Funzioni_PHP/speech.php';

          $prova = 0;
          $arrayID = array();
          $string = "Par";

          $queryPartecipante = "SELECT Partecipante.idPart FROM Partecipante;";
          $risultatoPartecipante = $connessione->query($queryPartecipante);
          while($ris = $risultatoPartecipante->fetch_assoc()){
            $risId = $ris["idPart"];
            array_push($arrayID,$risId);
          }

          $queryPartecipante = "SELECT Partecipante.nomePart, Partecipante.cognomePart, Partecipante.mailPart FROM Partecipante;";
          $risultatoPartecipante = $connessione->query($queryPartecipante);
          while($ris = $risultatoPartecipante->fetch_assoc()){
            $risNome = $ris["nomePart"];
            $risCognome = $ris["cognomePart"];
            $risMail = $ris["mailPart"];
            if($_POST['cognome'] == $risCognome && $_POST['nome'] == $risNome && $_POST['mail'] == $risMail){
                echo "<p align='center'><b>REGISTRAZIONE NON EFFETTUATA</b></p><br><p align='center'>Hey, sembra che qualcuno che ha il tuo stesso nome, il tuo stesso cognome e la tua stessa mail si è già registrato e ha già ordinato un biglietto.</p>";
            }
          }

          if(isset($_GET['send'])){
            if(!empty($_GET['cognome']) && !empty($_GET['nome']) && !empty($_GET['mail']) && !empty($_GET['tipologia'])){
              $string = $string+count($arrayID);
              $dml = "INSERT INTO Partecipante(idPart, cognomePart, nomePart, mailPart, tipologiaPart) VALUES ('".$string."','".$POST["cognome"]."','".$POST["nome"]."','".$POST["mail"]."','".$POST["tipologia"]."');";
              if($connessione->query($dml) === TRUE){
                echo "caricato";
              }else{
                echo "noncaricato";
              }
            }else{
              echo "<p align='center'><b>COMPILA TUTTI I CAMPO</b></p><br><p align='center'>Compila tutti i campi per iscriverti e per ordinare il tuo biglietto</p>";
            }
          }
          $connessione->close();
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

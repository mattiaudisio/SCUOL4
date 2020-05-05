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
          <li class="active"><a href="iscriviti.php">Iscriviti</a></li>
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

      $prova = 0;
      $arrayID = array();
      $arrayProvaPresenza = array();
      $arrayProgramma = array();
      $arrayComposto = array();

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
            echo "<p align='center'><b>REGISTRAZIONE NON EFFETTUATA</b></p><br><p align='center'>Hey, sembra che qualcuno che ha il tuo stesso nome, il tuo stesso cognome e la tua stessa mail<br> si sia già registrato e abbia già ordinato un biglietto.</p>";
            array_push($arrayProvaPresenza,"true");
        }else{
          array_push($arrayProvaPresenza,"false");
        }
      }

      $contaPresenza = 0;
      for ($i=0; $i < count($arrayProvaPresenza); $i++) {
        if($arrayProvaPresenza[$i] == "true"){
            $contaPresenza = $contaPresenza + 1;
        }
      }

      $checkbox = $_POST['interessi'];

      if($contaPresenza == 0){
        if(isset($_POST['iscriviti'])){
          if(!empty($_POST['cognome']) && !empty($_POST['nome']) && !empty($_POST['mail'])){
            $string = count($arrayID) + 1;
            $totPersone = count($arrayComposto);
            $dml1 = "INSERT INTO Partecipante(idPart, cognomePart, nomePart, mailPart, tipologiaPart) VALUES ('".$string."','".$_POST["cognome"]."','".$_POST["nome"]."','".$_POST["mail"]."','".$_POST["tipologia"]."');";
            if($connessione->query($dml1) === TRUE){
              for($i = 0; $i < sizeof($checkbox); $i++){
                $totPersone = $totPersone + 1;
                $query = "INSERT INTO Composto(idPart, idProgramma, nPartecipanti) VALUES  ('".$string."','".$checkbox[$i]."','".$totPersone."');";
                $connessione->query($query);
              }?>
                  <section id="about-us" class="about-us">
                    <div class="container">
                      <div class="row no-gutters">
                        <div class="image col-xl-5 d-flex align-items-stretch justify-content-center justify-content-lg-start" data-aos="fade-right" style="background-image: url(/Mattia/ProgettoSQL_Convention/Sito/assets/img/riepilogo.jpg);"></div>
                        <div class="col-xl-7 pl-0 pl-lg-5 pr-lg-1 d-flex align-items-stretch">
                          <div class="content d-flex flex-column justify-content-center">
                            <h3 data-aos="fade-up"> <?php echo $_POST["nome"]; ?> <?php echo $_POST["cognome"]; ?></h3>
                            <p data-aos="fade-up"> <?php echo $_POST["mail"]; ?>, <?php echo $_POST["tipologia"]; ?></p>
                            <div class="row">
                              <?php if(isset($_POST["interessi"])){?>
                              <div class="col-md-6 icon-box" data-aos="fade-up">
                                <!-- <h6> <?php echo implode("",$_POST["interessi"]);?></h6> -->
                                <?for($i = 0; $i < sizeof($checkbox); $i++){
                                  echo $checkbox[$i];
                                }?>
                              </div>
                            <?php }
                            if($_POST["tipologia"] == "docente" || $_POST["tipologia"] == "liberoProfessionista" ){
                                  echo '<div class="col-md-6 icon-box" data-aos="fade-up">
                                          <h4>Speech Premiazione</h4>
                                          <p>Ordinato</p>
                                       </div>';
                            }?>
                            </div>
                          </div><!-- End .content-->
                        </div>
                      </div>
                    </div>
                  </section>
                <?php }
          }else{
            echo "<p align='center'><b>COMPILA TUTTI I CAMPI</b></p><br><p align='center'>Compila tutti i campi per iscriverti e ordinare il tuo biglietto</p>";
          }
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

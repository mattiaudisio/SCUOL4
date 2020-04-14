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
          <li class="active"><a href="iscriviti.html">Iscriviti</a></li>
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
    <br>
    <?php
          include 'Funzioni_PHP/connessione.php';
          include 'Funzioni_PHP/relatore.php';
          include 'Funzioni_PHP/speech.php';
          include 'Funzioni_PHP/programma.php';

          $prova = 0;
          $arrayID = array();
          $arrayProvaPresenza = array();
          $arrayProgramma = array();

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

          if($contaPresenza == 0){
            if(isset($_POST['send'])){
              if(!empty($_POST['cognome']) && !empty($_POST['nome']) && !empty($_POST['mail']) && !empty($_POST['tipologia'])){
                $string = count($arrayID);
                $dml = "INSERT INTO Partecipante(idPart, cognomePart, nomePart, mailPart, tipologiaPart) VALUES ('".$string."','".$_POST["cognome"]."','".$_POST["nome"]."','".$_POST["mail"]."','".$_POST["tipologia"]."');";
                if($connessione->query($dml) === TRUE){
                  ?>

                  <p align='center'><b>REGISTRAZIONE EFFETTUATA</b></p><br>
                  <p align='center'>Ciao <?php echo $_POST["nome"];?> <?php echo $_POST["cognome"];?>, vogliamo darti un ottima notizia, la tua registrazione è stata accettata!<br>ora protrai preordinare il tuo biglietto.</p>";

                  <section id="testimonials" class="testimonials">
                    <div class="container">
                      <div class="row">
                        <?php

                          $queryProgramma = "SELECT Programma.fasciaOraria, Speech.titolo, Sala.nPostiSala FROM Programma,Speech,Sala WHERE Programma.idSpeech = Speech.idSpeech AND Programma.idSala = Sala.idSala;";
                          $risultatoProgramma = $connessione->query($queryProgramma);
                          while($ris = $risultatoProgramma->fetch_assoc()){
                            $risFascia = $ris["fasciaOraria"];
                            $risTitolo = $ris["titolo"];
                            $risPosti = $ris["nPostiSala"];
                            $nuovoOggetto = new Programma($risFascia,$risTitolo,$risPosti);
                            array_push($arrayProgramma,$nuovoOggetto);
                          }
                          ?>
                          <?php for($i = 0; $i < count($arrayProgramma); $i++){ ?>
                              <div class="col-lg-6" data-aos="fade-up" data-aos-delay="100">
                                <div class="testimonial-item mt-4 mt-lg-0">
                                  <img src="assets/img/speech.jpg" class="testimonial-img" alt="">
                                  <h3> <?php echo $arrayProgramma[$i]->getTitolo();?></h3>
                                  <h4>Fascia Oraria: <?php echo $arrayProgramma[$i]->getFasciaOraria();?></h4>
                                  <p>Numero di posti disponibili: <?php echo $arrayProgramma[$i]->getNPosti();?></p><br>
                                  <input type="radio" name="<?php  $arrayProgramma[$i]->getTitolo();?>" id="<?php  $arrayProgramma[$i]->getTitolo();?>" value="<?php  $arrayProgramma[$i]->getTitolo();?>"> <label for="<?php  $arrayProgramma[$i]->getTitolo();?>">ACQUISTA</label><br>
                                </div>
                              </div>
                              <?php } ?>
                              <?php if($_POST['tipologia'] == "docente" ||$_POST['tipologia'] == "liberoProfessionista"){ ?>
                                  <div class="col-lg-6" data-aos="fade-up" data-aos-delay="100">
                                    <div class="testimonial-item mt-4 mt-lg-0">
                                      <img src="assets/img/speech.jpg" class="testimonial-img" alt="">
                                      <h3> Speech Premiazione</h3>
                                      <input type="radio" name="speechPremiazione" id="speechPremiazione" value="speechPremiazione"> <label for="speechPremiazione">ACQUISTA</label><br>
                                    </div>
                                  </div>
                                  <?php } ?>
                              <br>
                      </div>
                      <div class="text-center" ><button type="submit" name="send" value="Acquista" class="bottoneIscrizione">Acquista</button></div>
                    </div>
                  </section>
                  <?php
                }
              }else{
                 echo "<p align='center'><b>COMPILA TUTTI I CAMPI</b></p><br><p align='center'>Compila tutti i campi per iscriverti e ordinare il tuo biglietto</p>";
               }
            }
            $connessione->close();
          }?>
    <br><br>
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

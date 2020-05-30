<!DOCTYPE html>
<?php
  session_start();

  if(isset($_SESSION['idPart'])){
    header('location:profilo.php');
  }
?>

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
  <style>
  input[type=submit] {
    background: #f03c02;
    border: 0;
    padding: 10px 24px;
    color: #fff;
    transition: 0.4s;
    border-radius: 4px;
  }

  input[type=submit]:hover {
    background-color: #cc3808;
  }
  </style>
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
          <li class="active"><a href="login.php">Profilo</a></li>
          <?php
          if(isset($_SESSION['idPart'])){
            echo '<li><a href="Funzioni_PHP/logout.php">Logout</a></li>';
          }
          ?>
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
          <h2><strong>ACCEDI</strong></h2>
        </div>
          <form action="header_autenticazione.php" method="post">
            <div class="container" >
                <p>Mail:</p>
                <input type="email" name="mail"  class="form-control" id="mail" placeholder="Inserisci la tua mail" data-rule="minlen:4" data-msg="Inserisci la tua mail" />
                <br>
                <p>Password:</p>
                <input type="password" name="password"  class="form-control" id="password" placeholder="Inserisci una password" data-rule="minlen:4" data-msg="Inserisci una password" />
                <br>
                <div class="text-center" ><input type="submit" value="login" name="login"></div>
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

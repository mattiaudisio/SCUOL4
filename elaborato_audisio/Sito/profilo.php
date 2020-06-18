<?php
  include_once(__DIR__.'/connessione.php');

  $connessione = Connessione::apriConnessione();

  session_start();

  if(!isset($_SESSION['codFiscaleGuardia'])){
    header('location:login.php');
  }

?>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta content="width=device-width, initial-scale=1.0" name="viewport">
  <title><?php       if(isset($_SESSION['codFiscaleGuardia'])){
          $query = "SELECT GuardiaParco.nomeGuardia, GuardiaParco.cognomeGuardia FROM GuardiaParco WHERE GuardiaParco.codGuardia = '".$_SESSION['codFiscaleGuardia']."'";
          $queryNomeCognome =  $connessione->query($query);
          if($var = $queryNomeCognome->fetch_assoc()){ ?>
            <?php echo $var['nomeGuardia']?>  <?php echo $var['cognomeGuardia']?> | Parchi Regionali
          <?php }
        }?></title>
  <meta content="" name="descriptison">
  <meta content="" name="keywords">
  <link href="assets/img/icon.png" rel="icon">
  <link href="assets/img/apple-touch-icon.png" rel="apple-touch-icon">
  <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Raleway:300,300i,400,400i,500,500i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i" rel="stylesheet">
  <link href="assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link href="assets/vendor/icofont/icofont.min.css" rel="stylesheet">
  <link href="assets/vendor/boxicons/css/boxicons.min.css" rel="stylesheet">
  <link href="assets/vendor/remixicon/remixicon.css" rel="stylesheet">
  <link href="assets/vendor/owl.carousel/assets/owl.carousel.min.css" rel="stylesheet">
  <link href="assets/vendor/animate.css/animate.min.css" rel="stylesheet">
  <link href="assets/vendor/aos/aos.css" rel="stylesheet">
  <link href="assets/input_button.css" rel="stylesheet">
  <link href="assets/css/style.css" rel="stylesheet">
</head>

<body>
  <header id="header" class="fixed-top">
    <div class="container d-flex align-items-center">
      <h1 class="logo mr-auto"><a href="index.php">Parchi Regionali</a></h1>
      <nav class="nav-menu d-none d-lg-block">
        <ul>
          <li><a href="index.php">Home</a></li>
          <li><a href="index.php#about">About</a></li>
          <li><a href="query.php">Query</a></li>
          <?php
          if(isset($_SESSION['codFiscaleGuardia'])){
            $query = "SELECT GuardiaParco.nomeGuardia, GuardiaParco.cognomeGuardia FROM GuardiaParco WHERE GuardiaParco.codGuardia = '".$_SESSION['codFiscaleGuardia']."'";
            $queryNomeCognome =  $connessione->query($query);
            if($var = $queryNomeCognome->fetch_assoc()){
              echo '<li class="active"><a href="profilo.php">'.$var['nomeGuardia'].' '. $var['cognomeGuardia'].'</a></li>
                    <li><a href="logout.php">Logout</a></li>';
            }
          }else{
            ?>       <a href="login.php" class="get-started-btn">Area Riservata</a> <?php
          }
          ?>
      </nav>
    </div>
  </header>
  <section id="hero" class="d-flex justify-content-center align-items-center">
    <div class="container position-relative" data-aos="zoom-in" data-aos-delay="100">
      <?php $query = "SELECT GuardiaParco.nomeGuardia, GuardiaParco.cognomeGuardia FROM GuardiaParco WHERE GuardiaParco.codGuardia = '".$_SESSION['codFiscaleGuardia']."'";
            $queryNomeCognome =  $connessione->query($query);
            if($var = $queryNomeCognome->fetch_assoc()){
              echo '<h1>Benvenuto  '.$var['nomeGuardia'].' '.$var['cognomeGuardia'].'</h1>';
            } ?>
    </div>
  </section>
  <main id="main">
    <section id="about" class="about">
      <div class="container" data-aos="fade-up">
        <div class="row">
          <div class="col-lg-6 order-1 order-lg-2" data-aos="fade-left" data-aos-delay="100">
            <img src="assets/img/profilo.jpg" class="img-fluid" alt="">
          </div>
          <div class="col-lg-6 pt-4 pt-lg-0 order-2 order-lg-1 content">
            <?php $query = "SELECT GuardiaParco.nomeGuardia, GuardiaParco.cognomeGuardia, GuardiaParco.anniGuardia, GuardiaParco.sessoGuardia FROM GuardiaParco WHERE GuardiaParco.codGuardia = '".$_SESSION['codFiscaleGuardia']."'";
            $queryNomeCognome =  $connessione->query($query);
            if($var = $queryNomeCognome->fetch_assoc()){
              echo '<h1>'.$var['nomeGuardia'].' '.$var['cognomeGuardia'].'</h1>';
              echo "<h5>età: ".$var["anniGuardia"]."<br>sesso: ".$var["sessoGuardia"]."<br>";
            }
            $query = "SELECT Parchi.nomeParco FROM Parchi,GuardiaParco WHERE GuardiaParco.codiceParco = Parchi.codiceParco AND GuardiaParco.codGuardia = '".$_SESSION['codFiscaleGuardia']."'";
            $queryParco =  $connessione->query($query);
            if($parco = $queryParco->fetch_assoc()){
              echo "Guardia forestale presso ".$parco["nomeParco"]."</h5>";
            }?>
          </div>
        </div>
      </div>
    </section>
    <?$connessione->close();?>
  </main>
  <footer id="footer">
    <div class="container d-md-flex py-4">
      <div class="mr-md-auto text-center text-md-left">
        <h3>Parchi regionali</h3>
        <p>
          Corso Vittorio Emanuele II <br>
          10138 Torino TO<br>
          Torino <br><br>
        </p>
      </div>
      <div class="social-links text-center text-md-right pt-3 pt-md-0">
        <a href="#" class="twitter"><i class="bx bxl-twitter"></i></a>
        <a href="#" class="facebook"><i class="bx bxl-facebook"></i></a>
        <a href="#" class="instagram"><i class="bx bxl-instagram"></i></a>
      </div>
    </div>
  </footer>
  <a href="#" class="back-to-top"><i class="bx bx-up-arrow-alt"></i></a>
  <div id="preloader"></div>
  <script src="assets/vendor/jquery/jquery.min.js"></script>
  <script src="assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
  <script src="assets/vendor/jquery.easing/jquery.easing.min.js"></script>
  <script src="assets/vendor/php-email-form/validate.js"></script>
  <script src="assets/vendor/waypoints/jquery.waypoints.min.js"></script>
  <script src="assets/vendor/counterup/counterup.min.js"></script>
  <script src="assets/vendor/owl.carousel/owl.carousel.min.js"></script>
  <script src="assets/vendor/aos/aos.js"></script>
  <script src="assets/js/main.js"></script>
</body>
</html>

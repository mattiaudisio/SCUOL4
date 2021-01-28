# Audisio Mattia 5C

__*ESAME DI STATO DI ISTITUTO TECNICO INDUSTRIALE*__ <br />
CORSO DI ORDINAMENTO <br />
__Indirizzo__: INFORMATICA <br />
__Tema di__: INFORMATICA GENERALE, SISTEMI E RETI <br />

Il Ministero dell'Ambiente commissiona lo sviluppo di un nuovo Sistema Informativo per censire la
fauna e la flora presenti nei vari parchi naturali di ciascuna regione. Le informazioni della fauna da
raccogliere riguardano l'ordine di appartenenza (mammiferi, rettili, uccelli, etc...), la specie
(scoiattolo, volpe, orso, vipera, falco, aquila, etc...), il numero di esemplari adulti e cuccioli (con
distinzione maschio, femmina). La flora viene distinta in alberi (quercia, faggio, acacia, etc...),
arbusti (lavanda, rosmarino, rododendro, etc...) e piante erbacee (fragola di bosco, margherita,
primula, etc...) ed è necessario catalogarle.<br />
In ciascun parco, un responsabile (guardia parco) raccoglie le informazioni attraverso
un’interfaccia web tramite il dispositivo mobile in dotazione e, dopo avere acquisito i dati dalle
maschere di immissione, li invia al sistema centrale della Regione per la memorizzazione nel
database regionale.<br />
Il candidato, ___formulate le opportune ipotesi aggiuntive___, realizzi:<br />
 • Un’analisi della realtà di riferimento, completa dello schema funzionale dell'architettura
 proposta (a livello locale e regionale), evidenziandone le principali componenti, le
 caratteristiche hardware e software, i protocolli necessari, la tecnologia utilizzata per la
 trasmissione delle informazioni e le tecniche per garantire la sicurezza perimetrale dei dati.<br />
 • Un piano opportuno di indirizzamento locale e per la comunicazione tra le sedi.<br />
 • Uno schema concettuale ed uno schema logico del database.<br />
 • La definizione delle relazioni e le seguenti interrogazioni espresse in linguaggio SQL,__opportunamente commentate in ogni loro parte__:<br />
 1. Visualizzare l'elenco di tutti gli esemplari di fauna, ordinati per specie, presenti nei  vari parchi.<br />
 2. Visualizzare quante specie diverse di pino sono presenti in ciascun parco.<br />
 3. Visualizzare il nome della specie di animale con il più alto numero di esemplari censiti nei vari parchi della regione.<br />
 
La codifica in PHP (HTML-CSS-JS) di:<br />
 • form di autenticazione (login) del guardia parco all’interfaccia web;<br />
 • una pagina per la visualizzazione del risultato di una query a scelta tra quelle proposte.<br />
 
 # Sviluppo della rete
Ipotizzando la difficoltà di una connessione di rete permanente nelle aree dei parchi naturali si
ipotizza che nel dispositivo mobile sia presente un applicazione Android, scritta in java, dove ogni
guardia, tramite due form, uno per l’inserimento di un nuovo animale ed uno per l'inserimento di
una nuova pianta, produca un file XML locale.<br />
Visto che il dispositivo mobile in dotazione serve principalmente per acquisire i dati, si può
ipotizzare che sia un dispositivo Android di vecchia generazione, per questo motivo può avere un
sistema operativo Android 7.00 o inferiori con una memoria da 16 GB.<br />
Oltre ad un dispositivo mobile, la guardia potrebbe avere un notebook su cui inviare, tramite il
protocollo Bluetooth, il file XML, per poi inviarlo al sistema centrale della Regione, dove le
informazioni verranno salvate all’interno del database.<br />
Come portatile si può pensare ad un computer di fascia medio-bassa con 4GB di RAM, 500GB di
Hard Disk e come processore un Intel Core i7 di 8th generazione con sopra Ubuntu e si può
ipotizzare l’utilizzo di FileZilla per il trasferimento dei file, utilizzando così il protocollo FTP.
Un altro sistema per inoltrare il file al sistema centrale può essere via mail, proteggendo la mail con
una firma digitale, in modo da verificare l’autenticità del mittente e impedendo così un’eventuale
alterazione del database da parte di utenti non autorizzati.<br />
Per la costruzione di questo schema di rete si è deciso di prendere in considerazione la prima
soluzione.<br />
All’interno dei parchi, vista la presenza di un unico computer, si può pensare all’installazione di uno
switch Cisco a 8 porte collegato ad un router Cisco con funzionalità di NAT, in modo che
all’indirizzo IP privato del computer (192.168.20.2) sia associato un indirizzo IP pubblico
(75.122.49.16), e Firewall, in modo che tutti i pacchetti in entrata ed uscita siano controllati, ed
all’occorrenza, filtrati.<br />
All’interno del parco, l’indirizzo di rete è il 192.168.20.0, il broadcast è il 192.168.20.255
mentre il gateway è il 192.168.20.254.<br />
All’interno del sistema centrale della Regione, lo schema di rete, si può suddividere in 2 gruppi, il
primo dov’è presente una LAN con le postazioni degli operatori, ed il secondo dove è collocata la
DMZ, al cui interno sono presenti i server HTTP, FTP ed il server a cui è collegato il database.
La LAN è collegata al router tramite uno switch Cisco a 24 porte, visto anche il maggior numero di
computer, mentre il router è un router Cisco con funzionalità di NAT e Firewall.<br />
Per i computer si può pensare a dei PC desktop con una CPU Intel Core i7 di 9th generazione con
4G di RAM e 500GB di Hard Disk con sopra Ubuntu.<br />
Per i server, si può optare di utilizzare 3 server con 2 Hard Disk da un 1TB l’uno mentre, per gli
indirizzi IP, si è scelto di dare l’indirizzo 202.168.30.1 al server che ospita il database, l’indirizzo
202.168.30.100 al server FTP, mentre invece l’indirizzo 202.168.30.200 è stato assegnato al server
HTTP che permette ai vari utenti di raggiungere l’interfaccia web tramite un qualsiasi motore di
ricerca.<br />
All’interno del sistema centrale della Regione, l’indirizzo di rete è il 202.168.30.0, il
broadcast è il 202.168.30.255 mentre il gateway è il 202.168.30.254.<br />
Si è scelto di inserire anche il database all’interno della DMZ perché, al suo interno, vengono
salvate anche le mail e le password delle guardie e, nonostante la cifratura in hash che viene fatta
alle password prima di caricarle sul database, si è optato, per evitare eventuali furti di mail
password, di inserirlo all’interno della DMZ.<br />

![ ](https://github.com/mattiaudisio/prjScuola/blob/master/Maturita/elaborato_audisio/img/01.PNG)

# Diagramma E/R
*premessa*:
 - La relazione Parco-GuardiaParco è stata resa una relazione 1-N perché si è ipotizzato che, all’interno di un parco, possano lavorare più guardie ma che solamente una è adibita all’invio dei dati
- La relazione Parco-Fauna e la relazione Parco-Flora sono state rese delle relazioni 1-N perché si è ipotizzato che un determinato tipo di animali o un determinato tipo di pianta possono vivere o si possono trovare all’interno di un solo parco

![ ](https://github.com/mattiaudisio/prjScuola/blob/master/Maturita/elaborato_audisio/img/02.PNG)

__*Valori che assumono alcuni attributi*__<br />
sesso:  *F* = femmina *M* = maschio<br />
sessoGuardia: *F* = femmina *M* = maschio<br />
eta: *A* = adulto *C* = cucciolo<br />
nomeOrdine: *mammiferi rettili uccelli*<br />
stagioneFioritura: *primavera estate autunno inverno*<br />

# Schema Logico
Parco (__codiceParco__,nomeParco);<br />
Fauna (__codiceFauna__,specie,eta,sesso, *codiceOrdine, codiceParco*);<br />
Ordine (__codiceOrdine__,nomeOrdine);<br />
Flora (__codiceFlora__,nome,categoria,stagioneFioritura,*codiceParco*);<br />
GuardiaParco
(__codGuardia__,nomeGuardia,cognomeGuardia,anniGuardia,sessoGuardia,mailGuard
ia,passwordGuardia,*codiceParco*);<br />

# Creazione database

__*DDL*__<br />
create table parchi_audisio;<br />
use parchi_audisio;<br />
create table if not exists Parchi(<br />
 codiceParco varchar(10) not null,<br />
 nomeParco varchar(100) null,<br />
 primary key(codiceParco)<br />
);<br />
create table if not exists GuardiaParco(<br />
 codGuardia varchar(10) not null,<br />
 nomeGuardia varchar(50) null,<br />
 cognomeGuardia varchar(50) null,<br />
 anniGuardia int null,<br />
 sessoGuardia varchar(10) null,<br />
 mailGuardia varchar(50) null,<br />
 passwordGuardia varchar(100) null,<br />
 codiceParco varchar(10) not null,<br />
 primary key(codGuardia)<br />
);<br />
create table if not exists Fauna(<br />
 codiceFauna varchar(10) not null,<br />
 specie varchar(100) null,<br />
 eta varchar(10) null,<br />
 sesso varchar(10) null,<br />
 codiceOrdine varchar(10) not null,<br />
 codiceParco varchar(10) not null,<br />
 primary key(codiceFauna)<br />
);<br />
create table if not exists Ordine(<br />
 codiceOrdine varchar(10) not null,<br />
 nomeOrdine varchar(100) null,<br />
 primary key(codiceOrdine)<br />
);<br />
create table if not exists Flora(<br />
 codiceFlora varchar(10) not null,<br />
 nome varchar(100) null,<br />
 categoria varchar(10) null,<br />
 stagioneFioritura varchar(100) null,<br />
 codiceParco varchar(10) not null,<br />
 primary key(codiceFlora)<br />
);<br />
alter table GuardiaParco add foreign key (codiceParco) references Parchi(codiceParco);<br />
alter table Flora add foreign key (codiceParco) references Parchi(codiceParco);<br />
alter table Fauna add foreign key (codiceParco) references Parchi(codiceParco);<br />
alter table Fauna add foreign key (codiceOrdine) references Ordine(codiceOrdine);<br />
__*DML*__<br />
use parchi_audisio;<br />
insert into Parchi (codiceParco,nomeParco) values<br />
 ('Parcho1','Gran Paradiso'),<br />
 ('Parcho2','Val Grande'),<br />
 ('Parcho3','Val Troncea'),<br />
 ('Parcho4','Lanca di San Michele'),<br />
 ('Parcho5','Monviso');<br />
insert into GuardiaParco (codGuardia,nomeGuardia,cognomeGuardia,anniGuardia,sessoGuardia,mailGuardia,passwordGuardia,codiceParco) values<br />

('Guardia1','Marco','Longo',30,'M','guardia1@mail.com','ef92b778bafe771e89245b89ecbc08a44a4e166c06659911881f383d4473e94f','Parcho1'),<br />
('Guardia2','Luca','Rossi',29,'M','guardia2@mail.com','ef92b778bafe771e89245b89ecbc08a44a4e166c06659911881f383d4473e94f','Parcho2'),<br />
('Guardia3','Stefano','Verdi',49,'M','guardia3@mail.com','ef92b778bafe771e89245b89ecbc08a44a4e166c06659911881f383d4473e94f','Parcho3'),<br />
('Guardia4','Lorenzo','Giolitti',41,'M','guardia4@mail.com','ef92b778bafe771e89245b89ecbc08a44a4e166c06659911881f383d4473e94f','Parcho4'),<br />
('Guardia5','Giacomo','Saba',56,'M','guardia5@mail.com','ef92b778bafe771e89245b89ecbc08a44a4e166c06659911881f383d4473e94f','Parcho5');<br />

insert into Ordine (codiceOrdine,nomeOrdine) values<br />
 ('ordine1','mammiferi'),<br />
 ('ordine2','rettili'),<br />
 ('ordine3','uccelli');<br />
 
insert into Fauna (codiceFauna,specie,eta,sesso,codiceOrdine,codiceParco) values<br />
 ('Fauna1','scoiattolo','A','M','ordine1','Parcho1'),<br />
 ('Fauna2','volpe','C','F','ordine1','Parcho2'),<br />
 ('Fauna3','orso','A','M','ordine1','Parcho3'),<br />
 ('Fauna4','vipera','C','F','ordine2','Parcho4'),<br />
 ('Fauna5','falco','A','M','ordine3','Parcho5');<br />

insert into Flora (codiceFlora,nome,categoria,stagioneFioritura,codiceParco) values<br />
 ('Flora1',' pino','piante','primavera','Parcho1'),<br />
 ('Flora2','pino','piante','autunno','Parcho2'),<br />
 ('Flora3','pino','piante','estate','Parcho3'),<br />
 ('Flora4','pino','alberi','inverno','Parcho4'),<br />
 ('Flora5','pino','arbusti','autunno','Parcho5');<br />

# Query sql
__1) Visualizzare l'elenco di tutti gli esemplari di fauna, ordinati per specie, presenti nei vari parchi__<br /><br />
select Fauna.specie, Parchi.nomeParco<br />
from Fauna, Parchi<br />
where Parchi.codiceParco = Fauna.codiceParco<br />
order by Fauna.specie;<br />

__2) Visualizzare quante specie diverse di pino sono presenti in ciascun parco__<br /><br />
select Parchi.nomeParco, count(Flora.codiceFlora) as numPini<br />
from Flora, Parchi<br />
where Parchi.codiceParco = Flora.codiceParco<br />
and Flora.nome = “pino"<br />
group by Parchi.nomeParco;<br />

__3) Visualizzare il nome della specie di animale con il più alto numero di esemplari censiti nei vari parchi della regione__<br /><br />
create view numeroEsemplari(parco,specie,numero) as<br />
select Parchi.nomeParco, Fauna.specie, count(Parchi.nomeParco)<br />
from Fauna, Parchi<br />
where Parchi.codiceParco = Fauna.codiceParco<br />
group by Parchi.nomeParco, Fauna.specie;<br />
select specie,parco<br />
from numeroEsemplari<br />
where numero = (select max(numero));<br />

# Codice

Il sito, tolta la parte grafica che viene strutturata su un template di boostrap, si basa su 4 pagine, che corrispondono alla pagina index.php, alla pagina query.php, in cui viene mostrata la query, la pagina login.php, in cui l’utente può effettuare il login,e la pagina profilo.php in cui vengono mostrate le informazioni dell’utente che ha effettuato il login.<br />
Oltre a queste pagine, il sito viene gestito tramite 2 file, il primo, accedi.php, che viene richiamato dopo che viene effettuato il login e interroga il database per vedere se la mail e la password inserite sono presenti e, se non sono presenti, rimanda l’utente alla pagina di login, altrimenti lo manda alla pagina profilo.php, mentre invece la seconda,logout.php, permette all’utente di effettuare il login dal proprio account, ed una Classe, la Classe connesione presente nel file connessione.php, con cui,
tramite la funzione apriConnessione, riusciamo a connetterci al server per interrogarlo.<br /><br />

__accedi.php__
```
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
```
__connessione.php__
```
<?php
    Class Connessione{
        static function apriConnessione(){
          $connessione = new mysqli("localhost", "root", "", "parchi_audisio");

          if ($connessione->connect_errno) {
            echo "Connessione fallita: ". $connessione->connect_error . ".";
          }

          $connessione->query("SET NAMES 'utf8'");

          return $connessione;
        }
    }
?>
```
__index.php__
![ ](https://github.com/mattiaudisio/prjScuola/blob/master/Maturita/elaborato_audisio/img/03.PNG)
![ ](https://github.com/mattiaudisio/prjScuola/blob/master/Maturita/elaborato_audisio/img/04.PNG)
```
<?php
  include_once(__DIR__.'/connessione.php');

  $connessione = Connessione::apriConnessione();

  if (session_status() == PHP_SESSION_NONE) {
    session_start();
  }
?>

<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta content="width=device-width, initial-scale=1.0" name="viewport">
  <title>Parchi Regionali | index</title>
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
          <li class="active"><a href="index.php">Home</a></li>
          <li><a href="index.php#about">About</a></li>
          <li><a href="query.php">Query</a></li>
          <?php
          if(isset($_SESSION['codFiscaleGuardia'])){
            $query = "SELECT GuardiaParco.nomeGuardia, GuardiaParco.cognomeGuardia FROM GuardiaParco WHERE GuardiaParco.codGuardia = '".$_SESSION['codFiscaleGuardia']."'";
            $queryNomeCognome =  $connessione->query($query);
            if($var = $queryNomeCognome->fetch_assoc()){
              echo '<li><a href="profilo.php">'.$var['nomeGuardia'].' '. $var['cognomeGuardia'].'</a></li>
                    <li><a href="logout.php">Logout</a></li>';
            }
          }else{
            ?>       <a href="login.php" class="get-started-btn">Area Riservata</a> <?php
          }
          ?>
      </nav>
    </ul>
    </div>
  </header>
  <section id="hero" class="d-flex justify-content-center align-items-center">
    <div class="container position-relative" data-aos="zoom-in" data-aos-delay="100">
      <h1>Parchi Regionali</h1>
      <h2>Vieni a scoprire la flora e la fauna della tua regione</h2>
    </div>
  </section>
  <main id="main">
    <section id="counts" class="counts section-bg">
      <div class="container">
        <div class="row counters">
          <div class="col-lg-3 col-6 text-center">
            <span data-toggle="counter-up">1232</span>
            <p>categorie di piante</p>
          </div>
          <div class="col-lg-3 col-6 text-center">
            <span data-toggle="counter-up">942</span>
            <p>specie di animali</p>
          </div>
          <div class="col-lg-3 col-6 text-center">
            <span data-toggle="counter-up">42</span>
            <p>Parchi</p>
          </div>
        </div>
      </div>
    </section>
    <section id="popular-courses" class="courses">
      <div class="container" data-aos="fade-up">
        <div class="row" data-aos="zoom-in" data-aos-delay="100">
          <div class="col-lg-4 col-md-6 d-flex align-items-stretch">
            <div class="course-item">
              <img src="assets/img/fauna.jpg" class="img-fluid" alt="...">
              <div class="course-content">
                <h3><a href="course-details.html">Fauna</a></h3>
                <p>Et architecto provident deleniti facere repellat nobis iste. Id facere quia quae dolores dolorem tempore.</p>
              </div>
            </div>
          </div>
          <div class="col-lg-4 col-md-6 d-flex align-items-stretch mt-4 mt-md-0">
            <div class="course-item">
              <img src="assets/img/flora.jpg" class="img-fluid" alt="...">
              <div class="course-content">
                <h3><a href="course-details.html">Flora</a></h3>
                <p>Et architecto provident deleniti facere repellat nobis iste. Id facere quia quae dolores dolorem tempore.</p>
              </div>
            </div>
          </div>
          <div class="col-lg-4 col-md-6 d-flex align-items-stretch mt-4 mt-md-0">
            <div class="course-item">
              <img src="assets/img/mountain.jpg" class="img-fluid" alt="...">
              <div class="course-content">
                <h3><a href="course-details.html">Parchi</a></h3>
                <p>Et architecto provident deleniti facere repellat nobis iste. Id facere quia quae dolores dolorem tempore.</p>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>
  </main>
  <section id="about" class="about">
    <div class="container" data-aos="fade-up">
      <div class="row">
        <div class="col-lg-6 order-1 order-lg-2" data-aos="fade-left" data-aos-delay="100">
          <img src="assets/img/guardiaParco.jpeg" class="img-fluid" alt="">
        </div>
        <div class="col-lg-6 pt-4 pt-lg-0 order-2 order-lg-1 content">
          <h3>Voluptatem dignissimos provident quasi corporis voluptates sit assumenda.</h3>
          <p class="font-italic">
            Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore
            magna aliqua.
            Ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate
          </p>
        </div>
      </div>

    </div>
  </section>
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
```
![ ](https://github.com/mattiaudisio/prjScuola/blob/master/Maturita/elaborato_audisio/img/05.PNG)
![ ](https://github.com/mattiaudisio/prjScuola/blob/master/Maturita/elaborato_audisio/img/06.PNG)

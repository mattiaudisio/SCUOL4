<?php
    $Lunedi_0911 = [ ];
    $Lunedi_1113 = [ ];
    $Lunedi_1416 = [ ];
    $Lunedi_1618 = [ ];
    $Martedi_0911 = [ ];
    $Martedi_1113 = [ ];
    $Martedi_1416 = [ ];
    $Martedi_1618 = [ ];
    $Mercoledi_0911 = [ ];
    $Mercoledi_1113 = [ ];
    $Mercoledi_1416 = [ ];
    $Mercoledi_1618 = [ ];
    $Giovedi_0911 = [ ];
    $Giovedi_1113 = [ ];
    $Giovedi_1416 = [ ];
    $Giovedi_1618 = [ ];
    $Venerdi_0911 = [ ];
    $Venerdi_1113 = [ ];
    $Venerdi_1416 = [ ];
    $Venerdi_1618 = [ ];
 
    $ContLunedi_0911 = 0;
    $ContLunedi_1113 = 0;
    $ContLunedi_1416 = 0;
    $ContLunedi_1618 = 0;
    $ContMartedi_0911 = 0;
    $ContMartedi_1113 = 0;
    $ContMartedi_1416 = 0;
    $ContMartedi_1618 = 0;
    $ContMercoledi_0911 = 0;
    $ContMercoledi_1113 = 0;
    $ContMercoledi_1416 = 0;
    $ContMercoledi_1618 = 0;
    $ContGiovedi_0911 = 0;
    $ContGiovedi_1113 = 0;
    $ContGiovedi_1416 = 0;
    $ContGiovedi_1618 = 0;
    $ContVenerdi_0911 = 0;
    $ContVenerdi_1113 = 0;
    $ContVenerdi_1416 = 0;
    $ContVenerdi_1618 = 0;
      
    $data = $_POST['data'];
		$ora = $_POST['ora'];
		$nome = $_POST['nome'];

    if(isset($_POST['send'])){
		      if(!empty($_POST['nome'])){
		          session_start();
		          if($data == 'Lunedi'){
		              if($ora == '9 - 11'){
		                  $Lunedi_0911[] = $nome;
		                  $ContLunedi_0911=$ContLunedi_0911+1;
		              }
		              if($ora == '11 - 13'){
		                  $Lunedi_1113[] = $nome;
		                  $ContLunedi_1113=$ContLunedi_1113+1;		                  
		              }
		              if($ora == '14 - 16'){
		                  $Lunedi_1416[] = $nome;
		                  $ContLunedi_1416=$ContLunedi_1416+1;		                  
		              }
		              if($ora == '16 - 18'){
		                  $Lunedi_1618[] = $nome;
		                  $ContLunedi_1618=$ContLunedi_1618+1;		                  
		              }
		          }
		          if($data == 'Martedi'){
		              if($ora == '9 - 11'){
		                  $Martedi_0911[] = $nome;
		                  $ContMartedi_0911=$ContMartedi_0911+1;		                  
		              }
		              if($ora == '11 - 13'){
		                  $Martedi_1113[] = $nome;
		                  $ContMartedi_1113=$ContMartedi_1113+1;		                  
		              }
		              if($ora == '14 - 16'){
		                  $Martedi_1416[] = $nome;
		                  $ContMartedi_1416=$ContMartedi_1416+1;		                  
		              }
		              if($ora == '16 - 18'){
		                  $Martedi_1618[] = $nome;
		                  $ContMartedi_1618=$ContMartedi_1618+1;		                  
		              }
		          }
		          if($data == 'Mercoledi'){
		              if($ora == '9 - 11'){
		                  $Mercoledi_0911[] = $nome;
		                  $ContMercoledi_0911=$ContMercoledi_0911+1;		                  
		              }
		              if($ora == '11 - 13'){
		                  $Mercoledi_1113[] = $nome;
		                  $ContMercoledi_1113=$ContMercoledi_1113+1;		                  
		              }
		              if($ora == '14 - 16'){
		                  $Mercoledi_1416[] = $nome;
		                  $ContMercoledi_1416=$ContMercoledi_1416+1;		                  
		              }
		              if($ora == '16 - 18'){
		                  $Mercoledi_1618[] = $nome;
		                  $ContMercoledi_1618=$ContMercoledi_1618+1;		                  
		              }
		          }
		          if($data == 'Giovedi'){
		              if($ora == '9 - 11'){
		                  $Giovedi_0911[] = $nome;
		                  $ContGiovedi_0911=$ContGiovedi_0911+1;		                  
		              }
		              if($ora == '11 - 13'){
		                  $Giovedi_1113[] = $nome;
		                  $ContGiovedi_1113=$ContGiovedi_1113+1;		                  
		              }
		              if($ora == '14 - 16'){
		                  $Giovedi_1416[] = $nome;
		                  $ContGiovedi_1416=$ContGiovedi_1416+1;		                  
		              }
		              if($ora == '16 - 18'){
		                  $Giovedi_1618[] = $nome;
		                  $ContGiovedi_1618=$ContGiovedi_1618+1;		                  
		              }
		          }
		          if($data == 'Venerdi'){
		              if($ora == '9 - 11'){
		                  $Venerdi_0911[] = $nome;
		                  $ContVenerdi_0911=$ContVenerdi_0911+1;		                  
		              }
		              if($ora == '11 - 13'){
		                  $Venerdi_1113[] = $nome;
		                  $ContVenerdi_1113=$ContVenerdi_1113+1;		                  
		              }
		              if($ora == '14 - 16'){
		                  $Venerdi_1416[] = $nome;
		                  $ContVenerdi_1416=$ContVenerdi_1416+1;		                  
		              }
		              if($ora == '16 - 18'){
		                  $Venerdi_1618[] = $nome;
		                  $ContVenerdi_1618=$ContVenerdi_1618+1;		                  
		              }
		          }
		          echo '<h2> INSERIMENTO MEMORIZZATO</h2><br /> <p><a href="javascript:history.go(-1)"> Torna indietro</a></p><br /> <p><a href="tabella.php"> Guarda la tabella</a></p><br />';
		  }else{
		    echo "Inserisci tutti e due i valori";
				echo '<br / ><a href="javascript:history.go(-1)">Torna indietro</a>';
			}
		}
?>

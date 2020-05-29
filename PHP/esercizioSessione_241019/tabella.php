<html>
    <body>
    		<?php
					session_start();
					$ContLunedi_0911 = $_SESSION['ContLunedi_0911'];
					$ContLunedi_1113 = $_SESSION['ContLunedi_1113'];
					$ContLunedi_1416 = $_SESSION['ContLunedi_1416'];
					$ContLunedi_1618 = $_SESSION['ContLunedi_1618'];
					$ContMartedi_0911 = $_SESSION['ContMartedi_0911'];
					$ContMartedi_1113 = $_SESSION['ContMartedi_1113'];
					$ContMartedi_1416 = $_SESSION['ContMartedi_1416'];
					$ContMartedi_1618 = $_SESSION['ContMartedi_1618'];
					$ContMercoledi_0911 = $_SESSION['ContMercoledi_0911'];
					$ContMercoledi_1113 = $_SESSION['ContMercoledi_1113'];
					$ContMercoledi_1416 = $_SESSION['ContMercoledi_1416'];
					$ContMercoledi_1618 = $_SESSION['ContMercoledi_1618'];
					$ContGiovedi_0911 = $_SESSION['ContGiovedi_0911'];
					$ContGiovedi_1113 = $_SESSION['ContGiovedi_1113'];
					$ContGiovedi_1416 = $_SESSION['ContGiovedi_1416'];
					$ContGiovedi_1618 = $_SESSION['ContGiovedi_1618'];
					$ContVenerdi_0911 = $_SESSION['ContVenerdi_0911'];
					$ContVenerdi_1113 = $_SESSION['ContVenerdi_1113'];
					$ContVenerdi_1416 = $_SESSION['ContVenerdi_1416'];
					$ContVenerdi_1618 = $_SESSION['ContVenerdi_1618'];
    ?>
        <table>
            <tr>
                <th>Giorni</th>
                <th>9 - 11</th>
                <th>11 - 13</th>
                <th>14 - 16</th>
                <th>16 - 18</th> 
            </tr>
            <tr>
                <td>Luned&#237;</td>
                <td><?php  echo $ContLunedi_0911;?></td>
                <td><?php  echo $ContLunedi_1113;?></td>
                <td><?php  echo $ContLunedi_1416;?></td>
                <td><?php  echo $ContLunedi_1618;?></td>
            </tr>
            <tr>
                <td>Marted&#237;</td>
                <td><?php  echo $ContMartedi_0911;?></td>
                <td><?php  echo $ContMartedi_1113;?></td>
                <td><?php  echo $ContMartedi_1416;?></td>
                <td><?php  echo $ContMartedi_1618;?></td>
            </tr>
            <tr>
                <td>Mercoled&#237;</td>
                <td><?php  echo $ContMercoledi_0911;?></td>
                <td><?php  echo $ContMercoledi_1113;?></td>
                <td><?php  echo $ContMercoledi_1416;?></td>
                <td><?php  echo $ContMercoledi_1618;?></td>
            </tr>
            <tr>
                <td>Gioved&#237;</td>
                <td><?php  echo $ContGiovedi_0911;?></td>
                <td><?php  echo $ContGiovedi_1113;?></td>
                <td><?php  echo $ContGiovedi_1416;?></td>
                <td><?php  echo $ContGiovedi_1618;?></td>
            </tr>
            <tr>
                <td>Venerd&#237;</td>
                <td><?php  echo $ContVenerdi_0911;?></td>
                <td><?php  echo $ContVenerdi_1113;?></td>
                <td><?php  echo $ContVenerdi_1416;?></td>
                <td><?php  echo $ContVenerdi_1618;?></td>
            </tr>     
        </table>
        <?php session_destroy(); ?>
    </body>
<html>

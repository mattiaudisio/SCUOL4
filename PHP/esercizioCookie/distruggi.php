<?php
	setcookie("nome", "", time() - 4800);
	setcookie("eta", "", time() - 4800);
	session_destroy();
?>

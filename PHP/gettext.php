<?php

$lang = “it”;
$locale = “it_IT”;
if($_GET[“lang”] == “en”)
{
    $lang = “en”;
    $locale = “en_US”;
}

putenv(“LC_ALL=$locale”);
setlocale(LC_ALL, $locale);
bindtextdomain(“messages”, “/locale”);
textdomain(“messages”);

?>

<html xmlns=”http://www.w3.org/1999/xhtml” xml:lang=”<?php echo $lang; ?>” lang=”<?php echo $lang; ?>”>
    <head>
        <title>
            <?php echo _(“Titolo della finestra”); ?>
        </title>
        <meta http-equiv=”Content-Type” content=”text/html; charset=utf-8″ />
    </head>
    <body>
        <h1><?php echo _(“Prova”); ?></h1>
    
        <p><?php echo _(“Le stringhe possono anche essere molto lunghe e contenere caratteri non Unicode o accentati. Le stringhe possono anche essere molto lunghe e contenere caratteri non Unicode o accentati. Le stringhe possono anche essere molto lunghe e contenere caratteri non Unicode o accentati. Le stringhe possono anche essere molto lunghe e contenere caratteri non Unicode o accentati. Le stringhe possono anche essere molto lunghe e contenere caratteri non Unicode o accentati. Le stringhe possono anche essere molto lunghe e contenere caratteri non Unicode o accentati. Le stringhe possono anche essere molto lunghe e contenere caratteri non Unicode o accentati. “); ?></p>

    </body>
</html>

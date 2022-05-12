<?php
  class Relatore{
      public $cognome = "";
      public $nome = "";
      public $azienda = "";
      public $immagine = "";

      public function __construct($cognome,$nome,$azienda,$immagine){
          $this->cognome = $cognome;
          $this->nome = $nome;
          $this->azienda = $azienda;
          $this->immagine = $immagine;
      }

      public function getCognome(){
        return $this->cognome;
      }

      public function getNome(){
        return $this->nome;
      }

      public function getAzienda(){
        return $this->azienda;
      }

      public function getImmagine(){
        return $this->immagine;
      }

  }
?>

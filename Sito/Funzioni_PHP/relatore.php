<?php
  class Relatore{
      public $cognome = "";
      public $nome = "";
      public $azienda = "";

      public function __construct($cognome,$nome,$azienda){
          $this->cognome = $cognome;
          $this->nome = $nome;
          $this->azienda = $azienda;
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

  }
?>

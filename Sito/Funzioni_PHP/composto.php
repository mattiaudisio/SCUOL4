<?php
  class Composto{
      public $idPart = "";
      public $idProgramma = "";
      public $nPartecipanti = "";

      public function __construct($idPart,$idProgramma,$nPartecipanti){
          $this->idPart = $idPart;
          $this->idProgramma = $idProgramma;
          $this->nPartecipanti = $nPartecipanti;
      }

      public function getIdPart(){
        return $this->cognome;
      }

      public function getIdProgramma(){
        return $this->nome;
      }

      public function getNPartecipanti(){
        return $this->azienda;
      }

  }
?>

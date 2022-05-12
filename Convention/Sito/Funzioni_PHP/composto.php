<?php
  class Composto{
      public $idPart = "";
      public $idProgramma = "";
      public $nPartecipanti = 0;

      public function __construct($idPart,$idProgramma,$nPartecipanti){
          $this->idPart = $idPart;
          $this->idProgramma = $idProgramma;
          $this->nPartecipanti = $nPartecipanti;
      }

      public function getIdPart(){
        return $this->idPart;
      }

      public function getIdProgramma(){
        return $this->idProgramma;
      }

      public function getNPartecipanti(){
        return $this->nPartecipanti;
      }

  }
?>

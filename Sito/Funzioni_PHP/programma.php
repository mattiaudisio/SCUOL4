<?php
  class Programma{
      public $fasciaOraria = "";
      public $titolo = "";
      public $nPosti = 0;
      public $idProgramma = "";

      public function __construct($fasciaOraria,$titolo,$nPosti,$idProgramma){
          $this->fasciaOraria = $fasciaOraria;
          $this->titolo = $titolo;
          $this->nPosti = $nPosti;
          $this->idProgramma = $idProgramma;
      }

      public function getFasciaOraria(){
        return $this->fasciaOraria;
      }

      public function getTitolo(){
        return $this->titolo;
      }

      public function getNPosti(){
        return $this->nPosti;
      }

      public function getIdProgramma(){
          return $this->idProgramma;
      }
  }
?>

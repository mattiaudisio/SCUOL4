<?php
  class Programma{
      public $fasciaOraria = "";
      public $titolo = "";
      public $nPosti = 0;
      public $idProgramma = "";
      public $idSala = "";
      public $immagine = "";

      public function __construct($fasciaOraria,$titolo,$nPosti,$idProgramma,$idSala,$immagine){
          $this->fasciaOraria = $fasciaOraria;
          $this->titolo = $titolo;
          $this->nPosti = $nPosti;
          $this->idProgramma = $idProgramma;
          $this->idSala = $idSala;
          $this->immagine = $immagine;
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

      public function getIdSala(){
          return $this->idSala;
      }

      public function getImmagine(){
          return $this->immagine;
      }
  }
?>

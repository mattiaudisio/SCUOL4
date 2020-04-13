<?php
  class Programma{
      public $fasciaOraria = "";
      public $titolo = "";
      public $nPosti = 0;

      public function __construct($fasciaOraria,$titolo,$nPosti){
          $this->fasciaOraria = $fasciaOraria;
          $this->titolo = $titolo;
          $this->nPosti = $nPosti;
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
  }
?>

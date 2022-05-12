<?php
  class Sala{
      public $idSala = "";
      public $nPosti = 0;
      public $idPiano = "";

      public function __construct($idSala,$nPosti,$idPiano){
          $this->fasciaOraria = $idSala;
          $this->nPosti = $nPosti;
          $this->idPiano = $idPiano;
      }

      public function getIdSala(){
        return $this->fasciaOraria;
      }

      public function getNPosti(){
        return $this->nPosti;
      }

      public function getIdPiano(){
        return $this->idPiano;
      }

  }
?>

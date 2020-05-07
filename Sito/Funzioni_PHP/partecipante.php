<?php
  class Partecipante{
      public $idPart = "";
      public $congomePart = "";
      public $nomePart = "";
      public $mailPart = "";
      public $tipologiaPart = "";

      public function __construct($idPart,$congomePart,$nomePart,$mailPart,$tipologiaPart){
          $this->idPart = $idPart;
          $this->congomePart = $congomePart;
          $this->nomePart = $nomePart;
          $this->mailPart = $mailPart;
          $this->tipologiaPart = $tipologiaPart;
      }

      public function getIdPart(){
        return $this->idPart;
      }

      public function getCongomePart(){
        return $this->congomePart;
      }

      public function getNomePart(){
        return $this->nomePart;
      }

      public function getMailPart(){
        return $this->mailPart;
      }

      public function getTipologiaPart(){
        return $this->tipologiaPart;
      }
  }
?>

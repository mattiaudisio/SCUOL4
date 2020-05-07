<?php
  class Partecipante{
      public $idPart = "";
      public $cognomePart = "";
      public $nomePart = "";
      public $mailPart = "";
      public $tipologiaPart = "";
      public $passwordPart = "";

      public function __construct($idPart,$cognomePart,$nomePart,$mailPart,$tipologiaPart,$passwordPart){
          $this->idPart = $idPart;
          $this->cognomePart = $cognomePart;
          $this->nomePart = $nomePart;
          $this->mailPart = $mailPart;
          $this->tipologiaPart = $tipologiaPart;
          $this->passwordPart = $passwordPart;
      }

      public function getIdPart(){
        return $this->idPart;
      }

      public function getCognomePart(){
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

      public function getPasswordPart(){
        return $this->passwordPart;
      }
  }
?>

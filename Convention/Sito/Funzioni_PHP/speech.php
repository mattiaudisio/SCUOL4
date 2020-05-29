<?php
    class Speech{
        public $titolo = "";
        public $argomento = "";

        public function __construct($titolo,$argomento){
            $this->titolo = $titolo;
            $this->argomento = $argomento;
        }

        public function getTitolo(){
            return $this->titolo;
        }

        public function getArgomento(){
            return $this->argomento;
        }
    }
?>

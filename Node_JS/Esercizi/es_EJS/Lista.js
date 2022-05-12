var mioFs = require("fs");
var Prenotazione = require("./Prenotazione.js").miaPrenotazione;
var mioExpress = require("express");
var mioBodyParser = require("body-parser");
var objApp = new mioExpress;
objApp.set('view engine', 'ejs');

var strListaEventi = [];
var controllo;

class Lista(){
	
	aggiungiEventi(nomeEvento,numeroPersone){
		for(i=0; i < strListaEventi.length; i++){
			if(nomeEvento == ListaEventi[i].getNomeEvento){
				ListaEventi[i].setumeroPersone(ListaEventi[i].getumeroPersone + numeroPersone);
			}else{
				controllo = false;
			}
		}
		if(controllo == false){
			strListaEventi.push(new Prenotazione(nomeEvento,numeroPersone));
		}
	}
	
	mostraEvento(){
		var eventoMax = "";
		var numMax = 0;
		for(var i = 0; i < strListaEventi.length; i++){
			if(strListaEventi[i].getNumeroPersone() > numMax){
				numMax = strListaEventi[i].getNumeroPersone();
				eventoMax = strListaEventi[i].getNomeEvento();
			}
		}
		response.render("./wiews/riepilogo.ejs",{Nome:eventoMax,Numero:numMax});
	}
}
module.exports={miaLista:Lista};
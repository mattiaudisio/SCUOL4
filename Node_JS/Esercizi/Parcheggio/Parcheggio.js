var mioExpress = require("express");
var mioFS = require("fs");
var mioBodyParser = require("body-parser");
var Vettura = require("./Vettura.js").miaVettura;

var numMax = 100;
var numVet = 0;
var oraLocale = 0;
var Vetture = [];
var targaMax = [];

class Parcheggio{
	constructor(nPosti,nVetture,ora){
		this.nPosti = nPosti;
		this.nVetture = nVetture;
		this.ora = ora;
	}
	
	get getOraLocale(){
		return this.oraLocale;
	}
	
	get getNPosti(){
		return this.NPosti;
	}
	
	get getNVetture(){
		return this.NVetture;		
	}
	
	get getOra(){
		return this.Ora;		
	}
	
	setNPosti(nPosti){
		this.nPosti = nPosti;
	}
	
	setNVetture(nVetture){
		this.nVetture = nVetture;
	}
	
	setOra(ora){
		this.ora = ora;
	}
	
	entraVettura(targa,oraArrivo,oraScadenza){
		if(numVet === numMax){
			Vetture.push(new Vettura(targa,oraArrivo,oraScadenza));
			numVet = numVet + 1;
			console.log("true");
		}else{
			console.log("Hai raggiunto la capienza massima");
		}
	}
	
	esceVettura(targa){
		Vetture.forEach(vettureParcheggiate	=>{
			if(vettureParcheggiate.getTarga === targa){
				vettureParcheggiate.pop(vettureParcheggiate);
				numVet = numVet - 1;
				console.log("true");
			}
		});
	}
	
	aggiornaOra(){
		oraLocale = oraLocale + 1;
		Vetture.forEach(vettureParcheggiate	=>{
			if(vettureParcheggiate.getOraScadenza <= oraLocale){
				vettureParcheggiate.pop(vettureParcheggiate);
			}
		});
	}
	
	promozione(codice){
		Vetture.forEach(vettureParcheggiate =>{
			var targa = vettureParcheggiate.getTarga;
			var lunghezzaTarga = targa.length;
			var ultimeLettere = targa.slice((lunghezzaTarga-2));
			if(ultimeLettere === codice){
				var oreGratuite = Math.floor(Math.random()*Math.floor(10))+1;
				var oreNuove = vettureParcheggiate.getOraScadenza+oreGratuite;
				vettureParcheggiate.setOraScadenza(oreNuove);
			}
		});
	}
	
	function ordina(A,B){
		var oggA = A.getOraScadenza - A.getOraArrivo;
		var oggB = B.getOraScadenza - B.getOraArrivo;
		if(oggA < oggB){
			return -1;
		}
		if(oggA > oggB){
			return 1;
		}
		return 0;
	}
	
	statVetture(){
		var stringa = "";
		Vetture.sort(ordina);
		Vetture.shift();
		for(var i = 0; i < Vetture.lenght; i++){
			stringa= stringa + "Targa:"+Vetture[i].getTarga+" ora Arrivo:"+Vetture[i].getOraArrivo+"ora Scadenza"+Vetture[i].getOraScadenza+"\n";
			response.write(stringa);
			response.write("<br>");
		}
	}

}
module.exports={mioParcheggio:Parcheggio};
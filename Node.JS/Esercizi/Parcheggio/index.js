var http = require("http");
var url = require("url");
var qs = require("querystring");
var mioExpress = require("express");
var mioFs = require("fs");
var mioBodyParser = require("body-parser");
var mioParcheggio = require("./Parcheggio.js").mioParcheggio;
var objApp = new mioExpress;


http.createServer(function(request,response){

	objApp.get("/",function(request,response,next){
		var index_file = mioFs.readFileSync("/sito/index.html");		
	});
	
	objApp.post("/entraVettura",function(request,response,next){
		var targa = request.body.targa;
		var oraScadenza = request.body.oraScadenza;
		mioParcheggio.entraVettura(targa,mioParcheggio.getOraLocale,oraScadenza);
		console.log("\nvettura aggiunta\n");
		response.end();
	});

	objApp.post("/esceVettura",function(request,response,next){
		var targa = request.body.targa;
		mioParcheggio.esceVettura(targa);
		console.log("\nvettura uscita\n");
		response.end();
	});
	
	objApp.post("/aggiornaOra",function(request,response,next){
		mioParcheggio.aggiornaOra();
		console.log("\nora aggiornata\n");
		response.end();
	});
	
	objApp.post("/promozione",function(request,response,next){
		var codice = request.body.codice;
		mioParcheggio.promozione(codice);
		console.log("\npromozione fatta\n");
		response.end();
	});
	
	objApp.post("/statVetture",function(request,response,next){
		mioParcheggio.statVetture();
		response.end();
	});	
	
}).listen(1996,"127.0.0.1");
var express = require("express");
var mioExpress = express();
var prodotti = require('./prodotti.js').prodottiComprati;
mioExpress.set('view engine','ejs');
var prodottiAcquistati = new prodotti();
mioExpress.listen(1245,function(){
	
	mioExpress.get("/",function(request,response,next){
		response.sendFile(__dirname+"/sito/index.html");
		console.log();
	});
	
	mioExpress.get("/salva",function(request,response,next){
		var nomeProdotto = request.query.nomeProdotto;
		var numeroProdotto = request.query.numeroProdotto;
		prodottiAquistati.aggiungi(nomeProdotto,numeroProdotto);
		console.log();
	});
	
	mioExpress.get("/raccolta",function(request,response,next){
		response.render("./raccoltaEjs.ejs",{parametroProdotti:prodottiAcquistati});
	});
	
	mioExpress.get("/riepilogo",function(request,response,next){
		response.render("./riepilogoEJS.ejs",{parametroProdotti:prodottiAcquistati});		
	});
});
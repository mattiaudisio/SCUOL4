var mioExpress = require("express");
var miaApp = mioExpress();
miaApp.set('view engine','ejs');
var mieTemperature = require("./Temperature").mieTemperature;
var temperature = new mieTemperature();
const start = Date.now();

miaApp.listen(1478,function(){
		
	miaApp.get("/",function(request, response, next){
		response.sendFile(__dirname + "/sito/index.html");
	});
	
	miaApp.get("/salva",function(request,response,next){
		var tempMinima = request.query.tempMinima;
		var tempMassima = request.query.tempMassima;
		var citta = request.query.citta;
		const timeStamp = Date.now() - start;
		temperature.add(tempMinima,tempMassima,citta,timeStamp);
		response.send("inserimento effettuato");
	});
	
	miaApp.get("/riepilogo",function(request,response,next){
		temperature.ordina();
		response.render("./views/riepilogo.ejs",{miaTemperatura:temperature});		
	});
});
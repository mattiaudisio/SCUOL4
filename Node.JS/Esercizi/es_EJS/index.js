var mioFs = require("fs");
var mioHttp = require("http");
var mioExpress = require("express");
var objApp = new mioExpress;
var mioBodyParser = require("body-parser");
var listaPren = require("./Lista.js").miaLista; 
objApp.use(mioBodyParser.json());
objApp.use(mioBodyParser.urlencoded({extended:true}));
objApp.set('view engine', 'ejs');

var server = objExpress.listen(1700, function(){
	console.log("Server in esecuzione!");
});

objApp.get("/",function(request,response,next){
	response.sendFile(__dirname+"index.html");
});
	
objApp.get("/inserisci",function(request,response,next){
	response.sendFile(__dirname+"/wiews/inserisici.ejs");
});
	
objApp.get("/prenotazione",function(request,response,next){
	var nomeEvento = request.body.nomeEvento;
	var numeroPersone = request.body.numeroPersone;
	if(nomeEvento.length != 0 && numeroPersone.length != 0){
		listaPren.aggiungiEventi(nomeEvento,numeroPersone);
		response.render('./wiews/prenotazione.ejs',{Nome:nomeEvento, Numero:numeroPersone});
	}
});
	
objApp.get("/riepilogo",function(request,response,next){
	response.sendFile(__dirname+"/wiews/riepilogo.ejs");
	listaPren.mostraEvento();
});
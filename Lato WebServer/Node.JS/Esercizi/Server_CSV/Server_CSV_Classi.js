var fs = require("fs");
var http = require("http");			
var url=require("url");
var qs = require("querystring");
var mieiContatti = [];
var mieiDati = "";
var Contatto = require("./contatti.js").mioContatto;
var server=http.createServer(function(request,response){	
	console.log("Sto per scrivere");
	var endpoint = url.parse(request.url,true);
	console.log("Fuori: "+endpoint.path);
	response.writeHead(200,{'Content-Type':'text/html; charset=utf-8'});
	switch(endpoint.pathname){	//POST: endpoint.path		GET: endpoint.pathname
	
		case "/visualizza":
			response.write(mieiDati);
			response.end();
			break;

		case "/carica":

			break;
			
		case "/ordinaForm":

			response.end();
		    break;    
		    	

		case "/cercaForm":

			response.end();
		    break;    

			
		case "/elimina":

			response.end();
			break;
			
		case "/":
			var HomePage = "<HTML> <BODY> <a href='/visualizzaForm'>Visualizza</a><br /><a href='/caricaForm'>Carica</a><br /><a href='/eliminaForm'>Elimina</a><a href='/ordinaForm'>Ordina</aa href='/cercaForm'>Cerca</a/BODY> </HTML>";
				response.write(HomePage);
			response.end();
			break;
			
		case "/caricaForm":
			//Visualizza un form
			var filehtml = fs.readFileSync("form_carica.html");
			response.write(filehtml);
			response.end();
			break;			
	}		
}).listen(1575,"127.0.0.1");

var mioExpress = require("express");
var objApp = new mioExpress;
var fs = require("fs");
var http = require("http");			
var url=require("url");
var qs = require("querystring");
var mieiDati = "";
var varDato = "";
var server=http.createServer(function(request,response){	
	console.log("Sto per scrivere");
	var endpoint = url.parse(request.url,true);
	console.log("Fuori: "+endpoint.path);
	response.writeHead(200,{'Content-Type':'text/html; charset=utf-8'});
	
	objApp.use("/visualizza",function(request,response,next){
		console.log("Path:"+endpoint.path);	//Stampa il path(Es: favicon.ico)
		var mieiDati = fs.readFileSync("Rubrica.txt","utf-8");			
		response.write(mieiDati);
		console.log("Ho Letto!");
		response.end();		
	});
	
	objApp.use("/carica",function(request,response,next){
		if(request.method=="GET"){
			varDato = endpoint.query.nome + " " + endpoint.query.cognome + " " + endpoint.query.tel + "\n";				
			fs.appendFile("Rubrica.txt",varDato, function(errore,data){
				if(errore){
					console.log("Errore!");
				} 
			});
			response.end();
		}else{
			//Per prendere i valori non possono utilizzare il modulo url
			var concatenaDati="";
			request.on("data",function(mieiparametri){	//2 parametri: l'evento e la callback
				//Tutte le volte che noi passiamo dei dati in POST, richiama l'evento data
				concatenaDati+=mieiparametri;
			});
			request.on("end",function(){
				response.write(concatenaDati);
				response.write("<br>");
				var mieiParametri = qs.parse(concatenaDati);
				response.write(mieiParametri["cognome"]);
				varDato = mieiParametri["nome"] + " " + mieiParametri["cognome"] + " " + mieiParametri["tel"] + "\n";
				console.log(varDato);
				fs.appendFile("Rubrica.txt",varDato, function(errore,data){
					if(errore){
						console.log("Errore!");
					} 
				});
				response.end();					
			});
			request.on("errore",function(){
				response.write("Errore");
				response.end();
			});
		}
	});
	
	objApp.use("/ordinaForm",function(request,response,next){
		fs.appendFile("Rubrica.txt",varDato, function(errore,data){
			mieiDati.sort();
			if(errore){
				console.log("Errore!");
			} 
		});
		response.end();		
	});
	
	objApp.use("/cercaForm",function(request,response,next){
		mieiDati = fs.readFileSync("Rubrica.txt","utf-8");
		var nomeCerca = "Mario";
	    var Nome = mieiDati.indexOf("NomeCerca");
		response.write(Nome);
		response.end();
	});
	
	objApp.use("/elimina",function(request,response,next){
        var mieiDati = fs.readFileSync("Rubrica.txt","utf-8");
        theFile = data.toString().split("\n");
        theFile.splice(-1,1);
        fs.writeFile(filename, theFile.join("\n"), function(err) {
	        if(err) {
	            return console.log(err);
	        }
			response.end();
        });
	});

        
	objApp.use("/",function(request,response,next){
		var HomePage = "<HTML> <BODY> <a href='/visualizzaForm'>Visualizza</a><br /><a href='/caricaForm'>Carica</a><br /><a href='/eliminaForm'>Elimina</a><a href='/ordinaForm'>Ordina</aa href='/cercaForm'>Cerca</a/BODY> </HTML>";
		response.write(HomePage);
		response.end();
	});
    
	objApp.use("/caricaForm",function(request,response,next){
		//Visualizza un form
		var filehtml = fs.readFileSync("form_carica.html");
		response.write(filehtml);
		response.end();
	});		
}).listen(1575,"127.0.0.1");

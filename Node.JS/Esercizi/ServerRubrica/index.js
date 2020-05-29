var http = require("http");
var fs = require("fs");
var mieiDati = "";
var url = require("url");
var qs = require("querystring");
var mioExpress = require("express");
var objApp = new mioExpress;

var server = http.createServer(function(request, response){
	var endpoint = url.parse(request.url,true);
	console.log("\nURL fuori switch --> "+ endpoint.path);

	objApp.use("/visualizza",function(request,response,next){
		mieiDati = fs.readFileSync("Rubrica.json","utf-8");
		mieiDati = JSON.parse(mieiDati);
		response.write(mieiDati);
		response.end();
	});
	
	objApp.use("/carica",function(request,response,next){
			var str = "";
			if (request.method === "GET"){
//				Metodo post
				str = endpoint.query.nome + ' ' + endpoint.query.cognome + ' ' + endpoint.query.telefono + '\n';
				fs.appendFileSync('Rubrica.json', str);
				response.write("<b>Caricamento effettuato! </b> <a href='/'>Ritorna alla pagina iniziale! </a>");
				response.end();
			}else{
				var concatenaDati = "";
				request.on("data", function (mieiParametri){
					concatenaDati += mieiParametri;
				});
				request.on("end",function(){
					var mieiParametri = qs.parse(concatenaDati);
					str = mieiParametri["nome"] + ' ' + mieiParametri["cognome"] + ' ' + mieiParametri["telefono"] + '\n';
					fs.appendFileSync('Rubrica.json', str);
					response.write("<b>Caricamento effettuato! </b> <a href='/'>Ritorna alla pagina iniziale! </a>");
					response.end();
				});
				request.on("error", function (){	
				});
			}
	});

	objApp.use("/caricaform",function(request,response,next){
			var form_file = fs.readFileSync("form_carica.html");
			response.write(form_file);
			response.end();
	});		

	objApp.use("/elimina",function(request,response,next){
		var contatti = [];
		var i = 1;
		var str = "";
		var tmp = fs.readFileSync("Rubrica.json","utf-8");
		contatti = tmp.split("\n");
		var mieiParametri = qs.parse(concatenaDati);
		for(var i=0; i < contatti.length;i++){
			var anagrafica = contatti[i].split(" ");
			if (anagrafica[1] === endpoint.query.cognome){
				contatti[i] = "";
			}else{
				str += contatti[i] + '\n';
			}
		}
		fs.unlinkSync('Rubrica.json');
		fs.writeFileSync('Rubrica.json', str);
		response.write("<b>Eliminazione effettuata! </b> <a href='/'>Ritorna alla pagina iniziale! </a>");
		response.end();
	});		

	objApp.use("/eliminaform",function(request,response,next){
		var form_file = fs.readFileSync("form_elimina.html");
		response.write(form_file);
		response.end();
	});	
			
	objApp.use("/ordina",function(request,response,next){
	    var arrayRubrica=[];
	    var i = 0;
	    var stringaFinale = "";
	    var lineReader = require('readline').createInterface({
		      input: require('fs').createReadStream('Rubrica.txt')
		    });
	    lineReader.on('line', function (line) {
		    arrayRubrica[i] = line;
		    i++;
	    });
	    lineReader.on('close', function (line) {
		    arrayRubrica.sort(); //ordinamento array
		    arrayRubrica.forEach(elemento => {
			    stringaFinale+=elemento + "\n";
		    });
		    stringaFinale = stringaFinale.slice(0, -1); //rimuovo ultimo \n
		    fs.writeFile("Rubrica.txt", stringaFinale, function(errore){
			    if(errore){
				    console.log("ERRORE SCRITTURA");
			    }
		    });
	    });
	});
		
	objApp.use("/",function(request,response,next){
		var homePage = "<html><body> <h1><a href='/visualizza'>Visualizza</a></h1> <h1><a href='/ordina'>Ordina rubrica</a></h1> <h1><a href='/eliminaform'>Elimina</a></h1> <h1><a href='/caricaform'>Carica</a></h1></body></html>"
		response.write(homePage);
		response.end();
	});
}).listen(11391,"127.0.0.1");

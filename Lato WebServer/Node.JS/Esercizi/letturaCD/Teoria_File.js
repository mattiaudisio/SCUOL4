/**
 * http://usejsdoc.org/
 */

var http = require ("http");	//importiamo il modulo http
var fs = require("fs")			//importiamo il modulo File System (fs)
//Contiene delle funzioni asincrone/asincrone che ci permettono sul server di modificare i file
var url =require("url");
var mieiDati = "";
var server = http.createServer(function(request,response){	//è una funzione che ha come parametro una callback (vuol dire che ha all'interno un'altra funzione)
	//Viene richiamata dopo che viene creato il server
	console.log("Sto per scrivere");
	var x = url.parse(request.url.true)
	console.log(x.path);
	//Metodo Asincrono	
	fs.writeFile("Rubrica.txt", "Mario Rossi 7845691032\n", function(errore) {	//function vuole un parametro
		if(errore) console.log("Errore");
		console.log("Sono nella funzione callback");
		fs.readFile("Rubrica.txt","utf-8",function(errore, data) {		//Questo read verrà chiamato solo dopo aver scritto
			if(errore) console.log("Errore");
			mieiDati = data;
		})		
	});
	//fs.writeFileSync("Rubrica.txt", "Mario Rossi 7845691032\n");	//Metodo Sincrono
	response.write(mieiDati);
	console.log("Ho scritto!");
	response.end();
}).listen(1347,"127.0.0.1");	//Mettere solo la porta vuol dire che il server viene messo in ascolto con tutti i miei indirizzi di rete	
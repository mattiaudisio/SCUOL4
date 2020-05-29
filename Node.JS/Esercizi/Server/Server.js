/**
 * http://usejsdoc.org/
 */

//Usiamo le porte dalla 1024 alla 40000 perchè le prime sono predefinite e non si possono usare
//Serve.js è una pagina web che deve rimanere in ascolto
var moduloHttp=require("http");			//abbiamo creato il modulo http
//creiamo creato il server
var mioUrl=require("url:");
var server=moduloHttp.createServer(function(request,response){	//questa è una funzione callback
	//Prima viene creato il server poi viene richiamato questa funzione
	var mioOggettoUrl=mioUrl.parse(request.url,true);	//2 parametri: il vero url e true o false. true viene tratto come Json, false come una stringa
	var mioParametro=mioOggettoUrl.query.var1;
	response.writeHead(200,{'Content-Type':'text/plain;charset=utf-8'});	//Invia le informazioni nascoste
	//charset=utf-8 mi mostra i caratteri "speciali"
	response.write("<b>Ciao mondo!</b>");
	response.write("Ciao Verzuolo!");
	console.log("Mio parametro: "+mioParametro)
	response.end();	//Chiude la connessione tra il server ed il client
	server.close();
}).listen(1359,"127.0.0.1");	//ci vogliono 2 valori: il primo è intero che corrisponde alla porta, il secondo indirizzo IP
//Posso anche fare server.listen();

console.log("Il server è in esecuzione!")

//La funzione callback possiede 2 oggetti: uno oggetto di tipo request ed un oggetto di tipo response
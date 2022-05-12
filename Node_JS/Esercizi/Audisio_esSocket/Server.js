var net = require('net');
var utenti = require("/Utenti.js").utenti;


var utenti = new utenti();
var Server = net.createServer(function(mioSocket){

	mioSocket.on("data",function(msg){
		var singoloUtente = utenti.cerca(mioSocket,mioSocket.remoteAddress);
	});
});
var uniqid = require('uniqid');
var net = require("net");
var orario = new Date().getHours();

var tcpServer = net.createServer('connection',function(mioSocket){
	
	mioSocket.id = uniqid();
	
	mioSocket.on('data',(data){
		mioSocket.write(`Il client ${mioSocket.nome} si è conesso alle ${orario}`);
	});
	
	mioSocket.on("end",function(){
		console.log("connessione chiusa: " + this.remoteAddress + " - "+ this.remotePort);
	});
	
}).listen(1368);
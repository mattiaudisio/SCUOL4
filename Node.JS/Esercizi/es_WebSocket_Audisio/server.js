var http = require("http");
var express = require("express");
var app = express();
var server = http.createServer(app);
var io = require("socket.io")(server);


var risultato = 0;
var M1 = 0;
var M2 = 0;

server.listen(1984);

app.use(express.static(__dirname+"/node_modules"));


app.get("/",function(request,response){
	response.sendFile(__dirname+"/sito/index.html");
});	

io.on("connection",function(socket)){
	socket.on("calcolatrice",function(valX,valY,comando,valM1){
		switch(comando){
			case 'ADD':
				risultato = valX + valY;
				socket.broadcast.emit('risultato',risultato);
				break;
			case 'SUB':
				risultato = valX - valY;
				socket.broadcast.emit('risultato',risultato);
				break;
			case 'MUL':
				risultato = valX * valY;
				socket.broadcast.emit('risultato',risultato);
				break;
			case 'DIV':
				risultato = valX / valY;
				socket.broadcast.emit('risultato',risultato);
				break;
			case 'POW':
				risultato = Math.pow(valX,valY);
				socket.broadcast.emit('risultato',risultato);
				break;	
			case 'MEM':
				if(valM1.checked){
					M1 = valX;
				}else{
					M2 = valX;					
				}
				break;					
			case 'STORE':
				if(valM1.checked){
					M1 = risultato;
				}else{
					M2 = risultato;					
				}
				break;				
			case 'CLEAR':
				if(valM1.checked){
					M1 = 0;
				}else{
					M2 = 0;					
				}
				break;				
			default:
				var errore = "Comando non riconosciuto";
				socket.broadcast.emit('risultato',errore);
				break;
			}		
	});
});
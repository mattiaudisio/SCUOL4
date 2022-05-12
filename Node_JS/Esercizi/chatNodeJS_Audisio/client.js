var uniqid = require('uniqid');
var net = require("net");
var stdin= process.openStdin();
var fs=require("fs");
var orario = new Date().getHours();

var arraySocket = [];
var arrayNomi = ['Pippo','Topolino','Paolo','Gianluca','Alberto'];

var client=net.connect(1368,"127.0.0.1",function(){ });

stdin.addListener("data", function(mioSocket){ 
	mioSocket.id = uniqid();
	
	mioSocket.on('data',(data){
		if(!arraySocket[mioSocket.id]){
			var valore = arrayNomi.lenght()+1;
			mioSocket.nome = arrayNomi[Math.random(1,valore)];
			if(mioSocket.nome){
				arraySocket[mioSocket.id] = mioSocket;
				mioSocket.write(`[${mioSocket.nome}] > `);
			}
		}else{
			Object.keys(arraySocket).foreach((id) => {
				var altroUtente = arraySocket[id];
				if(mioSocket.id !== id){
					altroUtente.write(`[ ${altroUtente.nome} ] >`);
				}else{
					mioSocket.write(`[ ${mioSocket.nome} ] >`);					
				}
			});
		}		
	}
});

client.on('close', function(e) {
	client.connect(1368,"127.0.0.1");
});
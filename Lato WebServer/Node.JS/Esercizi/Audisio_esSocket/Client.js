var net = require('net');
var stdin = process.openStdin();
var orario = new Date().getHours();

var client = net.connet(1984,"127.0.0.1"){
	
	client.on("data",function(data){
		client.write(`${orario}`);
	});
	
	client.on("close", function() {
		client.connect(1368,"127.0.0.1");
	});
}

stdin.addListener("data",function(msg){
	client.write(msg.toString());
});
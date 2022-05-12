//Le variaibili non sono tipizzate, possono non essere dichiarate,

var miaVariabile;	//Viene inizializzata come undefined; è una variabile GLOBALE

function primaFunzione(){
	//var pincopallino è una variabile LOCALE
	//let variabileLocale ci crea una variabile che sarà presente solo nei cicli For, While e If
	console.log("prova nodeJS1\n");
	for(let i=0; i<10; i++){
		console.log("Prima funzione "+i);
	}
	console.log("\n");
}

function secondaFunzione(){
	console.log("prova nodeJS2\n");
	for(let j=0; j<10; j++){
		console.log("Seconda funzione "+j);
	}
	console.log("\n");
}

primaFunzione(secondaFunzione());
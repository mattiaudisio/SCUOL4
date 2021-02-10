//Posso fare questo perchè sto usando ES6
//destrutturazione (DISPONIBILE CON ES6)
var http = require("http");
//Dobbiamo importare il modulo
//il ./ ci deve essere sempre, dice che è presente nella cartella principale
var Contatto = require("./contatti.js").mioContatto;	//Per importare il modulo, si importa sempre fuori
//Da ora contatto è la classe
//Deve esserci il '.nomeClasse' perchè in un file ci possono essere più classi, il nome deve essere uguale a quello che abbiamo messo nell'esportazione in contatti.js
var mieiContatti=[];	//Creazione Array
http.createServer(function(request,response){
	//bisogna istanziare l'oggetto
	var contatto_1=new Contatto("provanome","provacognome","1111111111","prova@prova");
	var {nome,cognome,telefono}=contatto_1;	//Destrutturazione:Prende i campi di quell'oggetto
	console.log(telefono);
	console.log(contatto_1.concatena());
	contatto_1.setIndirizzo="strada provinciale cuneo";	//Solo i metodi alle le ( ), le proprietà no
	console.log(contatto_1.concatena_2());
	console.log(contatto_1.getNome);		//Senza ( ) perchè è una proprietà
	for(let i=0; i<3; i++){
		//push inserisce pop elimina
		mieiContatti.push(new Contatto("provanome","provacognome","1111111111","prova@prova"));		
	}
	console.log(mieiContatti.length);				//Mi da la lunghezza dell'array
	console.log(mieiContatti);						//Mi visualizza un JSON
	console.log(mieiContatti[0].getNome);			//Mi prende l'oggetto JSON contenuto nella prima cella (QUA CON OGGETTI)
	var stringJSON=JSON.stringify(mieiContatti);	//trasforma l'oggetto JSON in stringa
	console.log(stringJSON);						//Mi visualizza un JSON trasformato in stringa (una stringa di JSON)
	var oggettiJSON=JSON.parse(stringJSON);			//trasforma la stringa in oggetti JSON
	console.log(oggettiJSON[0].nome);				//Mi prende l'oggetto JSON contenuto nella prima cella (QUA CON STRINGA)	
	response.end();
}).listen(1996,"127.0.0.1");
//SERIALIZZARE UNA CLASSE: PRENDERE L'OGGETTO E TRASFROMARLO IN STRINGA IN UN FILE DI TESTO
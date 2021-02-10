//							***FUNZIONE CALLBACK***
//La funzione callback è una funzione che viene passata come parametro
function stampa(5,callback){		
	//Posso non dichiarare la variabili, ma le variabili non dichiarate diventano variabili globali
	var i = 0
	for(i=0; i<10; i++){		//la variabile let è una variabile locale alla funzione		
		console.log("Stampa 1: "+i);
	}
	console.log("\n");
	//Dal momento che vogliamo passare a stampa2 il valore della i, basta scrivere in callback il valore che si vuole passare
	callback(i);	//Dopo aver eseguito il ciclo For, richiama la sua variabile callback, che in questo caso è stampa2
}

function stampa2(x){	//x è il valore 50 che gli viene passata da stampa
	for(let i=0; i<x; i++){
		console.log("Stampa 2 :"+i)
	}
}

//Main, posso anche non mettere il punto e virgola
//Una funzione può avere come parametro un altra funzione (Posso avere più funzioni callback)
stampa(5,stampa2);	//CallBack: la funzione passata come parametro
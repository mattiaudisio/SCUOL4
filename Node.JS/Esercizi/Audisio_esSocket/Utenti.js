var utente = require("/Utente.js").utente;
var arrayUtenti;
var controllo;
var oggettoUtente;

class Utenti{
	
	constructor(){
		arrayUtenti = [];
	}
	
	cerca(socketClient,ipClient){
		var oggettoUtente;
		for(var i = 0; i < arrayUtenti.length; i++){
			if(arrayUtenti[i].getIndirizzoIP == ipClient){
				controllo = true;
				oggettoUtente = arrayUtenti[i];
			}
		}
		if(controllo == true){
			controllo = false;
			return oggettoUtente;
		}else{
			aggiungi(socketClient,ipClient);
		}
	}
}
module.exports = {utenti: Utenti}
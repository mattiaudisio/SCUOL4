class Utente{
	
	constructor(socketUtente,indirizzoIP,nickname){
		this.socketUtente = socketUtente;
		this.indirizzoIP = indirizzoIP;
		this.nickname = nickname;
	}
	
	get	getIndirizzoIP(){
		return this.indirizzoIP;
	}
}
module.exports = {utente: Utente}
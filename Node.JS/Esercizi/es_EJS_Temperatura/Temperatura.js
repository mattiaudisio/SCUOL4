class Temperatura{
	
	constructor (tempMinima, tempMassima, citta, timeStamp){
		this.tempMinima = tempMinima;
		this.tempMassima = tempMassima;
		this.citta = citta;
		this.timeStamp = timeStamp;
	}
	
	getTempMinima(){
		return this.tempMinima;
	}

	getTempMassima(){
		return this.tempMassima;
	}

	getCitta(){
		return this.citta;
	}

	getTimeStamp(){
		return this.timeStamp;
	}
	
	setTempMinima(tempMinima){
		this.tempMinima = tempMinima;
	}

	setTempMassima(tempMassima){
		this.tempMassima = tempMassima;
	}

	setTimeStamp(timeStamp){
		this.timeStamp = timeStamp;
	}
}
module.exports = {miaTemperatura:Temperatura};
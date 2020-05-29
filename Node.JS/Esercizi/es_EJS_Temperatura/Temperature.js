var miaTemperatura = require("./Temperatura").miaTemperatura;
var MieTemperature = new Array();
var temperatureRiepilogo = new Array();
var nomiCitta = new Array("Verzuolo","Milano","Torino","Firenze","Bologna","Roma","Napoli","Bari","Messina");

class Temperature{
	
	carica(tempMinima,tempMassima,citta,timeStamp){
		var temperatura = new miaTemperatura(tempMinima,tempMassima,citta,timeStamp);
		MieTemperature.push(temperatura);
	}
		
	Ordina(){
		for(var i = 0; i < MieTemperature.length(); i++){
			temperatureRiepilogo.push(new miaTemperatura(0,0,nomiCitta(i),0));
		}
		for(var i = 0; i > MieTemperature.length(); i++){
			for(var j = 0; j > temperatureRiepilogo(i).length(); i++){
				if(MieTemperature(i).getCitta() == temperatureRiepilogo(j).getCitta()){
					if(MieTemperature(i).getTempMassima() > temperatureRiepilogo(j).getTempMassima()){
						temperatureRiepilogo(j).setTempMassima(MieTemperature(i).getTempMassima());
					}
				}				
			}
		}
	}
}
module.exports = {mieTemperature:Temperature};
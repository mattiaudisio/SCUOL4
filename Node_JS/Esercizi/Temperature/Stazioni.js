var Stazione=require("./Stazione.js").Stazione;

class Stazioni{
		
	constructor(){
		this.listaStazioni=new Array(); 
	}
		
	add(tempMax,tempMin,citta){
		this.listaStazioni.push(new Stazione(tempMax,tempMin,citta));
	}
	
	media(mediaV,mediaM,mediaT,mediaF,mediaB,mediaR,mediaN,mediaB2,mediaM2){
		for(var i=0;i<this.listaStazioni.length;i++){
			switch (this.listaStazioni[i].getcitta){
				case "Verzuolo":
				mediaV=mediaV+this.listaStazioni[i].getMin;
				break;
				case "Milano":
					mediaM=mediaM+this.listaStazioni[i].getMin;
					break;
				case "Torino":
					mediaT=mediaT+this.listaStazioni[i].getMin;
					break;
				case "Firenze":
					mediaF=mediaF+this.listaStazioni[i].getMin;
					break;
				case "Bologna":
					mediaB=mediaB+this.listaStazioni[i].getMin;
					break;
				case "Roma":
					mediaR=mediaR+this.listaStazioni[i].getMin;
					break;
				case "Napoli":
					mediaN=mediaN+this.listaStazioni[i].getMin;
					break;
				case "Bari":
					mediaB2=mediaB+this.listaStazioni[i].getMin;
					break;
				case "Messina":
					mediaM=mediaM+this.listaStazioni[i].getMin;
					break;				
			}
		}
	}
}
module.exports={Stazioni:Stazioni}
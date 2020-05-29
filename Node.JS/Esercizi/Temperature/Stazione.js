
class Stazione{
	
	constructor(tempMax,tempMin,citta){
		this.tempMax=tempMax;
		this.tempMin=tempMin;
		this.citta=citta;
		this.data= Date.now().toString;
		this.zona = zona(citta);
	}
	
	get getCitta(){
		
		return this.citta;
	}

	get getMin(){
		
		return this.tempMin;
	}

	get getMax(){
		
		return this.tempMax;
	}
	
	get getZona(){
		
		return this.zona;
	}
}
module.exports={Stazione:Stazione}

	function zona(citta){
		switch (citta){
		case "Verzuolo" :
			this.zona="NORD";
			break;
		case "Milano" :
			this.zona="NORD";
			break
		case "Torino" :
			this.zona="NORD";
			break;
		case "Firenze" :
			this.zona="CENTRO";
			break;
		case "Bologna" :
			this.zona="CENTRO";
			break;
		case "Roma" :
			this.zona="CENTRO";
			break;
		case "Napoli" :
			this.zona="SUD";
			break;
		case "Bari" :
			this.zona="SUD";
			break;
		case "Messina" :
			this.zona="SUD";
			break;	
		}
	}

class Vettura{
	constructor(targa,oraArrivo,oraScadenza){
		this.targa = targa;
		this.oraArrivo = oraArrivo;
		this.oraScadenza = oraScadenza;
	}
	
	getTarga(){
		return this.targa;
	}
	
	getOraArrivo(){
		return this.oraArrivo;
	}
	
	getOraScadenza(){
		return this.oraScadenza;
	}
	
	setOraScadenza(oraScadenza){
		this.oraScadenza = oraScadenza;
	}
}
module.exports={miaVettura:Vettura};

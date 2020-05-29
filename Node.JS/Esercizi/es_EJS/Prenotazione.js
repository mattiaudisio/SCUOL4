class Prenotazione{
	constructor(nomeEvento,numeroPersone){
		this.nomeEvento = nomeEvento;
		this.numeroPersone = numeroPersone;
	}	
	
	getNomeEvento(){
		return this.nomeEvento;
	}
	
	getNumeroPersone(){
		return this.NumeroPersone;
	}
	
	setNomeEvento(nomeEvento){
		this.nomeEvento = nomeEvento;		
	}
	
	setumeroPersone(umeroPersone){
		this.umeroPersone = umeroPersone;		
	}
}
module.exports={miaPrenotazione:Prenotazione};
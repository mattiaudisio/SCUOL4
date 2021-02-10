class Prodotto {
	
	constructor(a,b){
		if(!a.lenght){
			this.nomeProdotto = "\0";
			this.numeroProdotto = "\0";			
		}else{
			this.nomeProdotto = a;
			this.numeroProdotto = b;
		}
	}
	
	getNome(){
		return this.nomeProdotto;
	}
	
	getNumero(){
		return this.numeroProdotto;
	}
	
	setNumero(numero){
		this.numeroProdotto = numero;
	}
}
module.exports={prodottoComprato:Prodotto};
var prodotto = require('./prodotto.js').prodottoComprato;
var mieiProdotti = new Array();
class Prodotti{
	
	aggiungi(nome,numero){
		var controllo = true;
		for(var i = 0; i < mieiProdotti.length(); i++){
			if(mieiProdotti(i).getNome == nome){
				numero = mieiProdotti(i).getNumero + numero;
				mieiProdotti(i).setNumero(numero); 
			}else{
				controllo = false;
			}
		}
		if(controllo == false){
			var nuovoProdotto = new prodotto(nome,numero); 
			mieiProdotti.push(nuovoProdotto);
		}
	}
	
	get arrayProdotti(){
		return mieiProdotti;
	}
}module.exports = (prodottiComprati:Prodotti);
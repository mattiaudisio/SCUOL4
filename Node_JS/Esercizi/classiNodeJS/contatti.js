//CLASSI
class Contatto{
	//Bisogna creare un costruttore ed i metodi GET e SET
	constructor(nome,cognome,telefono,email){		//Queste sono delle variabili che sono presenti all'interno del coatruttore e vengono memorizzate all'interno dell'attributo
		this.nome=nome;		//Prende il nome che gli abbiamo passato e lo salva nell'attributo nome che è visibile all'interno della classe
		this.cognome=cognome;
		this.telefono=telefono;
		this.email=email;
	}
	
	concatena(){		//Metodo della classe
		return this.nome+" "+this.cognome+" "+this.telefono+" "+this.email+"\n";
	}

	set setIndirizzo(via){		//Metodo set 
		this.indirizzo=via;
	}

	concatena_2(){		
		return this.nome+" "+this.cognome+" "+this.telefono+" "+this.email+" "+this.indirizzo+"\n";
	}
	
	get getNome(){		//Metodo get
		return this.nome;
	}
}
//Un file può contenere più classi
//Bisogna esportare la classe perchè questo file può avere più classi
module.exports={mioContatto:Contatto};		//esporta la classi per creare gli oggetti


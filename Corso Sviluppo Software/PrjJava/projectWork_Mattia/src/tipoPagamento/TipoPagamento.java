package tipoPagamento;

public class TipoPagamento {

	public static final int BONIFICO = 1;
	public static final int CARTACREDITO = 2;
	
	public String getTipoPagamento(int index) {
		if(index == BONIFICO) return "Bonifico";
		else if (index == CARTACREDITO) return "Carta di credito";
		return "Tipo pagamento non previsto";
	}
}

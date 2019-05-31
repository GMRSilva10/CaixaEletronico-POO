package entity;

public class Pagamento extends Transacao{
	
	String boleto;
	
	public Pagamento(String boleto, double valor) {
		super(valor);
		this.boleto = boleto;
		
	}
	
}

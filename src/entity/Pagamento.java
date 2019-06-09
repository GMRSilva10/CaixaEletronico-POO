package entity;

public class Pagamento extends Transacao{
	
	private String boleto;
	
	public Pagamento(String boleto, double valor) {
		super(valor);
		this.boleto = boleto;
		
	}
	
}

package entity;

public class Transferencia extends Transacao{
	
	private Conta contaDestino;
	
	public Transferencia(Conta contaDestino, double valor) {
		super(valor);
		this.contaDestino = contaDestino;
	}
}

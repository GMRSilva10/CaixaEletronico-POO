package entity;

public class Transferencia extends Transacao{
	
	Conta contaDestino;
	
	public Transferencia(Conta contaDestino, double valor) {
		super(valor);
		this.contaDestino = contaDestino;
	}
}

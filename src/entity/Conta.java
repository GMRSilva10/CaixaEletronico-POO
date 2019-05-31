package entity;

import java.util.ArrayList;
import java.util.Date;

public class Conta {
	int numero;
	String senha;
	Cliente cliente;
	double saldo;
	Date dataAbertura;
	ArrayList<Transacao> historico = new ArrayList<Transacao>();

	public boolean efetuarSaque(double valor) {
		if (this.saldo >= valor) {
			this.saldo -= valor;
			historico.add(new Saque(valor));
			return true;
		} else {
			System.out.println("Saldo insuficiente");
			return false;
		}
	}

	public boolean efetuarDeposito(double valor) {
		if (valor > 0) {
			this.saldo += valor;
			historico.add(new Deposito(valor));
			return true;
		} else {
			return false;
		}
	}

	public boolean efetuarPagamento(String numeroBoleto, double valor) {
		if (this.saldo >= valor) {
			this.saldo -= valor;
			historico.add(new Pagamento(numeroBoleto, valor));
			return true;
		} else {
			return false;
		}
	}

	public boolean efetuarTransferencia(Conta contaDestino, double valor) {
		if (this.saldo >= valor) {
			this.saldo -= valor;
			contaDestino.saldo += valor;
			historico.add(new Transferencia(contaDestino, valor));
			return true;
		} else {
			return false;
		}
	}

	public ArrayList<Transacao> extrato(Date dataInicial, Date dataFinal) {
		return this.historico;
	}

}

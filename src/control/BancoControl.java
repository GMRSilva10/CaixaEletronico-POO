package control;

import java.util.ArrayList;
import entity.Cliente;
import entity.Conta;

public class BancoControl {

	public ArrayList<Conta> contas = new ArrayList<Conta>();
	public ArrayList<Cliente> clientes = new ArrayList<Cliente>();

	public void adicionarCliente(Cliente c) {
		clientes.add(c);
	}

	public Cliente pesquisar(String nome) {
		Cliente cliente = null;
		nome.toLowerCase();
		for (Cliente c : clientes) {
			if (c.getNome().toLowerCase().contains(nome)) {
				cliente = c;
			}
		}
		return cliente;
	}
}
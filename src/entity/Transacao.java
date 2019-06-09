package entity;

import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Transacao {
	private double valor;
	private Date data;
	
	public Transacao(double valor){
		this.valor = valor;
		this.data = new Date();
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		sdf.format(data);
	}
}

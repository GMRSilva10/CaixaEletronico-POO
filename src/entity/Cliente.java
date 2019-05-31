package entity;

import java.util.Date;

public class Cliente {
	private String nome;
	private String cpf;
	private String profissao;
	private Date dataNascimento; 
	private String estadoCivil;
	private String endereco;
	private String sexo;
	
	
	public Cliente(String nome, String cpf, String profissao, Date dataNascimento, String estadoCivil, String endereco, String sexo){
		this.nome=nome;
		this.estadoCivil=estadoCivil;
		this.profissao = profissao;
		this.dataNascimento = dataNascimento;
		this.estadoCivil = estadoCivil;
		this.endereco = endereco;
		this.sexo = sexo;
	}
}

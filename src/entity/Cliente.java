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
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getProfissao() {
		return profissao;
	}
	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public String getEstadoCivil() {
		return estadoCivil;
	}
	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
	public Cliente(){
		
	}
	
	public Cliente(String nome, String cpf, String profissao, Date dataNascimento, String estadoCivil, String endereco, String sexo){
		this.nome=nome;
		this.estadoCivil=estadoCivil;
		this.endereco = endereco;
		this.profissao = profissao;
		this.dataNascimento = dataNascimento;
		this.estadoCivil = estadoCivil;
		this.sexo = sexo;
	}
	
	
	
	
}

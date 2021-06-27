package br.edu.univas.model;

public class Detalhes {
	
	private int cpf;
	private String endereco;
	private String telefone;
	
	public Detalhes() {
		
	}
	
	public Detalhes(int cpf, String endereco, String telefone) {
		super();
		this.cpf = cpf;
		this.endereco = endereco;
		this.telefone = telefone;
	}

	public int getCpf() {
		return cpf;
	}

	public void setCpf(int cpf) {
		this.cpf = cpf;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	@Override
	public String toString() {
		return "Detalhes [CPF=" + cpf + ", endereco=" + endereco + ", telefone=" + telefone + "]";
	}

}

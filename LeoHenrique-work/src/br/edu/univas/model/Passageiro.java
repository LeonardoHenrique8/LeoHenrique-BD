package br.edu.univas.model;

public class Passageiro {
	
	private int rg;
	private String nome;
	private float peso;
	
	public Passageiro() {
		
	}
	public Passageiro(int rg, String nome, float peso) {
		super();
		this.rg = rg;
		this.nome = nome;
		this.peso = peso;
	}
	public int getRg() {
		return rg;
	}
	public void setRg(int rg) {
		this.rg = rg;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public float getPeso() {
		return peso;
	}
	public void setPeso(float peso) {
		this.peso = peso;
	}
	@Override
	public String toString() {
		return "Pasageiro [RG=" + rg + ", nome=" + nome + ", peso=" + peso + "]";
	}
	
	

}

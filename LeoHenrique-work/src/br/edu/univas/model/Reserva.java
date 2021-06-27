package br.edu.univas.model;
import java.util.Date;

public class Reserva {
	
	private int cod;
	private Date data;
	private String tipo;
	
	public Reserva() {
		
	}
	public Reserva(int cod, Date data, String tipo) {
		super();
		this.cod = cod;
		this.data = data;
		this.tipo = tipo;
	}
	public int getCod() {
		return cod;
	}
	public void setCod(int cod) {
		this.cod = cod;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	@Override
	public String toString() {
		return "Reserva [COD=" + cod + ", data=" + data + ", tipo=" + tipo + "]";
	}

}

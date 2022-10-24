package main;

public class Fatura {
	
	private Integer codigo;
	private double valor;
	private String data;
	
	public Fatura(Integer codigo, double valor, String data) {
		this.codigo = codigo;
		this.valor = valor;
		this.data = data;
	}
	
	public double getValor() {
		return this.valor;
	}
	
	public String getData() {
		return this.data;
	}
}

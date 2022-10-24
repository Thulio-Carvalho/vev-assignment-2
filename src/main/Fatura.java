package main;

import java.util.Date;

public class Fatura {
	
	private Integer codigo;
	private double valor;
	private Date data;
	
	public Fatura(Integer codigo, double valor, Date data) {
		this.codigo = codigo;
		this.valor = valor;
		this.data = data;
	}
	
	public double getValor() {
		return this.valor;
	}
	
	public Date getData() {
		return this.data;
	}
}

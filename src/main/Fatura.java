package main;

import java.util.Objects;

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
	
	@Override
	public int hashCode() {
		return Objects.hash(codigo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Fatura other = (Fatura) obj;
		return Objects.equals(codigo, other.codigo);
	}
	
}

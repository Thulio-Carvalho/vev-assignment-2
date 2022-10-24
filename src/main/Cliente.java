package main;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Cliente {
	
	private String nome;
	private Date inclusao;
	private String estado;
	private List<Fatura> faturas;
	
	public Cliente(String nome, Date inclusao, String estado) {
		this.nome = nome;
		this.inclusao = inclusao;
		this.estado = estado;
		this.faturas = new ArrayList<>();
	}
	
	public void adicionaFatura(Fatura fatura) {
		this.faturas.add(fatura);
	}
	
	public Date getDataInclusao() {
		return this.inclusao;
	}
	
	public List<Fatura> getFaturas() {
		return this.faturas;
	}
	
	public void filtraFaturas() {
		System.out.println("implementar...");
	}

}

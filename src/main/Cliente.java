package main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Cliente {
	
	private String nome;
	private String inclusao;
	private String estado;
	private List<Fatura> faturas;
	
	public Cliente(String nome, String inclusao, String estado) {
		this.nome = nome;
		this.inclusao = inclusao;
		this.estado = estado;
		this.faturas = new ArrayList<>();
	}
	
	public void adicionaFatura(Fatura fatura) {
		this.faturas.add(fatura);
	}
	
	public String getDataInclusao() {
		return this.inclusao;
	}
	
	public List<Fatura> getFaturas() {
		return this.faturas;
	}
	
	public void filtraFaturas() {
		LocalDate dataAtual = LocalDate.now();
		
		for (Fatura fatura : faturas) {
			LocalDate dataFatura = LocalDate.parse(fatura.getData());
			double valorFatura = fatura.getValor();
			
			if (valorFatura < 2000) {
				this.faturas.remove(fatura);
			}
			else if ((valorFatura >= 2000 && valorFatura < 2500) && diasFatura(dataAtual, dataFatura) <= 30) {
				this.faturas.remove(fatura);
			}
			else if ((valorFatura >= 2500 && valorFatura < 3000) && diasFatura(dataAtual, dataFatura) <= 60) {
				this.faturas.remove(fatura);
			}
			else if (valorFatura >= 4000 && ehDoSul()) {
				this.faturas.remove(fatura);
			}
		}
	}
	
	private boolean ehDoSul() {
		return estado.equals("PR") || estado.equals("RS") || estado.equals("SC");
	}

	private int diasFatura(LocalDate dataAtual, LocalDate dataFatura) {
		return dataAtual.getDayOfYear() - dataFatura.getDayOfYear();
	}
	
	

}

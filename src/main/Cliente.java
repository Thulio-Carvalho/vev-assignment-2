package main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Cliente {
	
	private String nome;
	private LocalDate inclusao;
	private String estado;
	private List<Fatura> faturas;
	
	public Cliente(String nome, String inclusao, String estado) {
		this.nome = nome;
		this.inclusao = LocalDate.parse(inclusao);
		this.estado = estado;
		this.faturas = new ArrayList<>();
	}
	
	public void adicionaFatura(Fatura fatura) {
		this.faturas.add(fatura);
	}
	
	public LocalDate getDataInclusao() {
		return this.inclusao;
	}
	
	public List<Fatura> getFaturas() {
		return this.faturas;
	}
	
	public void filtraFaturas() {
		LocalDate dataAtual = LocalDate.now();
		
		List<Fatura> faturasFiltradas = new ArrayList<>();
		
		for (Fatura fatura : faturas) {
			LocalDate dataFatura = LocalDate.parse(fatura.getData());
			double valorFatura = fatura.getValor();
			
			if (valorFatura < 2000) {
				faturasFiltradas.add(fatura);
			}
			else if ((valorFatura >= 2000 && valorFatura < 2500) && diasFatura(dataAtual, dataFatura) <= 30) {
				faturasFiltradas.add(fatura);
			}
			else if ((valorFatura >= 2500 && valorFatura <= 3000) && inclusaoCliente(dataAtual, this.inclusao) <= 60) {
				faturasFiltradas.add(fatura);
			}
			else if (valorFatura >= 4000 && ehDoSul()) {
				faturasFiltradas.add(fatura);
			}
		}
		removeFaturas(faturasFiltradas);
	
	}
	
	private void removeFaturas(List<Fatura> faturasFiltradas) {
		for (Fatura f : faturasFiltradas) {
			if (this.faturas.contains(f)) {
				this.faturas.remove(f);
			}
		}
	}

	private int diasFatura(LocalDate dataAtual, LocalDate dataFatura) {
		return dataAtual.getDayOfYear() - dataFatura.getDayOfYear();
	}
	
	private boolean ehDoSul() {
		return estado.equals("PR") || estado.equals("RS") || estado.equals("SC");
	}
	
	private int inclusaoCliente(LocalDate dataAtual, LocalDate dataInclusao) {
		return dataAtual.getDayOfYear() - dataInclusao.getDayOfYear();
	}
	
	

}

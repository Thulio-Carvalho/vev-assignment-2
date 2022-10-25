package main;

import java.time.LocalDate;

public class Util {
	
	public static int diasFatura(LocalDate dataAtual, LocalDate dataFatura) {
		return dataAtual.getDayOfYear() - dataFatura.getDayOfYear();
	}
	
	public static boolean ehDoSul(Estados estado) {
		return (estado == Estados.PR || estado == Estados.RS || estado == Estados.SC);
	}
	
	public static int inclusaoCliente(LocalDate dataAtual, LocalDate dataInclusao) {
		return dataAtual.getDayOfYear() - dataInclusao.getDayOfYear();
	}

}

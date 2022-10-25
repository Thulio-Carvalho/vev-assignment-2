package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.Cliente;
import main.Estados;
import main.Fatura;

class ClienteTest {
	
	private Cliente cliente;
	
	@BeforeEach
	public void init() {
		this.cliente = new Cliente("Augusto", "2022-08-24", Estados.PB);
	}

	@Test
	void testClienteSemFaturas() {
		assertEquals(this.cliente.getFaturas().size(), 0);
	}
	
	@Test
	void testClienteAddFatura() {
		Cliente cliente = new Cliente("Augusto", "2022-08-24", Estados.PB);
		Fatura fatura = new Fatura(1, 350, "2022-08-24");
		cliente.adicionaFatura(fatura);
		assertEquals(cliente.getFaturas().size(), 1);
	}
	
	@Test
	void testFiltraFaturasMenoresQue2000() {
		Cliente cliente = new Cliente("Augusto", "2022-08-24", Estados.PB);
		
		Fatura fatura1 = new Fatura(1, 1999.99, "2022-08-24");
		Fatura fatura2 = new Fatura(2, 2000, "2022-08-24");
		Fatura fatura3 = new Fatura(3, 2100, "2022-08-24");
		
		cliente.adicionaFatura(fatura1);
		cliente.adicionaFatura(fatura2);
		cliente.adicionaFatura(fatura3);
		
		cliente.filtraFaturas();
		assertEquals(cliente.getFaturas().size(), 2);
	}

	@Test
	void testFiltraFaturasEntre2000E2500() {
		Cliente cliente = new Cliente("Augusto", "2022-10-24", Estados.PB);
		
		Fatura fatura1 = new Fatura(1, 2000, "2022-08-10");
		Fatura fatura2 = new Fatura(2, 2500, "2022-10-20");
		
		cliente.adicionaFatura(fatura1);
		cliente.adicionaFatura(fatura2);
		
		cliente.filtraFaturas();
		assertEquals(cliente.getFaturas().size(), 1);
	}


	@Test
	void testFiltraFaturasEntre2500E3000() {
		Cliente cliente1 = new Cliente("Augusto", "2022-07-25", Estados.PB);
		Cliente cliente2 = new Cliente("Gomes", "2022-10-24", Estados.PB);
		
		Fatura fatura1 = new Fatura(1, 2500, "2022-10-24");
		Fatura fatura2 = new Fatura(2, 3000, "2022-10-20");
		
		cliente1.adicionaFatura(fatura1);
		cliente1.adicionaFatura(fatura2);
		
		cliente2.adicionaFatura(fatura1);
		cliente2.adicionaFatura(fatura2);
		
		cliente1.filtraFaturas();
		cliente2.filtraFaturas();
		
		assertEquals(cliente1.getFaturas().size(), 2);
		assertEquals(cliente2.getFaturas().size(), 0);
	}
	
	@Test
	void testFiltraFaturasMaioresQue4000ClienteSul() {
		Cliente cliente = new Cliente("Santos", "2022-10-24", Estados.RS);
		
		Fatura fatura1 = new Fatura(1, 4000, "2022-08-24");
		Fatura fatura2 = new Fatura(2, 4200, "2022-10-20");
		
		cliente.adicionaFatura(fatura1);
		cliente.adicionaFatura(fatura2);
		
		cliente.filtraFaturas();
		assertEquals(cliente.getFaturas().size(), 1);
	}
	
}


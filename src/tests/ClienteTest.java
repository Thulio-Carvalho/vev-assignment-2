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
		Cliente c = new Cliente("Augusto", "2022-08-24", Estados.PB);
		Fatura fatura = new Fatura(1, 350, "2022-08-24");
		c.adicionaFatura(fatura);
		assertEquals(c.getFaturas().size(), 1);
	}
	
	@Test
	void testFiltraFaturasMenoresQue2000() {
		Cliente c = new Cliente("Augusto", "2022-08-24", Estados.PB);
		
		Fatura fatura1 = new Fatura(1, 1999.99, "2022-08-24");
		Fatura fatura2 = new Fatura(2, 2000, "2022-08-24");
		Fatura fatura3 = new Fatura(3, 2100, "2022-08-24");
		
		c.adicionaFatura(fatura1);
		c.adicionaFatura(fatura2);
		c.adicionaFatura(fatura3);
		
		c.filtraFaturas();
		assertEquals(c.getFaturas().size(), 2);
	}

	@Test
	void testFiltraFaturasEntre2000E2500() {
		Cliente c = new Cliente("Augusto", "2022-10-24", Estados.PB);
		
		Fatura fatura1 = new Fatura(1, 2000, "2022-08-10");
		Fatura fatura2 = new Fatura(2, 2500, "2022-10-20");
		
		c.adicionaFatura(fatura1);
		c.adicionaFatura(fatura2);
		
		c.filtraFaturas();
		assertEquals(c.getFaturas().size(), 1);
	}


	@Test
	void testFiltraFaturasEntre2500E3000() {
		Cliente c1 = new Cliente("Augusto", "2022-07-25", Estados.PB);
		Cliente c2 = new Cliente("Gomes", "2022-10-24", Estados.PB);
		
		Fatura fatura1 = new Fatura(1, 2500, "2022-10-24");
		Fatura fatura2 = new Fatura(2, 3000, "2022-10-20");
		
		c1.adicionaFatura(fatura1);
		c1.adicionaFatura(fatura2);
		
		c2.adicionaFatura(fatura1);
		c2.adicionaFatura(fatura2);
		
		c1.filtraFaturas();
		c2.filtraFaturas();
		
		assertEquals(c1.getFaturas().size(), 2);
		assertEquals(c2.getFaturas().size(), 0);
	}
	
	@Test
	void testFiltraFaturasMaiorQue4000ClienteSul() {
		Cliente c1 = new Cliente("Santos", "2022-10-24", Estados.RS);
		
		Fatura fatura1 = new Fatura(1, 4000, "2022-08-24");
		Fatura fatura2 = new Fatura(2, 4200, "2022-10-20");
		
		c1.adicionaFatura(fatura1);
		c1.adicionaFatura(fatura2);
		
		c1.filtraFaturas();
		assertEquals(this.cliente.getFaturas().size(), 0);
	}
	
}


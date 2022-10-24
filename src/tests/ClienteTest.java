package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.Cliente;
import main.Fatura;

class ClienteTest {
	
	private Cliente cliente;
	
	@BeforeEach
	public void init() {
		this.cliente = new Cliente("Augusto", "2022-08-24", "PB");
	}

	@Test
	void testClienteSemFaturas() {
		assertEquals(this.cliente.getFaturas().length(), 0);
	}
	
	@Test
	void testClienteAddFatura() {
		Fatura fatura = new Fatura(1, 350, "2022-08-24");
		this.cliente.adicionaFatura(fatura);
		assertEquals(this.cliente.getFaturas().length(), 1);
	}
	
	@Test
	void testFiltraFaturasMenoresQue2000() {
		Fatura fatura1 = new Fatura(1, 1999,99, "2022-08-24");
		Fatura fatura2 = new Fatura(2, 2000, "2022-08-24");
		Fatura fatura3 = new Fatura(3, 2100, "2022-08-24");
		
		this.cliente.adicionaFatura(fatura1);
		this.cliente.adicionaFatura(fatura2);
		this.cliente.adicionaFatura(fatura3);
		
		this.cliente.filtraFaturas();
		assertEquals(this.cliente.getFaturas().length(), 2);
	}

/*	
	@Test
	void testFiltraFaturasMenoresQue2000() {
		Fatura fatura1 = new Fatura(1, 2000, "2022-08-24");
		Fatura fatura2 = new Fatura(2, 2500, "2022-10-20");
		
		this.cliente.adicionaFatura(fatura1);
		this.cliente.adicionaFatura(fatura2);
		
		this.cliente.filtraFaturas();
		assertEquals(this.cliente.getFaturas().length(), 2);
	}
*/
	
	@Test
	void testFiltraFaturasEntre2000E2500() {
		Fatura fatura1 = new Fatura(1, 2000, "2022-08-24");
		Fatura fatura2 = new Fatura(2, 2500, "2022-10-20");
		
		this.cliente.adicionaFatura(fatura1);
		this.cliente.adicionaFatura(fatura2);
		
		this.cliente.filtraFaturas();
		assertEquals(this.cliente.getFaturas().length(), 1);
	}
	
	@Test
	void testFiltraFaturasEntre2500E3000() {
		Cliente c1 = new Cliente("Augusto", "2022-07-25", "PB");
		Cliente c2 = new Cliente("Gomes", "2022-10-24", "PB");
		
		Fatura fatura1 = new Fatura(1, 2500, "2022-07-24");
		Fatura fatura2 = new Fatura(2, 3000, "2022-10-20");
		
		c1.adicionaFatura(fatura1);
		c1.adicionaFatura(fatura2);
		
		c2.adicionaFatura(fatura1);
		c2.adicionaFatura(fatura2);
		
		c1.filtraFaturas();
		c2.filtraFaturas();
		
		assertEquals(c1.getFaturas().length(), 2);
		assertEquals(c1.getFaturas().length(), 0);
	}
	
	@Test
	void testFiltraFaturasMaiorQue4000ClienteSul() {
		Cliente c1 = new Cliente("Santos", "2022-10-24", "RS");
		
		Fatura fatura1 = new Fatura(1, 4000, "2022-08-24");
		Fatura fatura2 = new Fatura(2, 4200, "2022-10-20");
		
		c1.adicionaFatura(fatura1);
		c1.adicionaFatura(fatura2);
		
		c1.filtraFaturas();
		assertEquals(this.cliente.getFaturas().length(), 0);
	}	

}

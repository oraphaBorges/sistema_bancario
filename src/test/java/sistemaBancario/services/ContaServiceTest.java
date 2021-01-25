package sistemaBancario.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import sistemaBancario.Services.ContaService;
import sistemaBancario.models.Usuario;
import sistemaBancario.repository.UsuarioRepository;

public class ContaServiceTest {
		
	@Test
	public void pagamentoValidoTest() {
		UsuarioRepository urep = new UsuarioRepository();
		Usuario usuario = urep.findById(1);
		
		ContaService csvc = new ContaService();
		Double saldo = csvc.consultarSaldo(usuario.getContas().get(0));
		Double esperado = saldo - 150;
		
		csvc.pagar(usuario.getContas().get(0),150);
		
		Double recebido = csvc.consultarSaldo(usuario.getContas().get(0));
		
		assertEquals(recebido, esperado);
	}
	
	@Test
	public void pagamentoInvalidoTest() {
		UsuarioRepository urep = new UsuarioRepository();
		Usuario usuario = urep.findById(1);
		
		ContaService csvc = new ContaService();
		Double saldo = csvc.consultarSaldo(usuario.getContas().get(0));
		assertThrows(ArithmeticException.class, () -> csvc.pagar(usuario.getContas().get(0),saldo+150));
	}
	
	@Test
	public void depositoTest() {
		UsuarioRepository urep = new UsuarioRepository();
		Usuario usuario = urep.findById(1);
		
		ContaService csvc = new ContaService();
		Double saldo = csvc.consultarSaldo(usuario.getContas().get(0));
		Double esperado = saldo + 100;
		
		csvc.depositar(usuario.getContas().get(0),100);
		
		Double recebido = csvc.consultarSaldo(usuario.getContas().get(0));
		
		assertEquals(recebido, esperado);
	}
}

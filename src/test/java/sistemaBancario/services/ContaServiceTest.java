package sistemaBancario.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import sistemaBancario.Services.ContaService;
import sistemaBancario.Services.UsuarioService;
import sistemaBancario.enums.Sigla;
import sistemaBancario.models.Conta;
import sistemaBancario.models.Usuario;

public class ContaServiceTest {
	private static UsuarioService usuarioService = new UsuarioService();
	private static ContaService contaService = new ContaService();

	@BeforeAll
	public static void setup() {

		try {
			Usuario usuario = new Usuario("Yukihira Souma", "souma.yukihira", "123456", "11111111111");
			usuarioService.cadastrar(usuario);
			Conta conta = new Conta("TEST", Sigla.CREDITO, usuario);
			contaService.cadastrar(usuario, conta);
			contaService.depositar(conta, 1500.0, "Abrindo a Conta");
		} catch (IllegalStateException e) {
		}
		try {
			Usuario usuario = new Usuario("Jisoo Black", "jisoo.black", "123456", "11111111111");
			usuarioService.cadastrar(usuario);
			Conta conta = new Conta("Reserva", Sigla.POPANCA, usuario);
			contaService.cadastrar(usuario, conta);
			contaService.depositar(conta, 1500.50, "Abrindo a Conta");
			conta = new Conta("Reserva", Sigla.CORRENTE, usuario);
			contaService.cadastrar(usuario, conta);
			contaService.depositar(conta, 3500.03, "Abrindo a Conta");
		} catch (IllegalStateException e) {
		}
	}

	@Test
	public void pagamentoValidoTest() {
		Usuario usuario = usuarioService.buscarUsuario("jisoo.black");
		assertNotNull(usuario);

		System.out.println(usuario.getContas().size());
		Double saldo = contaService.consultarSaldo(usuario.getContas().get(0));
		Double esperado = saldo - 150;

		contaService.pagar(usuario.getContas().get(0), 150, null, null);

		Double recebido = contaService.consultarSaldo(usuario.getContas().get(0));

		assertEquals(recebido, esperado);
	}

	@Test
	public void pagamentoInvalidoTest() {
		Usuario usuario = usuarioService.buscarUsuario("jisoo.black");
		assertNotNull(usuario);

		Double saldo = contaService.consultarSaldo(usuario.getContas().get(0));
		assertThrows(ArithmeticException.class,
				() -> contaService.pagar(usuario.getContas().get(0), saldo + 150, null, null));
	}

	@Test
	public void depositoTest() {
		Usuario usuario = usuarioService.buscarUsuario("jisoo.black");
		assertNotNull(usuario);

		Double saldo = contaService.consultarSaldo(usuario.getContas().get(0));
		Double esperado = saldo + 100;

		contaService.depositar(usuario.getContas().get(0), 100, null);

		Double recebido = contaService.consultarSaldo(usuario.getContas().get(0));

		assertEquals(recebido, esperado);
	}

	@Test
	public void transferenciaTest() {
		Usuario origem = usuarioService.buscarUsuario("jisoo.black");
		assertNotNull(origem);

		Usuario destino = usuarioService.buscarUsuario("souma.yukihira");
		assertNotNull(destino);

		double saldoAnteriorOrigem = origem.getContas().get(0).getSaldo();
		double saldoAnteriorDestino = destino.getContas().get(0).getSaldo();

		contaService.transferir(origem.getContas().get(0), 100.0, destino.getContas().get(0), null, null);

		origem = usuarioService.buscarUsuario("jisoo.black");
		assertNotNull(origem);
		destino = usuarioService.buscarUsuario("souma.yukihira");
		assertNotNull(destino);

		double novoSaldoOrigem = origem.getContas().get(0).getSaldo();
		double novoSaldoDestino = destino.getContas().get(0).getSaldo();

		assertEquals(novoSaldoOrigem, saldoAnteriorOrigem - 100.0);
		assertEquals(novoSaldoDestino, saldoAnteriorDestino + 100.0);

	}

	@Test
	public void transferenciaInvalidaTest() {
		Usuario origem = usuarioService.buscarUsuario("jisoo.black");
		assertNotNull(origem);

		Usuario destino = usuarioService.buscarUsuario("souma.yukihira");
		assertNotNull(destino);

		double saldoAnteriorOrigem = origem.getContas().get(0).getSaldo();

		assertThrows(ArithmeticException.class, () -> contaService.transferir(origem.getContas().get(0),
				saldoAnteriorOrigem + 100.0, destino.getContas().get(0), null, null));
	}

}

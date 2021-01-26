import sistemaBancario.Services.ContaService;
import sistemaBancario.Services.LancamentoService;
import sistemaBancario.models.Conta;
import sistemaBancario.models.Sigla;
import sistemaBancario.models.Usuario;
import sistemaBancario.repository.ContaRepository;
import sistemaBancario.repository.LancamentoRepository;
import sistemaBancario.repository.UsuarioRepository;

public class App {
	private static ContaRepository crep = new ContaRepository();
	private static UsuarioRepository urep = new UsuarioRepository();
	

	public static void main(String[] args) {
		// CONTA CREATE
//		Conta conta = new Conta();
//		conta.setNome("ForgenKey");
//		conta.setSaldo(1253.66);
//		conta.setSigla(Sigla.CORRENTE);
//		
//		Conta conta2 = new Conta();
//		conta.setNome("Conta2");
//		conta.setSaldo(10.00);
//		conta.setSigla(Sigla.CORRENTE);
//
//		crep.create(conta);
//		crep.create(conta2);

		// USUARIO CREATE
//		Usuario user = new Usuario();
//		user.setLogin("Tranferencia Origem");
//		user.setCpf("11111111111");
//		user.setNome("Origem");
//		user.setSenha("1234");
//		user.addConta(conta);
//		urep.create(user);
//		
//		Usuario user2 = new Usuario();
//		user.setLogin("Tranferencia Recebdora");
//		user.setCpf("11111111111");
//		user.setNome("recebedor");
//		user.setSenha("1234");
//		user.addConta(conta);
//		urep.create(user2);

		// CONTA ASSOSIATION
//		conta.setUsuario(user);
//		crep.update(conta);
//		
//		conta.setUsuario(user2);
//		crep.update(conta2);
		
		//LANCAMENTO TRANSFERENCIA && LANCAMENTO PAGAMENTO
		LancamentoService lser = new LancamentoService();
		lser.transferencia("teste transferencia", 2, 1, 500.00, "testando aplicação");
		
		lser.pagamento(5000.00, 2, "superMercado", "contas mensais");
		
//		user = urep.findById(1);
//		ContaService csvc = new ContaService();
//		System.out.println(user.getContas().get(0).getSaldo());
//		csvc.depositar(user.getContas().get(0), 150);
//		System.out.println(user.getContas().get(0).getSaldo());
//		csvc.pagar(user.getContas().get(0), 500);
//		System.out.println(user.getContas().get(0).getSaldo());

	}
}

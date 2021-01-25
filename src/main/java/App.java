import sistemaBancario.Services.ContaService;
import sistemaBancario.models.Conta;
import sistemaBancario.models.Sigla;
import sistemaBancario.models.Usuario;
import sistemaBancario.repository.ContaRepository;
import sistemaBancario.repository.UsuarioRepository;

public class App {
	private static ContaRepository crep = new ContaRepository();
	private static UsuarioRepository urep = new UsuarioRepository();

	public static void main(String[] args) {
		// CONTA CREATE
		Conta conta = new Conta();
		conta.setNome("ForgenKey");
		conta.setSaldo(1253.66);
		conta.setSigla(Sigla.CORRENTE);

		crep.create(conta);

		// USUARIO CREATE
		Usuario user = new Usuario();
		user.setLogin("login");
		user.setCpf("11111111111");
		user.setNome("testeForeng Key");
		user.setSenha("1234");
		user.addConta(conta);
		urep.create(user);

		// CONTA ASSOSIATION
		conta.setUsuario(user);
		crep.update(conta);

		
		user = urep.findById(1);
		ContaService csvc = new ContaService();
		System.out.println(user.getContas().get(0).getSaldo());
		csvc.depositar(user.getContas().get(0), 150);
		System.out.println(user.getContas().get(0).getSaldo());
		csvc.pagar(user.getContas().get(0), 250);
		System.out.println(user.getContas().get(0).getSaldo());

	}
}

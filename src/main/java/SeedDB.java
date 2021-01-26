import sistemaBancario.Services.ContaService;
import sistemaBancario.Services.PlanoContaService;
import sistemaBancario.Services.UsuarioService;
import sistemaBancario.enums.Sigla;
import sistemaBancario.models.Conta;
import sistemaBancario.models.Usuario;

public class SeedDB {

	private static UsuarioService usuarioService = new UsuarioService();
	private static ContaService contaService = new ContaService();
	private static PlanoContaService planoContaService = new PlanoContaService();
	
	public static void main(String[] args) {
		Usuario usuario = new Usuario("José Sonza","jose.sonza","123456","11111111111");
		usuarioService.cadastrar(usuario);
		Conta conta = new Conta("Reserva",Sigla.CREDITO,usuario);
		contaService.cadastrar(usuario,conta);
		contaService.depositar(conta, 1500.0, "Abrindo a Conta");
		
		usuario = new Usuario("Ana schawiski","ana.schawiski","123456","11111111111");
		usuarioService.cadastrar(usuario);
		conta = new Conta("Reserva",Sigla.POPANCA,usuario);
		contaService.cadastrar(usuario,conta);
		contaService.depositar(conta, 1500.50, "Abrindo a Conta");
		conta = new Conta("Reserva",Sigla.CORRENTE,usuario);
		contaService.cadastrar(usuario,conta);
		contaService.depositar(conta, 3500.03, "Abrindo a Conta");
		
		usuario = new Usuario("Kenji Kahara","kenji.kahara","123456","11111111111");
		usuarioService.cadastrar(usuario);
		conta = new Conta("Reserva",Sigla.CREDITO,usuario);
		contaService.cadastrar(usuario,conta);
		contaService.depositar(conta, 800.0, "Abrindo a Conta");
		conta = new Conta("Reserva",Sigla.CORRENTE,usuario);
		contaService.cadastrar(usuario,conta);
		contaService.depositar(conta, 504.31, "Abrindo a Conta");

		planoContaService.cadastrar("Alimentação");
		planoContaService.cadastrar("Jogos");
		planoContaService.cadastrar("Energia Elétrica");
		planoContaService.cadastrar("Água");
		planoContaService.cadastrar("Outros");
	}

}

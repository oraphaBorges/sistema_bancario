import java.time.LocalDate;
import java.util.ArrayList;

import sistemaBancario.Services.ContaService;
import sistemaBancario.Services.UsuarioService;
import sistemaBancario.models.Conta;
import sistemaBancario.models.Lancamento;
import sistemaBancario.models.Usuario;

public class App {
	
	private static ContaService contaService = new ContaService();
	private static UsuarioService usuarioService = new UsuarioService();
	
	public static void main(String[] args) {
		ArrayList<Lancamento> extrato1 = new ArrayList<Lancamento>();
		ArrayList<Lancamento> extrato2 = new ArrayList<Lancamento>();
		
		LocalDate inicio = LocalDate.of(2000,3,7);
		LocalDate fim = LocalDate.of(2019,1,7);
		
		Usuario usuario = usuarioService.buscarUsuario("jisoo.black");
		
		Conta conta = usuario.getContas().get(0);
		
		extrato1 = contaService.consultarExtrato(conta);
		extrato2 = contaService.consultarExtrato(conta,inicio,fim);
		
		System.out.println("Exrato Geral");
		for(Lancamento e: extrato1) {
			System.out.println(e.getContaOrigem().getId()+ "\t" + e.getId() + "\t" + e.getValor() + "\t" + e.getDataLancamento().toString() );
		}
		
		System.out.println("\nExtrado de " + inicio.toString() + " à "+ fim.toString());
		for(Lancamento e: extrato2) {
			System.out.println(e.getContaOrigem().getId()+ "\t" +e.getId() + "\t" + e.getValor() + "\t" + e.getDataLancamento().toString() );
		}

	}
}

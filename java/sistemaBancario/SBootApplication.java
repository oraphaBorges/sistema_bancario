package sistemaBancario;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import sistemaBancario.dto.LancamentoDTO;
import sistemaBancario.enums.Sigla;
import sistemaBancario.models.Conta;
import sistemaBancario.models.PlanoConta;
import sistemaBancario.models.Usuario;
import sistemaBancario.services.ContaService;
import sistemaBancario.services.UsuarioService;

@SpringBootApplication
public class SBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(SBootApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner run(UsuarioService us, ContaService cs) throws Exception {
		return args -> {
			Usuario u;
			u = new Usuario("Jisoo Black", "jisoo.black", "123456", "11111111111");
			us.cadastrar(u);
			u = new Usuario("admin","admin","admin","11111111111");
			us.cadastrar(u);
			
			u = us.buscar("jisoo.black");
			Conta c = cs.buscar(u,Sigla.CREDITO);
			
			LancamentoDTO lancamento;
			lancamento = new LancamentoDTO(c.getId(),100.0,1,0,"DEPOSITO");
			cs.depositar(lancamento);
			lancamento = new LancamentoDTO(c.getId(),150.0,1,0,"DEPOSITO");
			cs.depositar(lancamento);
			lancamento = new LancamentoDTO(c.getId(),100.0,1,0,"PAGAMENTO");
			cs.pagar(lancamento);
		};
	}

}

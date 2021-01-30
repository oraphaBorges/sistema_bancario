package sistemaBancario;
import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import sistemaBancario.dto.LancamentoDTO;
import sistemaBancario.enums.Sigla;
import sistemaBancario.models.Conta;
import sistemaBancario.models.Usuario;
import sistemaBancario.repository.LancamentoRepository;
import sistemaBancario.services.ContaService;
import sistemaBancario.services.PlanoContaService;
import sistemaBancario.services.UsuarioService;

@SpringBootApplication
public class SBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(SBootApplication.class, args);
	}
	
	static void setB(byte b) {
		
	}
	@Bean
	public CommandLineRunner run(UsuarioService us, ContaService cs,
								 PlanoContaService ps
			) throws Exception {
		return args -> {
			Usuario u;
			u = new Usuario("Jisoo Black", "jisoo.black", "123456", "11111111111");
			us.cadastrar(u);
			u = new Usuario("admin","admin","admin","11111111111");
			us.cadastrar(u);
			
			u = us.buscar("jisoo.black");
			System.out.println(u.getLogin());
						
			
		};
	}

}

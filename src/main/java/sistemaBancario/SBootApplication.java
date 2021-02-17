package sistemaBancario;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import sistemaBancario.dto.ContaSimplesDTO;
import sistemaBancario.dto.LancamentoDTO;
import sistemaBancario.dto.UsuarioDTO;
import sistemaBancario.enums.Sigla;
import sistemaBancario.services.ContaService;
import sistemaBancario.services.UsuarioService;

@SpringBootApplication
public class SBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(SBootApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("*");
			}
		};
	}
	@Bean
	public CommandLineRunner run(UsuarioService us, ContaService cs) throws Exception {
		return args -> {

			UsuarioDTO u, u2;
			try {
				u = new UsuarioDTO("30987646001", "jisoo", "Kim Ji-soo", "pretorosa");
				us.cadastrar(u);
				u = new UsuarioDTO("30987646001", "rose", "Park (Rosé) Chae Young ", "pretorosa");
				us.cadastrar(u);
				u = new UsuarioDTO("30987646001", "lisa", "Lalisa Manoban", "pretorosa");
				us.cadastrar(u);
				u = new UsuarioDTO("30987646001", "Jennie", "Kim Jennie", "pretorosa");
				us.cadastrar(u);
				u = new UsuarioDTO("33333333333", "admin", "admin", "1234567");
				us.cadastrar(u);
			} catch (Exception e) {

			}

			u = us.buscar("jisoo");
			System.out.println(u.getLogin());
			u2 = us.buscar("admin");
			System.out.println(u2.getLogin());

			ContaSimplesDTO origem = new ContaSimplesDTO(u.getLogin(), Sigla.POUPANCA);
			ContaSimplesDTO destino = new ContaSimplesDTO(u2.getLogin(), Sigla.POUPANCA);

			System.out.println(origem.login + " " + destino.login);

//			cs.depositar(new LancamentoDTO(origem, 100, origem, "PAGAMENTO", "Gardar DIMDIM"));
//			cs.pagar(new LancamentoDTO(origem, 30, origem, "PAGAMENTO", "Pagar Boleto"));
//			cs.transferir(new LancamentoDTO(origem, 40, destino, "TRANSFERENCIA", "Pagar Agiota"));

		};
	}

}
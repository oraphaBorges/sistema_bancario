package sistemaBancario;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(SBootApplication.class, args);
	}
	
//	@Bean
//	public CommandLineRunner run(UsuarioService s) throws Exception {
//		return args -> {
//			Usuario u = new Usuario();
//			u.setCpf("11111111111");
//			u.setNome("admin");
//			u.setLogin("admin");
//			u.setSenha("admin");
//			s.cadastrar(u);
//		};
//	}

}

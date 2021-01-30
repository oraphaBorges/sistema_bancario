package sistemaBancario;
import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import sistemaBancario.repository.LancamentoRepository;

@SpringBootApplication
public class SBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(SBootApplication.class, args);
	}
	
	static void setB(byte b) {
		
	}
	@Bean
	public CommandLineRunner run(LancamentoRepository lr) throws Exception {
		return args -> {
//			Usuario u = new Usuario();
//			u.setCpf("11111111111");
//			u.setNome("admin");
//			u.setLogin("admin");
//			u.setSenha("admin");
//			s.cadastrar(u);
			
			LocalDate date = LocalDate.of(2020, 1, 20);
			LocalDate date2 = LocalDate.of(2022, 1, 20);
////			
			
			try {
				
				System.out.println(lr.findAllByDataLancamentoBetween(2L, date, date2));
				System.out.println(lr.findAllByContaOrigem_id(2L));
			} catch (Exception e) {
				System.out.println(e);
			}
			
		};
	}

}

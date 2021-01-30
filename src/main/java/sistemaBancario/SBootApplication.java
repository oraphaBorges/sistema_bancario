package sistemaBancario;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import sistemaBancario.dto.LancamentoDTO;
import sistemaBancario.enums.Sigla;
import sistemaBancario.models.Usuario;
import sistemaBancario.models.Conta;
import sistemaBancario.services.ContaService;
import sistemaBancario.services.UsuarioService;

@SpringBootApplication
public class SBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(SBootApplication.class, args);
	}
	
	static void setB(byte b) {
		
	}
	@Bean
	public CommandLineRunner run(UsuarioService us, ContaService cs
			) throws Exception {
		return args -> {
			Usuario u,u2;
			u = new Usuario("Jisoo Black", "jisoo.black", "123456", "11111111111");
			us.cadastrar(u);
			u = new Usuario("admin","admin","admin","11111111111");
			us.cadastrar(u);
			
			u = us.buscar("jisoo.black");
			System.out.println(u.getLogin());
			u2 = us.buscar("admin");
			System.out.println(u2.getLogin());
			
			Conta c1,c2;
			c1 = cs.buscar(u,Sigla.POUPANCA);
			c2 = cs.buscar(u2,Sigla.POUPANCA);
			
			Long origem = c1.getId();
			Long destino = c2.getId();
			
			System.out.println(origem + " " + destino);
			
			cs.depositar(new LancamentoDTO(origem,100,origem,2L,"DEPOSITO"));
			cs.pagar(new LancamentoDTO(origem,30,origem,1L,"PAGAMENTO"));
			cs.transferir(new LancamentoDTO(origem,40,destino,3L,"TRANSFERENCIA"));
						
			
		};
	}

}

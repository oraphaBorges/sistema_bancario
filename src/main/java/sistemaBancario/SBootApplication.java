package sistemaBancario;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

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
	
	static void setB(byte b) {
		
	}
	@Bean
	public CommandLineRunner run(UsuarioService us, ContaService cs
			) throws Exception {
		return args -> {
		
			UsuarioDTO u,u2;
			u = new UsuarioDTO("22222222222", "DTO.black", "DTO.nome", "123456");
			us.cadastrar(u);
			u = new UsuarioDTO("33333333333","admin","admin","1234567");
			us.cadastrar(u);
			
			u = us.buscar("DTO.black");
			System.out.println(u.getLogin());
			u2 = us.buscar("admin");
			System.out.println(u2.getLogin());
			
		
			ContaSimplesDTO origem = new ContaSimplesDTO(u.getLogin(),Sigla.POUPANCA);
			ContaSimplesDTO destino = new ContaSimplesDTO(u2.getLogin(),Sigla.POUPANCA);
			
			System.out.println(origem + " " + destino);
		
			cs.depositar(new LancamentoDTO(origem,100,origem,"PAGAMENTO","Gardar DIMDIM"));
			cs.pagar(new LancamentoDTO(origem,30,origem,"PAGAMENTO","Pagar Boleto"));
			cs.transferir(new LancamentoDTO(origem,40,destino,"TRANSFERENCIA","Pagar Agiota"));						
			
		};
	}

}

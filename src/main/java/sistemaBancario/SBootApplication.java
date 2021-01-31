package sistemaBancario;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import sistemaBancario.dto.ContaDTO;
import sistemaBancario.dto.LancamentoDTO;
import sistemaBancario.dto.UsuarioDTO;
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
		
			UsuarioDTO u,u2;
			u = new UsuarioDTO("22222222222", "DTO.black", "DTO.nome", "123456");
			us.cadastrar(u);
			u = new UsuarioDTO("33333333333","admin","admin","1234567");
			us.cadastrar(u);
			
			u = us.buscar("DTO.black");
			System.out.println(u.getLogin());
			u2 = us.buscar("admin");
			System.out.println(u2.getLogin());
			
			ContaDTO c1,c2;
			c1 = cs.buscarPorLoginESigla(u.getLogin(),Sigla.POUPANCA);
			c2 = cs.buscarPorLoginESigla(u2.getLogin(),Sigla.POUPANCA);
			
			Long origem = c1.getId();
			Long destino = c2.getId();
			
			System.out.println(origem + " " + destino);
		
			cs.depositar(new LancamentoDTO(origem,100,origem,2L,"DEPOSITO"));
			cs.pagar(new LancamentoDTO(origem,30,origem,1L,"PAGAMENTO"));
			cs.transferir(new LancamentoDTO(origem,40,destino,3L,"TRANSFERENCIA"));						
			
		};
	}

}

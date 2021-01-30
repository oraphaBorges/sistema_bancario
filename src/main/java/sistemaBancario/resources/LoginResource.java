package sistemaBancario.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import sistemaBancario.dto.LoginDTO;
import sistemaBancario.dto.SessaoDTO;
import sistemaBancario.services.LoginService;

@RestController
@RequestMapping("/")
public class LoginResource {
	@Autowired
	private LoginService service;

    @GetMapping("/hello")
    public String helloWorld(){
        return "Hello World";
    }
    
	@PostMapping("/login")
	public SessaoDTO logar (@RequestBody LoginDTO loginDTO) throws Exception {
		return service.logar(loginDTO);
	}
	
	@PutMapping("/altera-senha/{senhaTemporaria}")
	public String alteraSenha(@RequestParam String senhaTemporaria) {
		return "senha alterada";
	}
	
	@PostMapping("/nova-senha")
	public String novaSenha(@RequestParam String novasenha) {
		return "nova senha";
	}
	
	
	
}
package sistemaBancario.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import sistemaBancario.dto.LoginDTO;
import sistemaBancario.services.LoginService;

@RestController
@RequestMapping("/")
public class LoginResource {
	@Autowired
	private LoginService service;

   
	@PostMapping("/login")
	public ResponseEntity<?> logar (@RequestBody LoginDTO loginDTO) throws Exception {
		try {
			return 	new ResponseEntity<>(service.logar(loginDTO), HttpStatus.ACCEPTED);
		} catch (RuntimeException e) {
			return  new ResponseEntity<>("Usuário ou senha Inválida", HttpStatus.BAD_REQUEST);			
		}
	}
	
	@PutMapping("/altera-senha/{senhaTemporaria}")
	public ResponseEntity<?> alteraSenha(@RequestParam String senhaTemporaria) {
		try {
			return 	new ResponseEntity<>("Ainda não estamos alterando a senha", HttpStatus.ACCEPTED);
		} catch (RuntimeException e) {
			return  new ResponseEntity<>("Não foi possível alterar senha", HttpStatus.BAD_REQUEST);			
		}
	}
	
	@PostMapping("/nova-senha")
	public ResponseEntity<?> novaSenha(@RequestParam String novasenha) {
		try {
			return 	new ResponseEntity<>("Ainda não estamos alterando a senha", HttpStatus.ACCEPTED);
		} catch (RuntimeException e) {
			return  new ResponseEntity<>("Não foi possível alterar senha", HttpStatus.BAD_REQUEST);			
		}
	}
	
	
	
}
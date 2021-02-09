package sistemaBancario.resources;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sistemaBancario.dto.LoginDTO;
import sistemaBancario.dto.NovaSenhaDTO;
import sistemaBancario.services.LoginService;

import javax.validation.Valid;

@ApiResponses(value = {
		@ApiResponse(code = 202, message = "Retorna token sessao"),
		@ApiResponse(code = 400, message = "Usuario ou senha invalida")
})
@RestController
@RequestMapping("/")
public class LoginResource {
	@Autowired
	private LoginService service;

   
	@PostMapping("/login")
	public ResponseEntity<?> logar (@Valid @RequestBody LoginDTO loginDTO) throws Exception {
		try {
			return 	new ResponseEntity<>(service.logar(loginDTO), HttpStatus.ACCEPTED);
		} catch (RuntimeException e) {
			return  new ResponseEntity<>("Usuário ou senha Inválida", HttpStatus.BAD_REQUEST);			
		}
	}
	
	@PostMapping("/altera-senha")
	public ResponseEntity<?> alteraSenha(@Valid @RequestBody LoginDTO usuario) {
		try {
			return 	new ResponseEntity<>("Ainda não estamos alterando a senha", HttpStatus.ACCEPTED);
		} catch (RuntimeException e) {
			return  new ResponseEntity<>("Não foi possível alterar senha", HttpStatus.BAD_REQUEST);			
		}
	}
	
	@PostMapping("/nova-senha")
	public ResponseEntity<?> novaSenha(@RequestBody NovaSenhaDTO novaSenha) {
		try {
			return 	new ResponseEntity<>("Ainda não estamos alterando a senha", HttpStatus.ACCEPTED);
		} catch (RuntimeException e) {
			return  new ResponseEntity<>("Não foi possível alterar senha", HttpStatus.BAD_REQUEST);			
		}
	}
	
	
	
}
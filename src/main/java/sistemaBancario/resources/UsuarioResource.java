package sistemaBancario.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sistemaBancario.dto.UsuarioDTO;
import sistemaBancario.services.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioResource {

	@Autowired
	private UsuarioService service; 
	
	@PostMapping("/criar")
	public ResponseEntity<String> criarUsuario(@RequestBody UsuarioDTO usuarioDTO){
		service.cadastrar(usuarioDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body("Usuario Criado com sucesso");
	}
	

}
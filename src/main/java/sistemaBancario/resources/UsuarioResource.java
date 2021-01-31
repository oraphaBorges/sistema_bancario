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

import javax.validation.Valid;

@RestController
@RequestMapping("/usuario")
public class UsuarioResource {

	@Autowired
	private UsuarioService service;

	@PostMapping("/criar")
	public ResponseEntity<UsuarioDTO> cadastrar(@Valid @RequestBody UsuarioDTO usuarioDTO){
		return new ResponseEntity<>(service.cadastrar(usuarioDTO), HttpStatus.CREATED);
	}
}
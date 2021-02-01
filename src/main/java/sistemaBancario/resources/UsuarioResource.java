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

import sistemaBancario.dto.UsuarioDTO;
import sistemaBancario.services.UsuarioService;

import javax.validation.Valid;

@ApiResponses(value = {
		@ApiResponse(code = 201, message = "Retorna login do usuário criado"),
		@ApiResponse(code = 406, message = "Login existe cadastrado no sistema."),
		@ApiResponse(code = 400, message = "Ecorreu um erro desconhecido"),
})
@RestController
@RequestMapping("/usuarios")
public class UsuarioResource {

	@Autowired
	private UsuarioService service; 
	
	@PostMapping("/criar")
	public ResponseEntity<String> criarUsuario(@Valid @RequestBody UsuarioDTO usuarioDTO){
		try {
			service.cadastrar(usuarioDTO);
			return 	new ResponseEntity<>(String.format("Parabéns, usuario %s criado com sucesso!",usuarioDTO.getLogin()), HttpStatus.CREATED);
		} catch (IllegalStateException e) {
			return  new ResponseEntity<>(String.format("Usuario %s já existe no sistema e não pode ser criado, por favor tente um login diferente.",usuarioDTO.getLogin()), HttpStatus.NOT_ACCEPTABLE);			
		} catch (Exception e) {
			return  new ResponseEntity<>(String.format("Houve algum erro intento no cadasto e usuario não pode ser criado, por favor tente mais tarde.",usuarioDTO.getLogin()), HttpStatus.BAD_REQUEST);			
		} 
	}
	

}
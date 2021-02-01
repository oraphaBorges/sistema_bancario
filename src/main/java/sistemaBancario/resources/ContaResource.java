package sistemaBancario.resources;

import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import sistemaBancario.enums.Sigla;
import sistemaBancario.services.ContaService;

import java.time.LocalDate;

@ApiResponses(value = {
		@ApiResponse(code = 200, message = "Retornam os dados solicitados"),
		@ApiResponse(code = 202, message = "Retornam os dados solicitados"),
		@ApiResponse(code = 406, message = "Usuário não cadastrado"),
		@ApiResponse(code = 400, message = "Ocorreu um erro desconhecido ao realizar a requisição"),
})
@RestController
@RequestMapping("/conta")
public class ContaResource {
	
	@Autowired
	private ContaService service;
	
	@GetMapping("/extrato-periodo")
	public ResponseEntity<?> consultarExtratoPorPeriodo(@RequestParam String login, @RequestParam Sigla sigla, @RequestParam String dataInicio, @RequestParam String dataFim){
		try {
			return new ResponseEntity<>(service.consultarExtrato(login, sigla, LocalDate.parse(dataInicio), LocalDate.parse(dataFim)), HttpStatus.ACCEPTED);
		} catch (NullPointerException e) {
			return  new ResponseEntity<>(String.format("Usuario %s não existente no sistema, por favor confira os dados e tente novamentoe.",login), HttpStatus.NOT_ACCEPTABLE);			
		} catch (Exception e) {
			return  new ResponseEntity<>("Houve algum erro intento no cadasto e usuario não pode ser criado, por favor tente mais tarde.", HttpStatus.BAD_REQUEST);			
		} 
	}

	@GetMapping("/extrato")
	public ResponseEntity<?> consultarExtratoPorConta(@RequestParam String login, @RequestParam Sigla sigla){
		try {
			return 	new ResponseEntity<>(service.consultarExtrato(login, sigla), HttpStatus.OK);
		} catch (NullPointerException e) {
			return  new ResponseEntity<>(String.format("Usuario %s não existente no sistema, por favor confira os dados e tente novamentoe.",login), HttpStatus.NOT_ACCEPTABLE);			
		} catch (Exception e) {
			return  new ResponseEntity<>("Houve algum erro intento no cadasto e usuario não pode ser criado, por favor tente mais tarde.", HttpStatus.BAD_REQUEST);			
		} 
	}
}

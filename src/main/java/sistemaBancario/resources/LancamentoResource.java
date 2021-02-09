package sistemaBancario.resources;

import java.util.ArrayList;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import sistemaBancario.dto.LancamentoDTO;
import sistemaBancario.dto.PlanoContaDTO;
import sistemaBancario.enums.TipoOperacao;
import sistemaBancario.services.LancamentoService;
import sistemaBancario.services.PlanoContaService;

@ApiResponses(value = {
		@ApiResponse(code = 200, message = "Retorna login do usuário criado"),
		@ApiResponse(code = 400, message = "Ocorreu um erro ao realizar a requisição"),
})
@RestController
@RequestMapping("/lancamentos")
@CrossOrigin("*")
public class LancamentoResource {

	@Autowired
	private LancamentoService lancamentoService;
	@Autowired
	private PlanoContaService planoContaService;
	
    @PostMapping("/")
    public ResponseEntity<?> realizarLancamento(@RequestParam TipoOperacao operacao, @RequestBody LancamentoDTO lancamento){
		try {
			return new ResponseEntity<String>(lancamentoService.realizarOperacao(lancamento,operacao),HttpStatus.OK);
		} catch (ArithmeticException e) {
			return  new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);			
		} catch (NullPointerException e) {
			return  new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);			
		} catch (HttpMessageNotReadableException e) {
			return  new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);			
		} catch (Exception e) {
			return  new ResponseEntity<>(String.format("Houve algum erro nas operações causado pelos dados informados, por favor confira os dados e tente novamente."), HttpStatus.BAD_REQUEST);			
		} 
    }
    
    @GetMapping("/planos-conta/")
    public ResponseEntity<?> getPlanosConta(@RequestParam String login){
    	return new ResponseEntity<ArrayList<?>>(planoContaService.buscar(login),HttpStatus.OK);
    }
    
    @PostMapping("/planos-conta")
    public ResponseEntity<?> PostLancamento(@RequestBody PlanoContaDTO planoConta ) {
    	try {
    		planoContaService.cadastrar(planoConta.finalidade, planoConta.login);
    		return new ResponseEntity<String>("Cadatrada Plano de Conta com Sucesso",HttpStatus.OK);
    	}catch (IllegalStateException e) {
			return  new ResponseEntity<>(String.format("Plano de Conta %s já existe no sistema e não pode ser criado novamente, por favor tente um Plano de Conta diferente.",planoConta.finalidade), HttpStatus.NOT_ACCEPTABLE);			
		}catch (Exception e) {
			return  new ResponseEntity<>(String.format("Houve algum erro nas operações causado pelos dados informados, por favor confira os dados e tente novamente."), HttpStatus.BAD_REQUEST);			
		} 
    }
    
    
    
   
    
  
}
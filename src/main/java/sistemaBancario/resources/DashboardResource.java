package sistemaBancario.resources;

import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dashboard")
public class DashboardResource {
	
	@Autowired
	private DashboardService dashboardService;
	
    @GetMapping
    public ResponseEntity<?>  getMovimentacao(@RequestParam String inicio, String fim, String login){
		try {
			return new ResponseEntity<>(dashboardService.build(login, LocalDate.parse(inicio),LocalDate.parse(fim)),HttpStatus.OK);
		} catch (IllegalStateException e) {
			return  new ResponseEntity<>(String.format("Infelizmente a data de INÍCIO não pode ser maior que a data de FIM, por favor confira as informações e tente novamente."), HttpStatus.NOT_ACCEPTABLE);			
		} catch (NullPointerException e) {
			return  new ResponseEntity<>(String.format("Aparentemente esse usuário não existe no sistema, por favor confira as informações e tente novamente."), HttpStatus.NOT_ACCEPTABLE);			
		} catch (Exception e) {
    	return  new ResponseEntity<>(String.format("Houve algum erro intento no cadasto e usuario não pode ser criado, por favor tente mais tarde."), HttpStatus.BAD_REQUEST);			
		} 
    }
}
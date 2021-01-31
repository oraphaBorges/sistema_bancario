package sistemaBancario.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import sistemaBancario.dto.ContaDTO;
import sistemaBancario.dto.LancamentoDTO;
import sistemaBancario.enums.Sigla;
import sistemaBancario.services.ContaService;

import java.time.LocalDate;
import java.util.ArrayList;

@RestController
@RequestMapping("/conta")
public class ContaResource {
	
	@Autowired
	private ContaService service;
	
	@GetMapping("/extrato-periodo")
	public ResponseEntity<ArrayList<LancamentoDTO>> consultarExtratoPorPeriodo(@RequestParam String login, @RequestParam Sigla sigla, @RequestParam String dataInicio, @RequestParam String dataFim){
		return new ResponseEntity<>(service.consultarExtratoPorPeriodo(login, sigla, LocalDate.parse(dataInicio), LocalDate.parse(dataFim)), HttpStatus.ACCEPTED);
	}

	@GetMapping("/extrato")
	public ResponseEntity<ArrayList<LancamentoDTO>> consultarExtratoPorConta(@RequestBody ContaDTO contaDTO){
		return new ResponseEntity<>(service.consultarExtratoPorConta(contaDTO.getLogin(), contaDTO.getSigla()), HttpStatus.OK);
	}
}

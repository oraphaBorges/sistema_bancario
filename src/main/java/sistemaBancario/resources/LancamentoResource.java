package sistemaBancario.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sistemaBancario.dto.LancamentoDTO;
import sistemaBancario.models.Lancamento;
import sistemaBancario.repository.LancamentoRepository;

@RestController
@RequestMapping("/lancamentos")
@CrossOrigin("*")
public class LancamentoResource {

	@Autowired
	LancamentoRepository repository;
	
    @GetMapping("/{id}")
    public ResponseEntity<Lancamento> GetById(@PathVariable long id){
        return repository.findById(id).map(resp -> ResponseEntity.ok(resp))
        		.orElse(ResponseEntity.notFound().build()); 
    }
    
   
    
  
}
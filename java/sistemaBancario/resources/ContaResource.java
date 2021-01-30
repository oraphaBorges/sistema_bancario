package sistemaBancario.resources;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sistemaBancario.models.Conta;
import sistemaBancario.repository.ContaRepository;

@RestController
@CrossOrigin("*")
@RequestMapping("/conta")
public class ContaResource {
	
	@Autowired
	private ContaRepository repository; 
	
	
	//Metodo GetMapping ALL apenas para teste
//	@GetMapping
//	public ResponseEntity<List<Conta>> getAll(){
//		return ResponseEntity.ok(repository.findAll());
//	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Conta> getById(@PathVariable long id){
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public ResponseEntity<Conta> post(@RequestBody Conta conta){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(conta));
	}
	
	@PutMapping
	public ResponseEntity<Conta> put(@RequestBody Conta conta){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(conta));
	}
	
	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable Long id) {
		repository.deleteById(id);
	}
}

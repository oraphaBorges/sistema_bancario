package sistemaBancario.services;

import org.springframework.beans.factory.annotation.Autowired;

import sistemaBancario.models.PlanoConta;
import sistemaBancario.repository.PlanoContaRepository;

public class PlanoContaService {
	
	@Autowired
	private PlanoContaRepository repository;
	
//	public void cadastrar(String finalidade) {
//		if (repository.exists(finalidade))
//			throw new IllegalStateException("Finalidade já cadastrada anteriormente");
//		repository.create(new PlanoConta(finalidade));
//	}
	
}

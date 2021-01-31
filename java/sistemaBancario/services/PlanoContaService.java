package sistemaBancario.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sistemaBancario.models.PlanoConta;
import sistemaBancario.repository.PlanoContaRepository;

@Service
public class PlanoContaService {
	
	@Autowired
	private PlanoContaRepository repository;
	
	public void cadastrar(String finalidade) {
		PlanoConta plano = repository.getPlanoByFinalidade(finalidade);
		if (plano == null)
			throw new IllegalStateException("Finalidade já cadastrada anteriormente");

		repository.save(new PlanoConta(finalidade));
	}
	
}

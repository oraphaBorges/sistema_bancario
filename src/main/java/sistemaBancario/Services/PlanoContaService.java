package sistemaBancario.Services;

import sistemaBancario.models.PlanoConta;
import sistemaBancario.repository.PlanoContaRepository;

public class PlanoContaService {
	
	private PlanoContaRepository repository = new PlanoContaRepository();
	
	public void cadastrar(String finalidade) {
		if (repository.exists(finalidade))
			throw new IllegalStateException("Finalidade já cadastrada anteriormente");
		repository.create(new PlanoConta(finalidade));
	}
	
}

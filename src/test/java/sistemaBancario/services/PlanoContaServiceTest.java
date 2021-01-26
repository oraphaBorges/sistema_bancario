package sistemaBancario.services;

import sistemaBancario.models.PlanoConta;
import sistemaBancario.repository.PlanoContaRepository;

public class PlanoContaService {
	private static PlanoContaRepository repository = new PlanoContaRepository();
	
	public void cadatrar(String finalidade) {
		repository.create(new PlanoConta(finalidade));
	}
	public void cadatrar(PlanoConta planoConta) {
		repository.create(planoConta);
	}
}

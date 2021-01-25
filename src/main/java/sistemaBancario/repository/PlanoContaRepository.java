package sistemaBancario.repository;

import sistemaBancario.generics.RepositoryGeneric;
import sistemaBancario.models.PlanoConta;

public class PlanoContaRepository extends RepositoryGeneric<PlanoConta> {
	public PlanoConta findById(Integer id) {
		return em.find(PlanoConta.class, id);
	}
}

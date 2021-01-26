package sistemaBancario.repository;

import javax.persistence.Query;

import sistemaBancario.generics.RepositoryGeneric;
import sistemaBancario.models.PlanoConta;

public class PlanoContaRepository extends RepositoryGeneric<PlanoConta> {
	public PlanoConta findById(Integer id) {
		return em.find(PlanoConta.class, id);
	}

	public PlanoConta findByFinalidade(String finalidade) {
		return em.find(PlanoConta.class, finalidade);
	}

	public boolean exists(String finalidade) {
		Query query = em.createQuery("select u from PlanoConta u where u.finalidade = :finalidade"); // JPQL
		query.setParameter("finalidade", finalidade);
		return query.getResultList().size() != 0;
	}

}

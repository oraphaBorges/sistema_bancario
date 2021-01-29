package sistemaBancario.repository;

import javax.persistence.Query;

import org.springframework.data.jpa.repository.JpaRepository;

import sistemaBancario.generics.RepositoryGeneric;
import sistemaBancario.models.PlanoConta;

public interface PlanoContaRepository extends JpaRepository<PlanoConta, Long> {
	
	public PlanoConta findByFinalidade(String finalidade);

	/*
	 * VERIFICAR A UTILIZACAO DESSE METODO
	 * 
	 * public boolean exists(String finalidade) {
		Query query = em.createQuery("select u from PlanoConta u where u.finalidade = :finalidade"); // JPQL
		query.setParameter("finalidade", finalidade);
		return query.getResultList().size() != 0;
	}
	 */
	

}

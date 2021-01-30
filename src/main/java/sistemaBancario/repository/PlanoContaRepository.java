package sistemaBancario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import sistemaBancario.models.PlanoConta;

public interface PlanoContaRepository extends JpaRepository<PlanoConta, Long> {
	
	public PlanoConta findByFinalidade(String finalidade);


	@Query("select u from PlanoConta u where u.finalidade = :finalidade")
	public PlanoConta getPlanoByFinalidade(String finalidade);



}

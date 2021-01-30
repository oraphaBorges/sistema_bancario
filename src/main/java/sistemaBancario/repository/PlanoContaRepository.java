package sistemaBancario.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import sistemaBancario.models.PlanoConta;

public interface PlanoContaRepository extends JpaRepository<PlanoConta, Long> {
	
	public PlanoConta findByFinalidade(String finalidade);
		

}

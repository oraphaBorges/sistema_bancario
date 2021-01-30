package sistemaBancario.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sistemaBancario.models.PlanoConta;

import java.util.List;

public interface PlanoContaRepository extends JpaRepository<PlanoConta, Long> {

	PlanoConta getPlanoByFinalidadeAndUsuarioLogin(String finalidade, String login);
  
	List<PlanoConta> findPlanoContaByUsuarioLogin(String login);

}

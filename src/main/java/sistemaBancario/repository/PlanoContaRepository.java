package sistemaBancario.repository;

import org.springframework.data.repository.CrudRepository;

import sistemaBancario.models.PlanoConta;

import java.util.List;

public interface PlanoContaRepository extends CrudRepository<PlanoConta, Long> {

	PlanoConta getPlanoByFinalidadeAndUsuarioLogin(String finalidade, String login);
  
	List<PlanoConta> findPlanoContaByUsuarioLogin(String login);

}

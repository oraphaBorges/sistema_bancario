package sistemaBancario.repository;

import org.springframework.data.repository.CrudRepository;

import sistemaBancario.models.PlanoConta;

import java.util.ArrayList;
import java.util.Optional;

public interface PlanoContaRepository extends CrudRepository<PlanoConta, Long> {

	PlanoConta getPlanoByFinalidadeAndUsuarioLogin(String finalidade, String login);
  
	ArrayList<PlanoConta> findPlanoContaByUsuarioLogin(String login);

	Optional<PlanoConta> findByFinalidadeAndUsuarioLogin(String finalidade, String login);

}

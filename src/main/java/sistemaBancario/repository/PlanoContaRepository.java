package sistemaBancario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import sistemaBancario.models.PlanoConta;

public interface PlanoContaRepository extends JpaRepository<PlanoConta, Long> {

	PlanoConta getPlanoByFinalidadeAndUsuarioLogin(String finalidade, String login);

}

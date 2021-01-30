package sistemaBancario.services;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import sistemaBancario.models.PlanoConta;
import sistemaBancario.repository.PlanoContaRepository;

import javax.persistence.NoResultException;
import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class PlanoContaService {
	@Autowired
	private PlanoContaRepository repository;

	@Transactional
	public void cadastrar(String finalidade) {
		PlanoConta plano = repository.getPlanoByFinalidade(finalidade);
		if (plano != null)
			throw new IllegalStateException("Finalidade já cadastrada anteriormente");

		repository.save(new PlanoConta(finalidade));
	}

	@Transactional
	public void atualizar(long id, String finalidade){
		PlanoConta planoBD = repository.findById(id).orElseThrow(() -> new NoResultException("Plano de conta não registrado"));
		planoBD.setFinalidade(finalidade);

		repository.save(planoBD);
	}
	
}

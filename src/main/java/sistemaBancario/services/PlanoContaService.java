package sistemaBancario.services;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import sistemaBancario.models.Conta;
import sistemaBancario.models.PlanoConta;
import sistemaBancario.models.Usuario;
import sistemaBancario.repository.ContaRepository;
import sistemaBancario.repository.PlanoContaRepository;
import sistemaBancario.repository.UsuarioRepository;

import javax.persistence.NoResultException;
import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class PlanoContaService {
	@Autowired
	private PlanoContaRepository repository;
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Transactional
	public void cadastrar(String finalidade, String login) {
		PlanoConta plano = repository.getPlanoByFinalidadeAndUsuarioLogin(finalidade, login);
		if (plano != null)
			throw new IllegalStateException("Finalidade já cadastrada para esse login.");

		Usuario usuario = usuarioRepository.findByLogin(login);

		if (usuario == null)
			throw new NoResultException("Usuário não cadastrado no sistema.");

		repository.save(new PlanoConta(usuario, finalidade));
	}

	@Transactional
	public void atualizar(String login, String antigaFinalidade, String novaFinalidade){
		PlanoConta planoBd = repository.getPlanoByFinalidadeAndUsuarioLogin(novaFinalidade, login);
		if (planoBd != null)
			throw new IllegalStateException("Finalidade já cadastrada para esse usuário.");

		PlanoConta plano = repository.getPlanoByFinalidadeAndUsuarioLogin(antigaFinalidade, login);
		if (plano == null)
			throw new IllegalStateException("Finalidade não cadastrada para esse usuário. Por gentileza, realize o cadastro primeiro.");

		plano.setFinalidade(novaFinalidade);

		repository.save(plano);
	}
	
}

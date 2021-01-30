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
			throw new IllegalStateException("Finalidade já cadastrada para esse login!");

		Usuario usuario = usuarioRepository.findByLogin(login);

		if (usuario == null)
			throw new IllegalStateException("Usuário não cadastrado no sistema!");

		repository.save(new PlanoConta(usuario, finalidade));
	}

	@Transactional
	public void atualizar(long id, String finalidade){
		PlanoConta planoBD = repository.findById(id).orElseThrow(() -> new NoResultException("Plano de conta não registrado"));
		planoBD.setFinalidade(finalidade);

		repository.save(planoBD);
	}
	
}

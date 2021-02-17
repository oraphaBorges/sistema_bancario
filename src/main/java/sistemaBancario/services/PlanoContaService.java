package sistemaBancario.services;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import sistemaBancario.dto.PlanoContaDTO;
import sistemaBancario.models.PlanoConta;
import sistemaBancario.models.Usuario;
import sistemaBancario.repository.PlanoContaRepository;
import sistemaBancario.repository.UsuarioRepository;

import javax.persistence.NoResultException;
import javax.transaction.Transactional;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class PlanoContaService {
	@Autowired
	private PlanoContaRepository repository;
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Transactional
	public void cadastrar(String finalidade, String login) {
		usuarioExiste(login);

		if (finalidadeExiste(login, finalidade))
			throw new IllegalStateException("Finalidade já cadastrada para esse usuário.");

		Usuario usuario = usuarioRepository.findByLogin(login);

		repository.save(new PlanoConta(usuario, finalidade));
	}

	@Transactional
	public void atualizar(String login, String antigaFinalidade, String novaFinalidade) {
		usuarioExiste(login);

		if (finalidadeExiste(login, novaFinalidade))
			throw new IllegalStateException("Finalidade já cadastrada para esse usuário.");

		if (!finalidadeExiste(login, antigaFinalidade))
			throw new IllegalStateException(
					"Finalidade não cadastrada para esse usuário. Por gentileza, realize o cadastro primeiro.");

		PlanoConta plano = repository.getPlanoByFinalidadeAndUsuarioLogin(antigaFinalidade, login);
		plano.setFinalidade(novaFinalidade);

		repository.save(plano);
	}

	@Transactional
	public void deletar(String login, String finalidade) {
		usuarioExiste(login);

		PlanoConta planoBd = repository.getPlanoByFinalidadeAndUsuarioLogin(finalidade, login);
		if (planoBd == null)
			throw new NoResultException("Essa finalidade não existe para esse usuário!");

		repository.delete(planoBd);
	}

	private void usuarioExiste(String login) throws NoResultException {
		Usuario usuario = usuarioRepository.findByLogin(login);

		if (usuario == null)
			throw new NoResultException("Usuario não cadastrado no sistema.");
	}

	private boolean finalidadeExiste(String login, String finalidade) {
		PlanoConta plano = repository.getPlanoByFinalidadeAndUsuarioLogin(finalidade, login);
		if (plano == null)
			return false;
		return true;
	}

	public ArrayList<PlanoContaDTO> buscar(String login) {
		usuarioExiste(login);
		ArrayList<PlanoConta> planosConta = repository.findPlanoContaByUsuarioLogin(login);
		ArrayList<PlanoContaDTO> planosContaDTO = new ArrayList<PlanoContaDTO>();
		PlanoContaDTO planoContaDTO;
		for(PlanoConta pl:planosConta) {
			planoContaDTO = new PlanoContaDTO();
			planoContaDTO.finalidade = pl.getFinalidade(); 
			planoContaDTO.login = login;
			planosContaDTO.add(planoContaDTO);
		}
		return planosContaDTO;
	}

	public PlanoConta buscar(Long id) {
		Optional<PlanoConta> optional = repository.findById(id);
		return optional.get();
	}

	public PlanoConta buscar(String finalidade, String login) {
		if (!finalidadeExiste(login, finalidade))
			cadastrar(finalidade, login);
		return repository.getPlanoByFinalidadeAndUsuarioLogin(finalidade, login);

	}

}

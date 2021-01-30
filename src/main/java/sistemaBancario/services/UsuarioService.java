package sistemaBancario.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import sistemaBancario.enums.Sigla;
import sistemaBancario.models.Conta;
import sistemaBancario.models.PlanoConta;
import sistemaBancario.models.Usuario;
import sistemaBancario.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repository;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	public void cadastrar(Usuario usuario) {
		String passCrip = passwordEncoder.encode(usuario.getSenha());
		// TODO: CHECK IF EXIST
		if (repository.existsByLogin(usuario.getLogin()))
			throw new IllegalStateException("JÃ¡ existe um usuario com o login " + usuario.getLogin());
		usuario.setSenha(passCrip);
		usuario.addConta(new Conta("POUPANÇA", Sigla.POUPANCA, usuario));
		usuario.addConta(new Conta("CREDITO", Sigla.CREDITO, usuario));
		usuario.addConta(new Conta("CORRENTE", Sigla.CORRENTE, usuario));
		
		usuario.addPlanoConta(new PlanoConta("PAGAMENTO"));
		usuario.addPlanoConta(new PlanoConta("DEPOSITO"));
		usuario.addPlanoConta(new PlanoConta("TRANSFERENCIA"));
		repository.save(usuario);
	}
	
	public Usuario buscar(String login) {
		return repository.findByLogin(login);
	}

}

package sistemaBancario.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sistemaBancario.models.Usuario;
import sistemaBancario.models.Conta;
import sistemaBancario.enums.Sigla;
import sistemaBancario.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private ContaService contaService;
	@Autowired
	private PlanoContaService planoContaService;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Transactional
	public void cadastrar(Usuario usuario) {
		String passCrip = passwordEncoder.encode(usuario.getSenha());
		// TODO: CHECK IF EXIST
		// if (repository.exists(usuario.getLogin()))
		// throw new IllegalStateException("JÃ¡ existe um usuario com o login " +
		// usuario.getLogin());
		usuario.setSenha(passCrip);
		usuarioRepository.save(usuario);
		Conta conta;
		
		conta = new Conta("CREDITO", Sigla.CREDITO, usuario);
		contaService.cadastrar(conta);
		usuario.addConta(conta);

//		conta = new Conta("POUPANCA", Sigla.POUPANCA, usuario);
//		contaService.cadastrar(conta);
//		usuario.addConta(conta);
//		
//		conta = new Conta("CREDITO", Sigla.CORRENTE, usuario);
//		contaService.cadastrar(conta);
//		usuario.addConta(conta);
		
		usuarioRepository.save(usuario);
	}

	public Usuario buscar(String login) {
		Optional<Usuario> usuario = usuarioRepository.findByLogin(login);
		return usuario.get();
	}

}

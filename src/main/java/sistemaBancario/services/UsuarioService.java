package sistemaBancario.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

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
		//if (repository.exists(usuario.getLogin()))
		//	throw new IllegalStateException("JÃ¡ existe um usuario com o login " + usuario.getLogin());
		usuario.setSenha(passCrip);
		repository.save(usuario);
	}
	
	public Usuario buscar(String login) {
		return repository.findByLogin(login);
	}

}

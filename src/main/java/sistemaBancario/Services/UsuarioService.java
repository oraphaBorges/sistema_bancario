package sistemaBancario.Services;

import sistemaBancario.models.Usuario;
import sistemaBancario.repository.UsuarioRepository;

public class UsuarioService {

	private UsuarioRepository repository = new UsuarioRepository();

	public void cadastrar(Usuario usuario) {

		if (repository.exists(usuario.getLogin()))
			throw new IllegalStateException("JÃ¡ existe um usuario com o login " + usuario.getLogin());

		repository.create(usuario);

	}

	public Usuario buscarUsuario(String login) {
		return repository.findByLogin(login);
	}
	public Usuario buscarUsuario(Integer id) {
		return repository.findById(id);
	}

	public void alterarCadastro(Usuario usuario) {
		repository.update(usuario);		
	}

	public void excluirCadastro(Usuario usuario) {
		repository.delete(usuario);		
	}

}

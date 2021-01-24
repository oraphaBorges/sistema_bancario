package sistemaBancario.repository;

import sistemaBancario.generics.RepositoryGeneric;
import sistemaBancario.models.Usuario;

public class UsuarioRepository extends RepositoryGeneric<Usuario>{

	public Usuario findById(Integer id) {
		return em.find(Usuario.class, id);
	}
	
}

package sistemaBancario.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import sistemaBancario.models.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario,Long >{

	public Optional<Usuario> findById(String usuario);
	
	public Optional<Usuario> findByLogin(String login);
	
	//TODO:IMPLEMENTAR A VERIFICAÇÃO SE O USUARIO EXISTE
}
